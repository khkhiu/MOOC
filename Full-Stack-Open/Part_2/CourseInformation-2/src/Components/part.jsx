import React from "react";

// Part component takes a single part object as a prop and renders its details
const Part = ({ part }) => {
    return (
      <div>
        <p>{part.name} {part.exercises}</p>
        {/*Display the name and number of exercises for the part*/}
      </div>
    );
  };
  
export default Part  