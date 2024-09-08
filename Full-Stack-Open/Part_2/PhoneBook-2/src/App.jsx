import { useState } from 'react'

const App = () => {
  const [persons, setPersons] = useState([
    { name: 'Arto Hellas' }
  ]) 
  const [newName, setNewName] = useState('')

  //Use event handler to sync changes to input with component state
  const handleNameChange = (event) => {
    setNewName(event.target.value)
  }

  //Form component for adding notes
  const handleInput = (event) => {
    // Prevent page from resetting and wiping out user input
    event.preventDefault()
    ///Check if name already exist in array. Use .some method to iterate over 'persons' array
    const personExists = persons.some(person => person.name === newName)
    // Accept user input if name is not in array
    if (newName && !personExists){
    // Add the new name to the list of persons
    setPersons(persons.concat({ name: newName }))
    // Clear the input field
    setNewName('') 
    } else if (personExists){
      // alert user if name is already in the array
      alert(`${newName} is already added to phonebook`)
    }
  }

  return (
    <div>
      <h2>Phonebook</h2>
      <form onSubmit={handleInput}>
        <div>
          name: <input value={newName} onChange={handleNameChange} />
        </div>
        <div>
          <button type="submit">add</button>
        </div>
      </form>
      <h2>Numbers</h2>
      <ul>
        {/*Use map to render list of names */}
        {persons.map((person, index) => (
          <li key={index}>{person.name}</li>
        ))}
      </ul>
    </div>
  )
}

export default App
