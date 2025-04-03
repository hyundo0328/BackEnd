// 산술 : +, -, * /, %
// 비교 : <, >, <=, >=, ==, !=, ===, !==
// 논리 : &&, ||
// 문자열 결합 : +
// 단항 : ++, --

// == 동등연산자, === 일치연산자
// 동등연산자 : 값으로 비교
// 일치연산자 : 값과 타입으로 비교

const num = 0;
const str = '0';
const arr = [];
const empty = '';
const _null = null;
let _undefiend;

console.log('============================');
console.log('0 == \'0\' : ', num == str);
console.log(`[] == '' : `, arr != empty);

console.log('0 === \'0\' : ', num === str);
console.log(`[] === '' : `, arr !== empty);
console.log('============================');

// 자바스크립트 boolean 변환
// 1. false : 0, '', null, undefined, NaN (number 가 아닌 타입을 사용해 산술연산을 할 경우 발생)
// 2. true
console.log('a' / 100);

if('a' / 100){
  console.log('true');
}else{
  console.log('false');
}








