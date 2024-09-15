import { useState, useEffect } from 'react'
import Note from './components/Note'
import noteService from './services/notes'
import Notification from './components/Notification'

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
      .update(id, changedNote)
        .then(returnedNote => {
        setNotes(notes.map(note => note.id !== id ? note : returnedNote))
      })
      .catch(error => {
        setErrorMessage(
          `Note '${note.content}' was already removed from server`
        )
        setTimeout(() => {
          setErrorMessage(null)
        }, 5000)
      })
  }

  // Adding footer style
  const Footer = () => {  
    const footerStyle = {    
      color: 'green',    
      fontStyle: 'italic',    
      fontSize: 16  
    }  
    return (    
      <div style={footerStyle}>      
        <br />      
        <em>Note app, Department of Computer Science, University of Helsinki 2024</em>    
      </div>  
    )}

  return (
    <div>
      <h1>Notes</h1>
      <Notification message={errorMessage} />
      <div>
        <button onClick={() => setShowAll(!showAll)}>
          show {showAll ? 'important' : 'all' }
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
      <Footer />
    </div>
  )
}

export default App 