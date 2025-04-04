require('dotenv').config();
const API_URL = 'https://dapi.kakao.com/v3/search/book?';
const kakaoApiKey = process.env.KAKAO_API_KEY;

const api = async params => {
  const queryString = new URLSearchParams(params).toString();
  const response = await fetch(API_URL+queryString,{
    headers: {Authorization: kakaoApiKey}
  });

  const data = await response.json();
  const{
    documents:[{title}]
  } = data;
  console.log(title);
}
export default api;

// const queryString = new URLSearchParams(params).toString();
// // const reponse = fetch(API_URL+queryString,{
// //   headers: {Authorization: 'KakaoAK d640c563def448d5fa1c0c7fd922d3a6'}
// // }).then(res => {
// //   res.json();
// // }).then(data => {
// //   console.dir(data.documents[0].title);
// // })
// (async ()=> {
//   const response = await fetch(API_URL+queryString,{
//     headers: {Authorization: 'KakaoAK d640c563def448d5fa1c0c7fd922d3a6'}
//   });
//
//   const data = await response.json();
//   const{
//     documents:[{title}]
//   } = data;
//   console.log(title);
// })();
