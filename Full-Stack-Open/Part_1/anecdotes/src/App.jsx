import { useState } from 'react'

const Button = ({handleClick, text}) => (
  <button onClick = {handleClick}>
    {text}
  </button>
)

const App = () => {
  const anecdotes = [
    'If it hurts, do it more often.',
    'Adding manpower to a late software project makes it later!',
    'The first 90 percent of the code accounts for the first 90 percent of the development time...The remaining 10 percent of the code accounts for the other 90 percent of the development time.',
    'Any fool can write code that a computer can understand. Good programmers write code that humans can understand.',
    'Premature optimization is the root of all evil.',
    'Debugging is twice as hard as writing the code in the first place. Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.',
    'Programming without an extremely heavy use of console.log is same as if a doctor would refuse to use x-rays or blood tests when diagnosing patients.',
    'The only way to go fast, is to go well.'
  ]
   
  const [selected, setSelected] = useState(0)
  //Use anecdotes.length to specify Array size, and start the score array with all 0
  const [points, setPoints] = useState(new Array(anecdotes.length).fill(0))

  const setAnecdote = () => {
    // Use math.floor to constraint RNG to length of anecdote array
    setSelected(Math.floor(Math.random() * anecdotes.length))
    console.log("Anecdote number: " + selected)
  }

  const addVote = () => {
    // Component to track number of votes, see "Spread syntax" for reference
    const anecdotePoints = [...points]
    // Associate anecdote with votes
    anecdotePoints[selected] += 1
    setPoints(anecdotePoints)
    console.log("Anecdote number: "+selected+" Anecdote vote: "+anecdotePoints)
  }

  // Component to track which anecdote has the most number of points
  const bestAnecdote = points.indexOf(Math.max(...points))

  return (
    <div>
      <h1>Anecdote of the day</h1><br/>
      <div>{anecdotes[selected]}</div><br/>
      <div>This anecdote has {points[selected]} votes</div><br/>
      <div>
        <Button handleClick={()=>{setAnecdote()}} text='Next anecdote'/>
        <Button handleClick={()=>{addVote()}} text='Vote'/>
      </div>
      <h1>Anecdote with most votes</h1>
      <div>{anecdotes[bestAnecdote]}</div><br/>
      <div>This anecdote has {points[bestAnecdote]} votes</div>
    </div>
  )
}

export default App