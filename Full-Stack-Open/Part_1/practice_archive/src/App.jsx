// Functions returning functions, passing event handlers to child components, do not define components in components

import { useState } from "react"

const Display = props => <div>{props.value}</div>

const Button = (props) => (
  <button onClick={props.handleClick}>
    {props.text}
  </button>
)

const App = () => {
  const [value, setValue] = useState(0)

  const setToValue = newValue => {
    console.log('value now', newValue)
    setValue(newValue)
  }

  return (
    <div>
      <Display value={value} />
      <Button handleClick={() => setToValue(1000)} text="thousand" />
      <Button handleClick={() => setToValue(0)} text="reset" />
      <Button handleClick={() => setToValue(value + 1)} text="increment" />
    </div>
  )
}

//Arrays, asynchronous update, conditional rendering
/*
import { useState } from "react"

const History = (props) => {
  if (props.allClicks.length === 0){
    return (
      <div>
        The app is used by pressing buttons
      </div>
    )
  }
  return (
    <div>
      Button press history: {props.allClicks.join(' ')}
    </div>
  )
}

const Button = ({handleClick, text}) => (
  <button onClick={handleClick}>
    {text}
  </button>
)

const App = () => {
  const [left, setLeft] = useState(0)
  const [right, setRight] = useState(0)
  const [allClicks, setAll] = useState([])
  const [total, setTotal] = useState(0)

  const handleLeftClick = () => {
    setAll(allClicks.concat('L'))
    console.log('left before', left)
    const updatedLeft = left + 1
    setLeft(updatedLeft)
    console.log('left after', updatedLeft)
    setTotal(updatedLeft + right)
  }

  const handleRightClick = () => {
    setAll(allClicks.concat('R'))
    console.log('right before', right)
    const updatedRight = right + 1
    setRight(updatedRight)
    console.log('right after', updatedRight)
    setTotal(left + updatedRight)
  }

  return (
    <div>
      {left}
      <Button handleClick={handleLeftClick} text='Left'/>
      <Button handleClick={handleRightClick} text='Right'/>
      {right}
      <History allClicks={allClicks}/>
      <p>Total {total}</p>
    </div>
  )
}
*/

// Complex state
/*
import { useState } from "react"

const App = () => {
  const [clicks, setClicks] = useState({
    left: 0, right: 0
  })

  const handleLeftClick = () => {
    const newClicks = {
      left: clicks.left + 1,
      right: clicks.right
    }
    setClicks(newClicks)
  }

  const handleRightClick = () => {
    const newClicks = {
      left: clicks.left,
      right: clicks.right + 1
    }
    setClicks(newClicks)
  }

  return (
    <div>
      {clicks.left}
      <button onClick={handleLeftClick}>Left</button>
      <button onClick={handleRightClick}>Right</button>
      {clicks.right}
    </div>
  )
}
*/

//Re-rendering during state change
/*
import { useState } from "react"

const App = () => {
  const [counter, setCounter] = useState(0)
  console.log('rendering with counter value', counter)

  const Display = ({ counter }) => <div>{counter}</div>

  const Button = ({ onSmash, text }) => <button onClick={onSmash}>{text}</button>

  const increaseByOne = () => {
    console.log('increasing, value before', counter)    
    setCounter(counter + 1)
  }

  const decreaseByOne = () => { 
    console.log('decreasing, value before', counter)    
    setCounter(counter - 1)
  }

  const setToZero = () => {
    console.log('resetting to zero, value before', counter)    
    setCounter(0)
  }

  return (
    <div>
      <Display counter={counter} />
      <Button onClick={increaseByOne} text="plus" />
      <Button onClick={setToZero} text="zero" />
      <Button onClick={decreaseByOne} text="minus" />
    </div>
  )
} 
*/
//Passing state to child components
/*
import { useState } from "react"

const App = () => {
  const [ counter, setCounter ] = useState(0)

  const Display = (props) => {
    return (
      <div>{props.counter}</div>
    )
  }

  const Button = (props) => {
    return (
      <button onClick={props.onClick}>
        {props.text}
      </button>
    )
}

  const increaseByOne = () => setCounter(counter + 1)    
  const decreaseByOne = () => setCounter(counter - 1)
  const setToZero = () => setCounter(0)
  
  
  return (
    <div>
      <Display 
        counter={counter}
      />     
      
      <Button
        onClick={increaseByOne}
        text='plus'
      />
      
      <Button 
        onClick={setToZero} 
        text="zero"
      />
      
      <Button        
        onClick={decreaseByOne}        
        text='minus'      
      />   

    </div>
  )
}
*/

//Event handler as a functions
/*
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
*/

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