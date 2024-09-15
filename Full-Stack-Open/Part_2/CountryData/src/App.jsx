import { useState, useEffect } from 'react'
import axios from 'axios'

const CountrySearch = () => {
  const [query, setQuery] = useState('')
  const [countries, setCountries] = useState([])
  const [filteredCountries, setFilteredCountries] = useState([])
  const [selectedCountry, setSelectedCountry] = useState(null)
  const [weather, setWeather] = useState(null)

  // useEffect to get country data
  useEffect(() => {
    axios
      .get('https://restcountries.com/v3.1/all')
      .then(response => setCountries(response.data))
      .catch(error => console.error('Error fetching country data:', error))
  }, [])

  // useEffect to filter country data
  useEffect(() => {
    if (query) {
      const result = countries.filter(country =>
        // convert all input to lower case to ignore capitalization
        country.name.common.toLowerCase().includes(query.toLowerCase())
      );
      // show results if there is match for the country
      setFilteredCountries(result)
    } else {
      setFilteredCountries([])
    }
  }, [query, countries]);

  // useEffect to pull weather data for selected country
  useEffect(() => {
    if (selectedCountry) {
      // select country capital
      const capital = selectedCountry.capital[0];
      // import API key to pull information
      const apiKey = import.meta.env.VITE_WEATHER_API_KEY;
      // use axios to pull desired information
      axios
        .get(`https://api.openweathermap.org/data/2.5/weather`, {
          params: {
            q: capital,
            appid: apiKey,
            units: 'metric'
          }
        })
        .then(response => setWeather(response.data))
        .catch(error => console.error('Error fetching weather data:', error));
    }
  }, [selectedCountry]);

  // Function to handle input change
  const handleChange = (event) => {
    // Update the state variable 'query' with the current value of the input field
    setQuery(event.target.value);
  };

  // Function to display details of a selected country
  const handleShow = (country) => {
    // Set the selected country state to the country passed as an argument
    setSelectedCountry(country);
    // Clear any previously displayed weather data, this ensures that the weather information shown is updated for the new selected country
    setWeather(null);
  };


// Function to render information of selected country
const renderCountries = () => {
  //Tell user to use a more specific filter if more than 10 filtered countries are available
  if (filteredCountries.length > 10) {
    return <p>Too many matches, specify another filter</p>;
  } 
  // Check if there is more than 1 filtered country
  else if (filteredCountries.length > 1) {
    // Render a list of country names with a 'Show' button for each country
    return (
      <ul>
        {filteredCountries.map(country => (
          <li key={country.cca3}>
            {country.name.common} 
            {/* Button to show details of the selected country */}
            <button onClick={() => handleShow(country)}>Show</button>
          </li>
        ))}
      </ul>
    );
  } 
  // Check if a single country is selected
  else if (selectedCountry) {
    const country = selectedCountry; // Alias for selectedCountry for easier reference
    // Render detailed information about the selected country
    return (
      <div>
        <h2>{country.name.common}</h2>
        <p>Capital: {country.capital[0]}</p>
        <p>Area: {country.area} km²</p>
        <p>Population: {country.population}</p>
        <p>Languages: {Object.values(country.languages).join(', ')}</p>
        {/* Display the country's flag */}
        <img src={country.flags.png} alt={`Flag of ${country.name.common}`} width="200" />
        {/* Conditionally render weather information if available */}
        {weather && (
          <div>
            <h3>Weather in {country.capital[0]}</h3>
            <p>Temperature: {weather.main.temp} °C</p>
            <p>Weather: {weather.weather[0].description}</p>
            <img
              src={`http://openweathermap.org/img/wn/${weather.weather[0].icon}.png`}
              alt={weather.weather[0].description}
            />
          </div>
        )}
      </div>
    );
  }
  // If none of the above conditions are met, return null (render nothing)
  return null;
};

  return (
    <div>
      <input value={query} onChange={handleChange} placeholder="Search for a country" />
      {renderCountries()}
    </div>
  );
};

export default CountrySearch;
