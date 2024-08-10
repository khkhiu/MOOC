/* EX 1.1 - COMPLETE
1. Refactor code to contain components: Header, Content, and Total. 
2. Passes the necessary data to each component using props. 
3. Header takes care of rendering the name of the course
4. Content renders the parts and their number of exercises
5. Total renders the total number of exercises.
*/

/* EX 1.2 - COMPLETE
Refactor the Content component so that it does not render any names of parts or their number of exercises by itself. 
Instead, it only renders three Part components of which each renders the name and number of exercises of one part.
Note: a new component name 'Part' needs to be created
*/

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
*/
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

/* Old code for reference
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