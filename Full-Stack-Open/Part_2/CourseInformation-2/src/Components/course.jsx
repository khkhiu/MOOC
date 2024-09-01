import React from "react";
import Header from "./header";
import Content from "./content";

// Course component takes a course object as a prop and renders the course details
const Course = ({ course }) => {
    return (
      <div>
        <Header name={course.name} />
        {/* Render the course name using Header component*/}
        <Content parts={course.parts} />
        {/*Render the list of parts using Content component */}
      </div>
    );
  };

  
export default Course