require('dotenv').config();
const weatherApiKey = process.env.WEATHER_API_KEY;
const API_URL = 'https://api.openweathermap.org/data/2.5/weather?';

const api = async coords => {
  const params = {
    appid: weatherApiKey,
    lat: coords.latitude,
    lon: coords.longitude,
    units: 'metric'
  };
  const url = API_URL + new URLSearchParams(params).toString();
  const response = await fetch(url);

  return response.json();
}

export default api;