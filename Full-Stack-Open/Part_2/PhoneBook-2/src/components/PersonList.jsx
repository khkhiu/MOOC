import React from "react";

const PersonList = ({ persons, handleDelete }) => (
    <ul>
    {/*Use map to render list of names */}
    {persons.map((person, index) => (
      <li key={index}>{person.name} {person.number}
      <button onClick={() => handleDelete(person.id, person.name)}>delete</button>
      </li>
    ))}
  </ul>
)

export default PersonList