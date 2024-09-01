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

// Header component takes the course name as a prop and renders it as an h1 element
const Header = ({ name }) => {
  return <h1>{name}</h1>;
};

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

// Part component takes a single part object as a prop and renders its details
const Part = ({ part }) => {
  return (
    <div>
      <p>{part.name} {part.exercises}</p>
      {/*Display the name and number of exercises for the part*/}
    </div>
  );
};



const App = () => {
  const course = {
    id: 1,
    name: 'Half Stack application development',
    parts: [
      {
        name: 'Fundamentals of React',
        exercises: 10,
        id: 1
      },
      {
        name: 'Using props to pass data',
        exercises: 7,
        id: 2
      },
      {
        name: 'State of a component',
        exercises: 14,
        id: 3
      },
      {
        name: 'Redux',
        exercises: 11,
        id: 4
      }      
    ]
  }

  return <Course course={course} />
}

export default App