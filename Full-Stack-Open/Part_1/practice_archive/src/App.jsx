//Event handler as a functions
import { useState } from 'react'


const App = () => {
  const [ counter, setCounter ] = useState(0)

  const increaseByOne = () => setCounter(counter + 1)    
  const setToZero = () => setCounter(0)
  
  
  return (
    <div>
      <div>{counter}</div>
      <button onClick={increaseByOne}>        
        plus
      </button>
      <button onClick={setToZero}>        
        zero
      </button>
    </div>
  )
}


// Fun with state hooks and event handling
/*
import { useState } from 'react'


const App = () => {

  const [ counter, setCounter] = useState(0)

  setTimeout(() => setCounter(counter + 1),1000)

  console.log('rendering:', counter)

  return (
    <div>{counter}
      <button onClick={() => setCounter(0)}>
        Reset counter
      </button>
    </div>
  )
}
*/
/*
const App = (Apps) => {
  const {counter} = props

  return(
    <div>{counter}</div>
  )
}
*/

/*Using destructures */
/*
const Hello = (props) => {
  //Alt props usage: const Hello = ({name, age}) => {} 
  const {name, age} = props
  const bornYear = () => new Date().getFullYear() - age

  return (
    <div>
      <p>Hello {name}, you are {age} years old</p>
      <p>So you were probably born in {bornYear()}</p>
    </div>
  )
}

const App = () => {
  const name = 'Peter'
  const age = 10

  return (
    <div>
      <h1>Greetings</h1>
      <Hello name="Maya" age={26 + 10} />
      <Hello name={name} age={age} />
    </div>
  )
}
*/
/* original code for reference
const Hello = (props) => {
  const bornYear = () => {
    const yearNow = new Date().getFullYear()
    return yearNow - props.age
  }  
  return (
    <div>
      <p>
        Hello {props.name}, you are {props.age} years old
      </p>
      <p>So you were probably born in {bornYear()}</p>
    </div>
  )
}

const App = () => {
  const name = 'Peter'
  const age = 10

  return (
    <div>
      <h1>Greetings</h1>
      <Hello name="Maya" age={26 + 10} />
      <Hello name={name} age={age} />
    </div>
  )
}
*/
export default App