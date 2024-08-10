/* EX 1.1
1. Refactor code to contain components: Header, Content, and Total. 
2. Passes the necessary data to each component using props. 
3. Header takes care of rendering the name of the course
4. Content renders the parts and their number of exercises
5. Total renders the total number of exercises.
*/

/* EX 1.2
Refactor the Content component so that it does not render any names of parts or their number of exercises by itself. 
Instead, it only renders three Part components of which each renders the name and number of exercises of one part.
Note: a new component name 'Part' needs to be created
*/

/* EX 1.3
Modify the variable definitions of the App component to use objects
Also refactor the application so that it still works
*/

/* EX 1.4
Place the objects into an array.
Modify the variable definitions of App into the following form and modify the other parts of the application accordingly.
However, do not pass different objects as separate props from the App component to the components Content and Total.
Instead, pass them directly as an array.
*/

/* EX 1.5
Change the course and its parts into a single JavaScript object. Fix everything that breaks.
*/

const Header = (props) => {
  console.log(props)
  return(
    <h1>{props.course.name}</h1>
  )
}

const Content = (props) => {
  console.log(props)
  return(
    <div>
      <p>{props.course.parts[0].name}: {props.course.parts[0].exercises}</p>
      <p>{props.course.parts[1].name}: {props.course.parts[1].exercises}</p>
      <p>{props.course.parts[2].name}: {props.course.parts[2].exercises}</p>
    </div>
  )
}

const Total = (props) => {
  console.log(props)
  return(
    <p>Number of exercises = {props.course.parts[0].exercises + props.course.parts[1].exercises + props.course.parts[2].exercises}</p>
  )

}

const App = () => {
  const course = {
    name: 'Half Stack application development',
    parts: [
      {
        name: 'Fundamentals of React',
        exercises: 10
      },
      {
        name: 'Using props to pass data',
        exercises: 7
      },
      {
        name: 'State of a component',
        exercises: 14
      }
    ]
  }

  return (
    <div>
      <Header course = {course}/>
      <Content course = {course}/>
      <Total course = {course}/>
    </div>
  )
}

/* EX 1.4
const Header = (props) => {
  console.log(props)
  return(
    <h1>{props.course}</h1>
  )
}

const Content = (props) => {
  console.log(props)
  return(
    <div>
      <p>{props.parts[0].name}: {props.parts[0].exercises}</p>
      <p>{props.parts[1].name}: {props.parts[1].exercises}</p>
      <p>{props.parts[2].name}: {props.parts[2].exercises}</p>
    </div>
  )
}

const Total = (props) => {
  console.log(props)
  return(
    <p>Number of exercises = {props.parts[0].exercises + props.parts[1].exercises + props.parts[2].exercises}</p>
  )

}

const App = () => {
  const course = 'Half Stack application development'
  const parts = [
    {
      name: 'Fundamentals of React',
      exercises: 10
    },
    {
      name: 'Using props to pass data',
      exercises: 7
    },
    {
      name: 'State of a component',
      exercises: 14
    }
  ]

  return (
    <div>
      <Header course = {course}/>
      <Content parts = {parts}/>
      <Total parts = {parts}/>
    </div>
  )
}
*/

/* Code for EX1.3
const App = () => {
  const course = 'Half Stack application development'
  const part1 = {
    name: 'Fundamentals of React',
    exercises: 10
  }
  const part2 = {
    name: 'Using props to pass data',
    exercises: 7
  }
  const part3 = {
    name: 'State of a component',
    exercises: 14
  }
  const total = part1.exercises + part2.exercises + part3.exercises

  return (
    <div>
      <h1>{course}</h1>
        <p>{part1.name}: {part1.exercises}</p>
        <p>{part2.name}: {part2.exercises}</p>
        <p>{part3.name}: {part3.exercises}</p>      
        <p>Total number of exercises: {total}</p>
    </div>
  )
}

export default App
*/

/* Code for EX 1.1 and 1.2 for reference
const Header = (props) => {
  console.log(props)
  return(
    <h1>{props.course}</h1>
  )
}

const Part = (props) =>{
  console.log(props)
  return(
    <p>
      {props.part} {props.exercises}
    </p>
  )

}

const Content = (props) => {
  console.log(props)
  return(
    <div>
      <Part part = {props.part1} exercises = {props.exercises1}/>
      <Part part = {props.part2} exercises = {props.exercises2}/>
      <Part part = {props.part3} exercises = {props.exercises3}/>
    </div>
  )
}

/*EX 1.1 code for reference
const Content = (props) => {
  console.log(props)
  return(
    <div>
      <p>part1 = {props.part1} exercises1 = {props.exercises1}</p>
      <p>part2 = {props.part2} exercises2 = {props.exercises2}</p>
      <p>part3 = {props.part3} exercises3 = {props.exercises3}</p>
    </div>
  )
}

const Total = (props) => {
  console.log(props)
  return(
    <p>Number of exercises = {props.total}</p>
  )

}

const App = () => {
  const course = 'Half Stack application development'
  const part1 = 'Fundamentals of React'
  const exercises1 = 10
  const part2 = 'Using props to pass data'
  const exercises2 = 7
  const part3 = 'State of a component'
  const exercises3 = 14
  const total = exercises1 + exercises2 + exercises3

  return (
    <div>
      <Header course = {course}/>
      <Content 
        part1 = {part1} exercises1 = {exercises1}
        part2 = {part2} exercises2 = {exercises2}
        part3 = {part3} exercises3 = {exercises3}
      /> 
      <Total total = {total}/>
    </div>
  )
}

export default App

/* Starter code for reference
const App = () => {
  const course = 'Half Stack application development'
  const part1 = 'Fundamentals of React'
  const exercises1 = 10
  const part2 = 'Using props to pass data'
  const exercises2 = 7
  const part3 = 'State of a component'
  const exercises3 = 14

  return (
    <div>
      <h1>{course}</h1>
      <p>
        {part1} {exercises1}
      </p>
      <p>
        {part2} {exercises2}
      </p>
      <p>
        {part3} {exercises3}
      </p>
      <p>Number of exercises {exercises1 + exercises2 + exercises3}</p>
    </div>
  )
}

export default App
*/

export default App
