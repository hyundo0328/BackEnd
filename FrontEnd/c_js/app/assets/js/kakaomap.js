import geoApi from "./module/geolocation.js";

const renderMap = await geoApi()
  .then((value) => {
    const {
      latitude: latitude,
      longitude: longitude
    } = value;

    const container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
    const options = { // 지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표.
      level: 3 // 지도의 레벨(확대, 축소 정도)
    };

    const map = new kakao.maps.Map(container, options);

    // 마커가 표시될 위치
    const markerPosition = new kakao.maps.LatLng(latitude, longitude);

    // 마커 생성
    const marker = new kakao.maps.Marker({
      position: markerPosition
    })
    marker.setMap(map); // 마커를 지도 위에 표시
  }).catch(() => console.err("API 가져오기 실패"));

export default renderMap;