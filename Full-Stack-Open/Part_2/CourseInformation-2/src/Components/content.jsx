import React from "react";
import Part from "./part";

// Content component takes a list of parts as a prop and renders each part
// Also calculate the total number of exercises
const Content = ({ parts }) => {

    // Calculate the total number of exercises using reduce
    const totalExercises = parts.reduce((sum, part) => sum + part.exercises, 0);
  
    return (
      <div>
        {parts.map(part => (
          <Part key={part.id} part={part} />
          /* Render each part using Part component*/
        ))}
        <p><strong>Total exercises: {totalExercises}</strong></p>  
        {/* Display the total number of exercises*/}
      </div>
    );
  };

export default Content