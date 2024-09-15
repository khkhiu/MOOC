import { useState, useEffect } from 'react'
import Filter from './components/Filter'
import InputForm from './components/InputForm'
import PersonList from './components/PersonList'
import noteService from './services/notes'

const App = () => {
  const [persons, setPersons] = useState([])
  const [newName, setNewName] = useState('')
  const [newNumber, setNewNumber] = useState('')
  const [searchName, setSearchName] = useState('')

  //Use event handler to sync changes to input with component state for names
  const handleNameChange = (event) => {setNewName(event.target.value)}
  //Use event handler to sync changes to input with component state for number
  const handleNumberChange = (event) => {setNewNumber(event.target.value)}  
  //Use event handler to sync changes to input with component state for search
  const handleSearchChange = (event) => {setSearchName(event.target.value)}

  // Filter name based on user input. use .toLowerCase to prevent capitalization from being a factor
  const filteredPersons = persons.filter(person =>
    person.name.toLowerCase().includes(searchName.toLowerCase())
  )

  // Use useEffect to fetch information for json
  useEffect(() => {
    noteService
      .getAll()
      .then(data => {setPersons(data)})
  }, []);

  /*
  useEffect(() => {
    //Send get request to URL
    fetch('http://localhost:3001/persons')
      //Converts response to JSON
      .then(response => response.json())
      //Update persons with fetched data
      .then(data => setPersons(data));
  }, []);
  */
  //Form component for adding notes
  const handleInput = (event) => {
    // Prevent page from resetting and wiping out user input
    event.preventDefault()
    ///Check if name already exist in array. Use .find method to iterate over 'persons' array
    //.find -> To find and return the first element in the array that satisfies the provided testing function.
    //The first matching element from the array. If no element matches the criteria, it returns undefined.
    //.some -> To test if at least one element in the array satisfies the provided testing function.
    //true if at least one element matches the condition, otherwise false.
    const personExists = persons.find(person => person.name === newName)
    if (newName && newNumber) {
      if (personExists) {
        const confirmed = window.confirm(`${newName} is already added to phonebook, replace the old number with a new one?`);
        if (confirmed) {
          // use update method to update information
          noteService.update(personExists.id, { ...personExists, number: newNumber })
            .then(updatedPerson => {
              setPersons(persons.map(person => person.id !== personExists.id ? person : updatedPerson));
              setNewName('');
              setNewNumber('');
            })
            .catch(error => console.error('Error updating person:', error));
        }
      } else {
        noteService.create({ name: newName, number: newNumber })
          .then(newPerson => {
            setPersons(persons.concat(newPerson));
            setNewName('');
            setNewNumber('');
          })
          .catch(error => console.error('Error adding person:', error));
      }
    /* Old code for reference
    if (newName && newNumber){
      if (!personExists) {
        try {
          const newPerson = { name: newName, number: newNumber };
          noteService.create(newPerson)
          .then(data => {
            setPersons(persons.concat(data));
            setNewName('');
            setNewNumber('');
          })
        } catch (error) {
          console.error('Error adding person:', error);
        }
        
        // Add the new name to the list of persons
        const newPerson = { name: newName, number: newNumber };
        //Send post request to server to add person
        fetch('http://localhost:3001/persons', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          //Converts newPerson into a JSON string to send in the request body
          body: JSON.stringify(newPerson),
        })
        //Convert response form server into JSON format
        .then(response => response.json())
        // OPS for after data is received
        .then(data => {
          // Updates state by adding person to list of existing persons
          setPersons(persons.concat(data));
          //Clears the input field
          setNewName('');
          setNewNumber('');
        })
        // Catch errors when fetching data
        .catch(error => console.error('Error fetching data:', error))
      // Old code for reference
      if(!personExists){
        // Add the new name to the list of persons
        setPersons(persons.concat({ name: newName, number: newNumber }))
        // Clear the input field
        setNewName('') 
        setNewNumber('')
      
      } else {
        // alert user if name is already in the array
        alert(`${newName} is already added to phonebook`)
      }
        */
    } else {
      // alert user that both names and numbers are needed
      alert('Both name and number are required')
    }
  }

  // Component for deleting entires for DB
  const handleDelete = (id, name) => {
    window.confirm(`delete ${name}?`);
      {
        noteService.remove(id)
          .then(() => {
            setPersons(persons.filter(person => person.id !== id));
          })
      }
  };

  return (
    <div>
      <h2>Phonebook</h2>
      <Filter 
        searchName={searchName} 
        handleSearchChange={handleSearchChange} 
      />
      <h2>Add new</h2>
      <InputForm 
        newName={newName} 
        newNumber={newNumber} 
        handleNameChange={handleNameChange} 
        handleNumberChange={handleNumberChange} 
        handleInput={handleInput} 
      />
      <h2>Numbers</h2>
      <PersonList 
        persons={filteredPersons} 
        handleDelete={handleDelete} 
      />
    </div>
  )
}

export default App
