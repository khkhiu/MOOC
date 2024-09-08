import React from "react";

const PersonList = ({ persons }) => (
    <ul>
    {/*Use map to render list of names */}
    {persons.map((person, index) => (
      <li key={index}>{person.name} {person.number}</li>
    ))}
  </ul>
)

export default PersonList