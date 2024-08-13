import ReactDOM from 'react-dom/client'
import App from './App'

let counter = 1

ReactDOM.createRoot(document.getElementById('root')).render(
  <App/>
  //<App counter={counter}/>
)

/** setting refresh interval every second
 * setInterval(() = >{
 * refresh()
 * counter += 1
 * }, 1000)
 */