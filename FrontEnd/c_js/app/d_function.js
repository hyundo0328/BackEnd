// 함수 선언식 : 함수 호이스팅이 가능하다.
console.log(add(100, 200));
function add(a, b){
  return a + b;
}

console.log('a + b =', add(10, 15));

// 함수 표현식
const fncExpr = function(a, b){
  return a + b;
}
console.log(fncExpr);
console.log(fncExpr(1000, 3000));

const argFnc = function(fnc){
  fnc();
}

argFnc(function(){console.log('저는 callback 함수 입니다.')});

const returnFnc = function(){
  let name = 'hmd';
  let counter = 0;

  // 반환되는 함수 : Closure
  return function(){
    counter++;
    console.log(name,counter);
  }
}

const rf = returnFnc();
console.dir(rf)
rf();
rf();

console.log('==================================');
// 즉시실행함수 IIFE
// 함수의 선언과 동시에 실행
(function iife(){
  console.log('선언과 동시에 실행')
})();

// 람다
let arr = [
  '감자', '고구마', '옥수수'
];

arr.forEach(e => {
  console.log(e)
});

arr.forEach((e, idx, arr) => {
  console.log(e);
  console.log(idx);
  console.log(arr)
});

const argFunction = (t,s,u) => {
  console.log(t);
}

argFunction('hi',1,2,3,4,5,6,7,8,9,0,10,11,12,13,14,15,165);
