let xp = 0;
let health = 100;
let gold = 50;
let currentWeapon = 0;
let fighting;
let monsterHealth;
let inventory = ["stick"];

//Use const to declare read only variables
const button1 = document.querySelector("#button1");
const button2 = document.querySelector("#button2");
const button3 = document.querySelector("#button3");

const text = document.querySelector("#text");
const xpText = document.querySelector("#xpText");
const healthText = document.querySelector("#healthText");
const goldText = document.querySelector("#goldText");
const monsterStats = document.querySelector("#monsterStats");
const monsterName = document.querySelector("#monsterName");
const monsterHealthText = document.querySelector("#monsterHealth");

const weapons = [
  { name: 'stick', power: 5 },
  { name: 'dagger', power: 30 },
  { name: 'claw hammer', power: 50 },
  { name: 'sword', power: 100 }
];

const monsters = [
  {name: 'slime', level: 2, health: 15},
  {name: 'fanged beast', level: 8, health: 60},
  {name: 'dragon', level: 20, health: 300}
]

const locations = [
  {
    name: "town square",
    "button text": ["Go to store", "Go to cave", "Fight dragon"],
    "button functions": [goStore, goCave, fightDragon],
    text: "You are in the town square. You see a sign that says \"Store\"."
  },
  {
    name: "store",
    "button text": ["Buy 10 health (10 gold)", "Buy weapon (30 gold)", "Go to town square"],
    "button functions": [buyHealth, buyWeapon, goTown],
    text: "You enter the store."
  },
  {
    name: "cave",
    "button text": ["Fight slime", "Fight fanged beast", "Go to town square"],
    "button functions": [fightSlime, fightBeast, goTown],
    text: "You enter the cave. You see some monsters."
  },
  {
    name: "fight",
    "button text": ["Attack", "Dodge", "Run"],
    "button functions": [attack, dodge, goTown],
    text: "You are fighting a monster."
  },
  {
    name: "kill monster",
    "button text": ["Go to town square", "Go to town square", "Go to town square"],
    "button functions": [goTown, goTown, goTown],
    text: 'The monster screams "Arg!" as it dies. You gain experience points and find gold.'
  },
  {
    name: "lose",
    "button text": ["REPLAY?", "REPLAY?", "REPLAY?"],
    "button functions": [restart, restart, restart],
    text: "You died."
  },
  {
    name :"win",
    "button text": ["REPLAY?", "REPLAY?", "REPLAY?"],
    "button functions": [restart, restart, restart],
    text: "You defeat the dragon! YOU WIN THE GAME!" 
  },
  {
    name: "easter egg",
    "button text": ["2", "8", "Go to town square?"],
    "button functions": [pickTwo, pickEight, easterEgg],
    text: "You find a secret game. Pick a number above. Ten numbers will be randomly chosen between 0 and 10. If the number you choose matches one of the random numbers, you win!"
  }
];

// Init buttons
button1.onclick = goStore;
button2.onclick = goCave;
button3.onclick = fightDragon;

function update(location){

}

function update(location) {
  monsterStats.style.display = "none";
  // assign elements of arrays to respective locations
  button1.innerText = location["button text"][0];
  button2.innerText = location["button text"][1];
  button3.innerText = location["button text"][2];
  button1.onclick = location["button functions"][0];
  button2.onclick = location["button functions"][1];
  button3.onclick = location["button functions"][2];
  text.innerText = location.text;
  }
  
function goTown() {
  // FX call update and pass the first element of the 'location' array as an arg into update call
  update(locations[0]);
}
  
function goStore() {
  // FX call update and pass the second element of the 'location' array as an arg into update call
  update(locations[1]);
}

function goCave() {
  // FX call update and pass the third element of the 'location' array as an arg into update call    
  update(locations[2]);
}

function buyHealth() {
  if (gold >= 10){
  gold -= 10;
  health += 10;
  goldText.innerText = gold;
  healthText.innerText = health;
  } else {
    text.innerText = "You do not have enough gold to buy health."
  }
}

