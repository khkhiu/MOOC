import { useState } from 'react'

const Button = ({handleClick, text}) => (
  <button onClick={handleClick}>
    {text}
  </button>
)

const StatisticLine = ({text, value}) => {
  return(
    <tr>
    <td>{text}</td>
    <td>{value}</td>
  </tr>
  )
}

const Statistics = ({good, neutral, bad, all}) => {
  if (all === 0){
    return (
      <div>
        <h1>Statistics</h1>
        No feedback given yet
      </div>
    )
  } else {
    return (
      <div>
        <h1>Statistics</h1>
          <table>
            <tbody>
            <StatisticLine text="Good" value={good}/>
            <StatisticLine text="Neutral" value={neutral}/>
            <StatisticLine text="Bad" value={bad}/>
            <StatisticLine text="All" value={all}/>
            <StatisticLine text="Average" value={(good-bad)/all}/>
            <StatisticLine text="Good" value={(good/all)*100+'%'}/>
            </tbody>
          </table>
      </div>
    )
  }
}

const App = () => {
  // save clicks of each button to its own state
  const [good, setGood] = useState(0)
  const [neutral, setNeutral] = useState(0)
  const [bad, setBad] = useState(0)
  const [all, setAll] = useState(0)

  const handleGoodClick = () =>{
    console.log('Good before', good)
    const updatedGood = good + 1
    setGood(updatedGood)
    console.log('Good after', updatedGood)
    setAll(updatedGood + neutral + bad)
  }

  const handleNeutralClick = () =>{
    console.log('Neutral before', neutral)
    const updatedNeutral = neutral + 1
    setNeutral(updatedNeutral)
    console.log('Neutral after', updatedNeutral)
    setAll(good + updatedNeutral + bad)
  }

  const handleBadClick = () =>{
    console.log('Bad before', bad)
    const updatedBad = bad + 1
    setBad(updatedBad)
    console.log('Bad after', updatedBad)
    setAll(good + neutral + updatedBad)
  }

  return (
    <div>
      <h1>Give feedback</h1>
      <Button handleClick={handleGoodClick} text='Good'/>
      <Button handleClick={handleNeutralClick} text='Neutral'/>
      <Button handleClick={handleBadClick} text='Bad'/>
      <Statistics good={good} neutral = {neutral} bad={bad} all={all}/>
    </div>
  )
}

//Reference code
/*
const Button = ({handleClick, text}) => (
  <button onClick={handleClick}>
    {text}
  </button>
)

const App = () => {
  // save clicks of each button to its own state
  const [good, setGood] = useState(0)
  const [neutral, setNeutral] = useState(0)
  const [bad, setBad] = useState(0)
  const [all, setAll] = useState(0)

  const handleGoodClick = () =>{
    console.log('Good before', good)
    const updatedGood = good + 1
    setGood(updatedGood)
    console.log('Good after', updatedGood)
    setAll(updatedGood + neutral + bad)
  }

  const handleNeutralClick = () =>{
    console.log('Neutral before', neutral)
    const updatedNeutral = neutral + 1
    setNeutral(updatedNeutral)
    console.log('Neutral after', updatedNeutral)
    setAll(good + updatedNeutral + bad)
  }

  const handleBadClick = () =>{
    console.log('Bad before', bad)
    const updatedBad = bad + 1
    setBad(updatedBad)
    console.log('Bad after', updatedBad)
    setAll(good + neutral + updatedBad)
  }

  return (
    <div>
      <h1>Give feedback</h1>
      <Button handleClick={handleGoodClick} text='Good'/>
      <Button handleClick={handleNeutralClick} text='Neutral'/>
      <Button handleClick={handleBadClick} text='Bad'/>
      <div>
        <h1>Statistics</h1>
        <p>Good: {good}</p>
        <p>Neutral: {neutral}</p>
        <p>Bad: {bad}</p>
        <p>All: {all}</p>
        <p>Average: {(good-bad)/all}</p>
        <p>Positive: {good/all*100} %</p>
      </div>
    </div>
  )
}
*/
export default App
