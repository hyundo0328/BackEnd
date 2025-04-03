const API_KEY = 'bbd0b4e3a28004cabe8e31b907650744';
const API_URL = 'https://api.openweathermap.org/data/2.5/weather?';

const api = async coords => {
  const params = {
    appid: API_KEY,
    lat: coords.latitude,
    lon: coords.longitude,
    units: 'metric'
  };
  const url = API_URL + new URLSearchParams(params).toString();
  const response = await fetch(url);

  return response.json();
}

export default api;