function buyWeapon() {
  // check if currentWeapon is less than the length of the weapons array. The index of the last element in an array is one less than the length of the array. Hence subtract 1
  if (currentWeapon < weapons.length - 1){
    if (gold >= 30) {
      gold -= 30;
      currentWeapon++;
      goldText.innerText = gold;
      //weapons[currentWeapon] is an object. Use dot notation to get the name property of that object.
      let newWeapon = weapons[currentWeapon].name;
      //Use concat operator to state weapon name
      text.innerText = "You now have a " + newWeapon + ".";
      //Push new newWeapon to end of inventory array using push() method
      inventory.push(newWeapon);
      //add new text to the end of text.innerText
      text.innerText += " In your inventory you have: " + inventory + ".";
    } else {
      text.innerText = "You do not have enough gold to buy a weapon."
    }
  } else {
    text.innerText = "You already have the most powerful weapon!";
    button2.innerText = "Sell weapon for 15 gold"
    button2.onclick = sellWeapon;
  }
}
function sellWeapon() {
  if (inventory.length > 1) {
    gold += 15;
    goldText.innerText = gold;
    let newWeapon = weapons[currentWeapon];
    text.innerText = "You now have a new weapon."
    //use 'let' to constraint scope of 'current' weapon to this function only
    //use 'shift()' method to take the first element of the inventory element and assign it to 'currentWeapon' variable
    let currentWeapon = inventory.shift();
    //use concat operator to set output text
    text.innerText = "You sold a " + currentWeapon + ".";
    //add more text using += operator
    text.innerText += " In your inventory you have: " + inventory;
  } else {
    text.innerText = "Don't sell your only weapon!";
  }
}

function fightSlime() {
  fighting = 0;
  goFight();
}

function fightBeast() {
  fighting = 1;
  goFight();
 }
 
function fightDragon() {
   fighting = 2;
   goFight();
 }

 function goFight() {
  update(locations[3])
  monsterHealth = monsters[fighting].health;
  monsterStats.style.display = "block";
  monsterName.innerText = monsters[fighting].name;
  monsterHealthText.innerText = monsterHealth;
}

function attack() {
  text.innerText = "The " + monsters[fighting].name + " attacks.";
  text.innerText += " You attack it with your " + weapons[currentWeapon].name + ".";
  //set health equal to health minus the return value of the getMonsterAttackValue function, and passes the level of the monster as an argument.
  health -= getMonsterAttackValue(monsters[fighting].level);
  // add a random number between 1 and the value of xp to your monsterHealth variable change.
  if (isMonsterHit()){
  monsterHealth -= weapons[currentWeapon].power + Math.floor(Math.random() * xp) + 1;
  } else {
    text.innerText += " You miss.";
  }
  healthText.innerText = health;
  monsterHealthText.innerText = monsterHealth;
  if (health <= 0){
    lose();
  } else if (monsterHealth <= 0){
    // if fighting dragon, call winGame FX, otherwise call defeatMonster FX
    // use ternary operator, syntax === condition ? true : false
    fighting === 2 ? winGame() : defeatMonster();
  }
  // add weapon degradation
  if (Math.random() <= .1 && inventory.length !== 1){
    text.innerText += " Your " + inventory.pop() + " breaks.";
    currentWeapon --;
  }
}

function getMonsterAttackValue(level){
  const hit = (level * 5) - (Math.floor(Math.random() * xp));
  console.log(hit);
  // prevent FX from returning a negative value
  return hit > 0 ? hit : 0;
}

function isMonsterHit(){
  return Math.random() > .2 || health < 20;
}

function dodge() {
  text.innerText = "You dodge the attack from the " + monsters[fighting].name;
}

function defeatMonster(){
  // add gold and xp
 gold += Math.floor(monsters[fighting].level * 6.7);
 xp += monsters[fighting].level;
 // update text
 goldText.innerText = gold;
 xpText.innerText = xp;
 update(locations[4]);
}

function lose(){
 update(locations[5]) 
}

function winGame(){
  update(locations[6])
}

function restart(){
  xp = 0;
  health = 100;
  gold = 50;
  currentWeapon = 0;
  inventory = "stick";
  xp.innerText = xp;
  health.innerText = health;
  gold.innerText = gold;
  goTown()
}

function easterEgg(){
  update(locations[7]);
}

function pick(guess){
  const numbers = []
  while (numbers.length < 10){
    numbers.push(Math.floor(Math.random() * 11))  
  }
  text.innerText = "You picked " + guess + ". Here are the random numbers:\n"
  for (let i = 1; i < 10; i++) {
    text.innerText += numbers[i] + "\n"
  }
  if (numbers.indexOf(guess) !== -1) {
    text.innerText += "Right! You win 20 gold!";
    gold += 20;
    goldText.innerText = gold;
  } else {
    text.innerText += "Wrong! You lose 10 health!";
    health -= 10;
    healthText.innerText = health;
    if(health <= 0){
      lose();
    }
  }
}
function pickTwo(){
  pick(2);
}

function pickEight(){
  pick(8);
}