import { useState } from 'react'
import Filter from './components/Filter'
import InputForm from './components/InputForm'
import PersonList from './components/PersonList'

const App = () => {
  const [persons, setPersons] = useState([
    { name: 'Arto Hellas', number: '040-123456', id: 1 },
    { name: 'Ada Lovelace', number: '39-44-5323523', id: 2 },
    { name: 'Dan Abramov', number: '12-43-234345', id: 3 },
    { name: 'Mary Poppendieck', number: '39-23-6423122', id: 4 }
  ])
  const [newName, setNewName] = useState('')
  const [newNumber, setNewNumber] = useState('')
  const [searchName, setSearchName] = useState('')

  //Use event handler to sync changes to input with component state for names
  const handleNameChange = (event) => {
    setNewName(event.target.value)
  }

  //Use event handler to sync changes to input with component state for number
  const handleNumberChange = (event) => {
    setNewNumber(event.target.value)
  }  

  //Use event handler to sync changes to input with component state for search
  const handleSearchChange = (event) => {
    setSearchName(event.target.value)
  }

  // Filter name based on user input. use .toLowerCase to prevent capitalization from being a factor
  const filteredPersons = persons.filter(person =>
    person.name.toLowerCase().includes(searchName.toLowerCase())
  )

  //Form component for adding notes
  const handleInput = (event) => {
    // Prevent page from resetting and wiping out user input
    event.preventDefault()
    ///Check if name already exist in array. Use .some method to iterate over 'persons' array
    const personExists = persons.some(person => person.name === newName)
    // Accept user input if name is not in array
    if (newName && newNumber){
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
    } else {
      // alert user that both names and numbers are needed
      alert('Both name and number are required')
    }
  }

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
      />
    </div>
  )
}

export default App
