// 조건문
// if - else if - else
// switch - case

const fruit = '사과';
if(fruit === '바나나'){
  console.log('banana');
}else if(fruit === '사과'){
  console.log('apple')
}else{
  console.log('what?')
}

console.log('======================================');

switch (fruit){
  case "사과": console.log('apple')
    break;
  case "바나나" : console.log('banana')
    break;
  default :
    console.log("what?");
}

console.log('======================================');

// 3번 반복하는 while
let i = 0;
while(true){
  console.log(i);
  i++;
  if(i > 3) break;
}

for (let j = 0; j < 3; j++) {
  if(j === 1) continue;
  console.log(j, 'hello world');
}
