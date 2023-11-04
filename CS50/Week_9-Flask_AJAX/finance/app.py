import os

from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session
from flask_session import Session
from tempfile import mkdtemp
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import apology, login_required, lookup, usd

# API key = pk_54634fd787e44b9d9643a6f6c41d505e

# Configure application
app = Flask(__name__)

# Custom filter
app.jinja_env.filters["usd"] = usd

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")

# Make sure API key is set
if not os.environ.get("API_KEY"):
    raise RuntimeError("API_KEY not set")


@app.after_request
def after_request(response):
    """Ensure responses aren't cached"""
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response


@app.route("/")
@login_required
def index():
    """Show portfolio of stocks"""
    # Select stock portfolio of user
    portfolio = db.execute("SELECT symbol, SUM(SHARES) as total_shares FROM portfolio WHERE user_id = :id GROUP BY symbol HAVING total_shares > 0",
                           id=session["user_id"])
    # Select cash total of a user
    cash = db.execute("SELECT cash FROM users WHERE id = :id", id=session["user_id"])[0]["cash"]

    # Get cash value
    total_value = cash
    # assign total value amount of stocks and cash
    final_total = cash

    # Add stock name, current stock value and total value
    for row in portfolio:
        look = lookup(row['symbol'])
        row['name'] = look['name']
        row['price'] = look['price']
        row['total'] = row['price'] * row['shares']
        total_value += row["value"]
        final_total += row["value"]

        # Convert to prices to USD
        # row['price'] = usd(row['price'])
        # row['total'] = usd(row['total'])

    return render_template("index.html", row=portfolio, total_value=total_value, final_total=final_total)


@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    """Buy shares of stock"""
    # Display buy.html if request method is GET
    if request.method == "GET":
        return render_template("buy.html")
    # If request method if POST
    else:
        # Save stock symobl, number of shares availabel, and quote
        symbol = request.form.get("symbol")
        shares = request.form.get("shares")
        quote = lookup(symbol)

        # Error 400 if symbol is not available
        if quote == None:
            return apology("Stock symbol invalid", 400)

        # Error 400 if shares not positive integer
        if not shares:
            return apology("Shares invalid", 400)

        # cast symbol to uppercase and cast shares to int, in order to work with them
        symbol = symbol.upper()
        shares = int(shares)
        purchase = quote['price'] * shares

        # Check if users can afford current stock
        # select this user's cash balance from users table
        cash_balance = db.execute("SELECT cash FROM users WHERE id = :id", id=session["user_id"])
        cash_balance = cash_balance[0]['cash']
        cash_remainning = cash_balance - purchase

        # Error 400 is not enough cash
        if cash_remainning < 0:
            return apology("insufficient funds", 400)

        # Query portfolio for row with user_id and stock symbol:
        row = db.execute("SELECT * FROM portfolio WHERE user_id = :id AND symbol = :symbol",
                         id=session["user_id"], symbol=symbol)

        # Create row if it does not exsist, but do not update shares
        if len(row) != 1:
            db.execute("INSERT INTO portfolio (user_id, symbol) VALUES (:id, :symbol)",
                       id=session["user_id"], symbol=symbol)

        # Query currently owned shares
        owned_shares = db.execute("SELECT shares FROM portfolio WHERE user_id = :id AND symbol = :symbol",
                                  id=session["user_id"], symbol=symbol)

        owned_shares = owned_shares[0]["shares"]

        # Add newly purchased shares
        new_shares = owned_shares + shares

        # Update shares in portfolio table
        db.execute("UPDATE portfolio SET shares = :newshares WHERE userid = :id AND symbol = :symbol",
                   newshares=new_shares, id=session["user_id"], symbol=symbol)

        # Update cash balance in users table
        db.execute("UPDATE users SET cash = :remainder WHERE id = :id",
                   remainder=cash_remainning, id=session["user_id"])

        # Update history table
        db.execute("INSERT INTO history (userid, symbol, shares, method, price) VALUES (:userid, :symbol, :shares, 'Buy', :price)",
                   userid=session["user_id"], symbol=symbol, shares=shares, price=quote['price'])

    # redirect to index page
    return redirect("/")


@app.route("/history")
@login_required
def history():
    """Show history of transactions"""
    info = db.execute("SELECT * FROM history WHERE userid = :userid", userid=session["user_id"])
    return render_template("hitory.html", info=info)


