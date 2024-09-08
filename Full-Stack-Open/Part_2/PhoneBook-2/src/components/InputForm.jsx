import React from "react"

const InputForm = ({ newName, newNumber, handleNameChange, handleNumberChange, handleInput}) => (
    <form onSubmit={handleInput}>
        <div>
        name: <input value={newName} onChange={handleNameChange} />
        </div>
        <div>
        number: <input value={newNumber} onChange={handleNumberChange} />
        </div>
        <div>
        <button type="submit">add</button>
        </div>
  </form>
)

export default InputForm