# Creating and running React App

## npm 6.x (outdated, but still used by some):
npm create vite@latest part1 --template react

## npm 7+, extra double-dash is needed:
npm create vite@latest part1 -- --template react

## installing NPM
cd part1
npm install

## starting React App
npm run dev

# On Databases
create a file 'db.json'
npm install json-server
(use 'npm install -g json-server' to install globally)

## Run db without installing globally
npx json-server --port 3001 --watch db.json
('json-server --port 3001 --watch db.json' to run if installed gloablly)

## Axios, used to cmms between browser and server
npm install axios
('Next steps'
    Navigate to package.json
    Ensure there is an "axios": entry under "dependencies"
    Add     "server": "json-server -p3001 --watch db.json" under "scripts"
    replace '-p3001' with the appropriate port
)

(Alternatively use 'npm install json-server --save-dev')
