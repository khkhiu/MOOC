import React from "react";

// Header component takes the course name as a prop and renders it as an h1 element
const Header = ({ name }) => {
    return <h1>{name}</h1>;
};

export default Header