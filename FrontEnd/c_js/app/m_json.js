let top1 = {
  title : '소년이 온다',
  awards : ['노벨문학상', '이상문학상', {cnt: 2, year: [2025,2019]}],
  category : {depth1: '문학', depth2: '소설', code: [12,13]},
  info: function(){
    console.log(this.title);
  }
}

let top2 = {
  title : '당신의 이름을 지어다가 며칠은 먹었다',
  awards : ['젊은 예술가상'],
  category : {depth1: '문학', depth2: '시'},
  'categoryCode':12,
  info: function(){
    console.log(this.title);
  }
}

let top3 = {
  title : 'Object',
  awards : [],
  category : {depth1: '기술', depth2: 'IT'},
  'category-code':15,
  info: function(){
    console.log(this.title);
  }
}

// obj to json
const bookJson = JSON.stringify(top1);
console.log(typeof(bookJson), bookJson);

// json to obj
const bookObj = JSON.parse(bookJson);
console.log(typeof(bookObj), bookObj);

console.log("================================");
// 구조분해할당
// let top1 = {
//   title : '소년이 온다',
//   awards : ['노벨문학상', '이상문학상', {cnt: 2, year: [2025,2019]}],
//   category : {depth1: '문학', depth2: '소설', code: [12,13]},
//   info: function(){
//     console.log(this.title);
//   }
// }

const {
  title: tit,
  category: {depth1, depth2, code:[depth1Code, depth2Code]},
  awards: [award1, award2, {cnt, year:[yearA, yearB]}]
} = top1;
console.log(tit);
console.log(depth1);
console.log(depth2);
console.log(depth1Code, depth2Code);
console.log(cnt, yearA, yearB);