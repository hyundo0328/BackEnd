import dayjs from 'https://cdn.jsdelivr.net/npm/dayjs@1.11.13/+esm';

const API_KEY = 'a3LecUQIQERVixb88l1CnNcCc4bsxqPb5mUALLiu4TI';
const URL = 'https://api.unsplash.com/photos/random?';
const params = {
  client_id: API_KEY,
  orientation: 'landscape',
  query: 'landscape'
}

const queryString = new URLSearchParams(params);
const api = async () => {
  const response = await fetch(URL + queryString, {
    header: {
      'Accept-Version': 'v1'
    }
  });

  return response.json();
}

async function createToken()  {
  const {
    urls: {full:bg},
    location: {name: location}
  } = await api();

  const newToken = {
    bg: bg,
    location: location,
    expire: dayjs().add(1,'day')
  };

  localStorage.setItem('unsplash-token', JSON.stringify(newToken));
  return newToken;
}

const getToken = async () => {
  const storedToken = JSON.parse(localStorage.getItem('unsplash-token'));
  await createToken();
  console.dir(storedToken);

  if(storedToken && dayjs().isBefore(storedToken.expire)){
    return storedToken;
  }
  return await createToken();
}

export { api };
export default getToken;