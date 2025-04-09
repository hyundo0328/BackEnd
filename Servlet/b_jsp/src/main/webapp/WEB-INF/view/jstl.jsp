<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang='ko'>
<head>
    <title>Title</title>
</head>
<body>
    <h4>JSTL</h4>
    <pre>
        JSP 에서 사용하는 스크립틀릿의 복잡함을 해결하기 위해 등장
        변수 선언 및 초기화, 출력문, 조건문, 반복문, formatting
    </pre>

    <c:set var="kor" value="50" />
    <c:set var="math" value="30" />

    <h4>1. out</h4>
    <div>kor : <c:out value="${kor}"/></div>
    <div>math : <c:out value="${math}"/></div>
    <%-- xss attack : cross site scripting attack   --%>
    <div>xss : <c:out value="${xss}"/></div>
    <%-- <div>el xss : ${xss}</div> --%>

    <div class="divider"></div>

    <h4>2. 배열</h4>
    <c:set var="colors">
        red,blue,yellow,green,pink
    </c:set>
    <div>jsrl Array : <c:out value="${colors}"/></div>

    <h4>3. 조건문</h4>
    <h5>if</h5>
    <c:if test="${kor < math}">
        <div>수학을 더 잘하시는 군요!</div>
    </c:if>
    <c:if test="${kor > math}">
        <div>국어를 더 잘하시는 군요!</div>
    </c:if>

    <h5>choose when otherwise</h5>
    <c:choose>
        <c:when test="${kor > 90}" >
            <div>당신의 국어 학점은 A 입니다.</div>
        </c:when>
        <c:when test="${kor > 80}" >
            <div>당신의 국어 학점은 B 입니다.</div>
        </c:when>
        <c:when test="${kor > 70}" >
            <div>당신의 국어 학점은 C 입니다.</div>
        </c:when>
        <c:when test="${kor > 60}" >
            <div>당신의 국어 학점은 D 입니다.</div>
        </c:when>
        <c:otherwise>
            <div>당신의 국어 학점은 F 입니다.</div>
        </c:otherwise>
    </c:choose>

    <h4>4. 반복문</h4>
    <h5>for</h5>
    <pre>
        var : i
        begin : 시작값
        end : 종료값
        step : 증가 크기
    </pre>
    <c:forEach var="i" begin="0" end="10" step="1">
        <span>${i}</span>
    </c:forEach>

    <h5>forEach</h5>
    <pre>
        var : element
        items : iterable
        varStatus : 상태정보
    </pre>
    <table border="1">
        <thead>
        <tr>
            <th>index</th>
            <th>count</th>
            <th>element</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="color" items="${colors}" varStatus="status">
            <tr>
                <td><c:out value="${status.index}"/></td>
                <td><c:out value="${status.count}"/></td>
                <td><c:out value="${color}"/></td>
                <td><c:out value="${status.first}"/></td>
                <td><c:out value="${status.last}"/></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="divider"></div>

    <h4>5. forTokens</h4>
    <pre>
        var : token
        items : 문자열
        delims : 구분자
    </pre>
    <ul>
        <c:forTokens var="token" items="java html css js mysql servlet" delims=" ">
            <li>
                <c:out value="${token}" />
            </li>
        </c:forTokens>
    </ul>

    <h4>6. fmt</h4>
    <fmt:formatNumber value="12.3" pattern=".000"/>
    <fmt:formatNumber value="123456" pattern="#,#00.##"/>
    <fmt:formatNumber value="1" pattern="#,###.##"/>
</body>
</html>