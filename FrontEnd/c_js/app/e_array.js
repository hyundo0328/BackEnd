let top1 = {
  title : '소년이 온다',
  awards : ['노벨문학상', '이상문학상'],
  category : {depth1: '문학', depth2: '소설'},
  'categoryCode':12,
}

let top2 = {
  title : '당신의 이름을 지어다가 며칠은 먹었다',
  awards : ['젊은 예술가상'],
  category : {depth1: '문학', depth2: '시'},
  'categoryCode':12,
}

let top3 = {
  title : 'Object',
  awards : [],
  category : {depth1: '기술', depth2: 'IT'},
  'categoryCode':15,
}


// C
// 배열의 가장 뒤에 요소를 추가
const studyPush = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  arr.push('e');
  console.log(arr);
}

studyPush();

// unshift : 배열의 앞에 요소를 추가
const studyUnshift = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  arr.unshift('e');
  console.log(arr);
}

studyUnshift();

// splice : 배열에서 요소를 선택해 자르거나 교체
const studySplice = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  arr.splice(2, 0, 'ㄱ', 'ㄴ');
  console.log(arr);
}

studySplice();

// R
const studyRead = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
  }
}

studyRead();

// U
const studyUpdate = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  arr.splice(2, 2, 'ㄱ', 'ㄴ');
  console.log(arr);
}

studyUpdate();

// D
const studyDelete = () => {
  const arr = ['a', 'b', 'c', 'd', 100];
  arr.splice(2, 2);
  console.log(arr);
}

// map filter reduce
const studyMap = () => {
  const arr = [1,2,3,4,5,6];

  // arr 의 각 요소에 10을 곱한 배열이 필요하다.
  const res = arr.map( e => e * 10);
  console.log(res);

  const books = [top1, top2, top3];
  const titles = books.map(e => e.title);
  console.log(titles);
}

studyMap();

const studyFilter = () => {
  const arr = [1,2,3,4,5,6];

  const even = arr.filter(e => e % 2 === 0);
  console.log(even);

  const books = [top1, top2, top3];
  console.log(books.filter(e => e.awards.length > 1));
}

studyFilter();
const studyReduce = () => {
  const arr = [1,2,3,4,5,6];

  const oddSum = arr.reduce((acc, cur) => {
    if(cur % 2 === 1){
      acc += cur;
    }

    return acc;
  } , 0)

  console.log(oddSum);
}
studyReduce();

// arr 의 각 요소에 10을 곱한 배열이 필요하다.
// reduce 를 사용해 구현
const quizReduce = () => {
  const arr = [1,2,3,4,5,6];
  const res = arr.reduce((acc , cur) => {
    acc.push(cur * 10);
    return acc;
  }, [])

  console.log(res);
}
quizReduce();

const studyjoin = () => {
  const arr = ['a','b','c','d'];
  let arrString = arr.join("-");
  return arrString;

}
console.log(studyjoin());

// 유사배열객채
const similarArray = {
  0: 'hi',
  1: 'hello',
  2: 'bye',
  length: 3
}

const studySimilarArray = () => {
  const arr = Array.from(similarArray);
  arr.forEach(e => console.log(e));
}

studySimilarArray();