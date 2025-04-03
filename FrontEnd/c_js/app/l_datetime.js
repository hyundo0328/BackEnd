import dayjs from 'dayjs';

const studyDateTime = () => {
  const now = new Date();
  console.log('연', now.getFullYear());
  console.log('월', now.getMonth());
  console.log('일', now.getDate());
  console.log('시', now.getHours());
  console.log('분', now.getMinutes());
  console.log('초', now.getSeconds());
  console.log('요일', now.getDay());
}
studyDateTime();

const studyDayjs = () => {
  const now = dayjs();
  console.log('연', now.year());
  console.log('월', now.month());
  console.log('일', now.date());
  console.log('시', now.hour());
  console.log('분', now.minute());
  console.log('초', now.second());
  console.log('요일', now.day());

  console.log(now.add(7, 'day').toString());
}
studyDayjs();