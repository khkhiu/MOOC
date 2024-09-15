import { useState } from 'react'
import Note from './components/Note'
import noteService from './services/notes'

/*usestate FX init state stored in 'notes' with array of notes passed in props */
/*to star with empty list of notes use: useState([]) */
const App = (props) => {
  const [notes, setNotes] = useState(props.notes)
  const [newNote, setNewNote] = useState('')
  const [showAll, setShowAll] = useState(true)

  useEffect(() => {
    noteService      
      .getAll()      
      .then(initialNotes => {        
        setNotes(initialNotes)
      })  
    }, [])

  //Form component for adding notes
  const addNote = (event) => {
    event.preventDefault()
    const noteObject = {
      content: newNote,
      important: Math.random() < 0.5,
      id: String(notes.length + 1),
    }
    noteService      
      .create(noteObject)      
      .then(returnedNote => {        
        setNotes(notes.concat(returnedNote))
        setNewNote('')      
    })   
  /*
  // Use 'axios' to comms with server
  axios
    .post('http://localhost:3001/notes', noteObject)
    .then(response => {
      setNotes(notes.concat(noteObject))
      setNewNote('')
      console.log(response)
    })
  */
  }

  //Use event handler to sync changes to input with component state
  const handleNoteChange = (event) => {
    console.log(event.target.value)
    setNewNote(event.target.value)
  }

  //Use conditional operator to filter notes
  const notesToShow = showAll
    ? notes
    : notes.filter(note => note.important === true)

  //Toggling importance of notes while comms with server
  const toggleImportanceOf = id => {
    const note = notes.find(n => n.id === id)
    const changedNote = { ...note, important: !note.important }
  
    noteService
      .update(id, changedNote).then(returnedNote => {
        setNotes(notes.map(note => note.id !== id ? note : returnedNote))
      })
  
      .catch(error => {
        alert(
          `the note '${note.content}' was already deleted from server`
        )
        setNotes(notes.filter(n => n.id !== id))
      })
  }
    /*
    axios.put(url, changedNote).then(response => {
      // The map method creates a new array by mapping every item from the old array into an item in the new array. 
      setNotes(notes.map(n => n.id !== id ? n : response.data))
    })
    */

  const getAll = () => {
    const request = axios.get(baseUrl)
    const nonExisting = {
      id: 10000,
      content: 'This note is not saved to server',
      important: true,
    }
    return request.then(response => response.data.concat(nonExisting))
  }

  return (
    <div>
      <h1>Notes</h1>
      <div>
        <button onClick={() => setShowAll(!showAll)}>
          show {showAll ? 'Important' : 'all'}
        </button>
      </div>
      <ul>
        {notesToShow.map(note => 
          <Note
            key={note.id} 
            note={note} 
            toggleImportance={() => toggleImportanceOf(note.id)}
          />
        )}
      </ul>
      <form onSubmit={addNote}>
        <input 
          value={newNote}
          onChange={handleNoteChange}
        />
        <button type="submit">save</button>
      </form>
    </div>
  )
}

export default App 