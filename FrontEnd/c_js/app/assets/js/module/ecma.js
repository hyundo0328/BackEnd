const clap = () => {
  console.log();
  console.log('👏👏👏👏👏👏');
  console.log();
}

const odd = '홀수';
const even = '짝수';
const phd = {
  username: '박현도',
  age: 25
}

let count= 0;

const counter = () => {
  count++;
  console.dir(count);
}

export{odd, even, phd, counter}
export default clap; // 기본으로 export