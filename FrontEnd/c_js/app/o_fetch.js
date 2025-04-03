const API_URL = 'https://dapi.kakao.com/v3/search/book?';
const params = {
  query: '해리포터',
  size: '2'
}

const queryString = new URLSearchParams(params).toString();
// const reponse = fetch(API_URL+queryString,{
//   headers: {Authorization: 'KakaoAK d640c563def448d5fa1c0c7fd922d3a6'}
// }).then(res => {
//   res.json();
// }).then(data => {
//   console.dir(data.documents[0].title);
// })
(async ()=> {
  const reponse = await fetch(API_URL+queryString,{
    headers: {Authorization: 'KakaoAK d640c563def448d5fa1c0c7fd922d3a6'}
  });

  const data = await response.json();
  const{
    documents:[{title}]
  } = data;
  console.log(title);
});
