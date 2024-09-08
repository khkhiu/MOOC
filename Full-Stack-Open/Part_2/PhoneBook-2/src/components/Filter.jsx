import React from "react"

const Filter = ({ searchName, handleSearchChange }) => (
    <div>
    Filter shown with: <input type="text" value={searchName} onChange={handleSearchChange}/>
    </div>
)

export default Filter