@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # Forget any user_id
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # Ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username", 400)

        # Ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password", 400)

        # Query database for username
        rows = db.execute("SELECT * FROM users WHERE username = ?", request.form.get("username"))

        # Ensure username exists and password is correct
        if len(rows) != 1 or not check_password_hash(rows[0]["hash"], request.form.get("password")):
            return apology("invalid username and/or password", 400)

        # Remember which user has logged in
        session["user_id"] = rows[0]["id"]

        # Redirect user to home page
        return redirect("/")

    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")


@app.route("/logout")
def logout():
    """Log user out"""

    # Forget any user_id
    session.clear()

    # Redirect user to login form
    return redirect("/")


@app.route("/quote", methods=["GET", "POST"])
@login_required
def quote():
    """Get stock quote."""
    # Return quote.html if used GET method
    if request.method == "GET":
        return render_template("quote.html")
    # Check if stock is valid if POST method is used
    else:
        # lookup stock symbol from quote.html
        symbol = lookup(request.form.get("symbol"))
        # Invalid stock if symbol does not appear
        if symbol == None:
            return apology("invalid stock symbol", 400)
        else:
            return render_template("quoted.html", symbol=symbol)


@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user"""

    # Forget any user_id
    session.clear()

    # User reach destination by submitting a form using POST
    if request.method == "POST":

        # Ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username", 400)

        # Ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password", 400)

        # Confirm password
        elif not request.form.get("confirmation"):
            return apology("must confirm password", 400)

        # Ensure passwords are the same
        elif request.form.get("password") != request.form.get("confirmation"):
            return apology("Passwords must match", 400)

        # save username and password hash in variables
        username = request.form.get("username")
        password = generate_password_hash(request.form.get("password"))

        # Check if username is already taken
        rows = db.execute("SELECT * FROM users WHERE username = :username", username=username)
        if len(rows) != 0:
            return apology("username in use, choose another username", 400)

        # add username and hash into DB
        db.execute("INSERT INTO users (username, hash) VALUES (:username, :hash)", username=username, hash=password)

        # Query DB for newly created user
        rows = db.execute("SELECT * FROM users WHERE username = :username", username=username)

        # Remember user log in
        session["user_id"] = rows[0]["id"]

        # Redirect to login page
        return redirect("/")

    # User reach destination by clicking a link or redirect
    else:
        return render_template("register.html")


@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    """Sell shares of stock"""
    # Display sell.html if request method is GET
    if request.method == "GET":
        # Retrieve user's current stocks
        user_portfolio = db.execute("SELECT symbol FROM portfolio WHERE userid = :id", id=session["user_id"])
        return render_template("sell.html", portfolio=portfolio)

    # To sell stock
    else:
        # select this user's cash balance from users table
        symbol = request.form.get("symbol")
        shares = request.form.get("shares")
        quote = lookup(symbol)
        rows = db.execute("SELECT * FROM portfolio WHERE userid = :id AND symbol = :symbol", id=session["user_id"], symbol=symbol)

        # Error 400 if symbol is not available
        if len(rows) != 1:
            return apology("Stock symbol invalid", 400)

        # Error 400 if shares not positive integer
        if not shares:
            return apology("Shares invalid", 400)

        # Find current shares of selected stock
        owned_shares = rows[0]['shares']

        # Convert shares to int
        shares = int(shares)

        # Error 400 if trying to sell more shares than currently owned
        if shares > owned_shares:
            return apology("Not enough shares owned", 400)

        # Obtain current values of shares
        shares_sold_value = quote['price'] * shares

        # Add value of sold shares to cash balance
        cash = db.execute("SELECT cash FROM users WHERE id = :id", id=session['user_id'])
        cash = cash[0]['cash']
        cash = cash + sahres_sold_value

        # Update cash
        db.execute("UPDATE users SET cash = :cash WHERE id = :id", cash=cash, id=session["user_id"])

        # Subtract shares sold
        new_shares = owned_shares - shares

        # Update portfolio table with new shares amount
        if shares > 0:
            db.execute("UPDATE portfolio SET shares = :newshares WHERE userid = :id AND symbol = :symbol",
                       newshares=new_shares, id=session["user_id"], symbol=symbol)

        # Delete stock row because if no shares remain
        else:
            db.execute("DELETE FROM portfolio WHERE symbol = :symbol AND userid = :id",
                       symbol=symbol, id=session["user_id"])

        # Update history table
        db.execute("INSERT INTO history (userid, symbol, shares, method, price) VALUES (:userid, :symbol, :shares, 'Sell', :price)",
                   userid=session["user_id"], symbol=symbol, shares=shares, price=quote['price'])

        # Redirect to index page
        return redirect("/")
