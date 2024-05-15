<h1><b>Kotiln Multi Module Project</b></h1>

<hr>
<br>

<h3>[개발 환경]</h3>
- <b>Framework</b>: &nbsp; SpringBoot 3.2.4<br>
- <b>Jdk</b>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Oracle OpenJDK 21.0.2<br>
- <b>DB</b>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mysql, H2<br>
- <b>Tool</b>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Intellij

<br>

<h3>[모듈 구성]</h3>
- <b>api-externalApi</b>: &nbsp; 공공데이터 외부 API<br>
- <b>api-internalApi</b>: &nbsp;&nbsp; DB 조회 내부 API<br>
- <b>common</b>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 레포지토리, 공통 파일, 도메인

<br>

<h3>[설명]</h3>
- DB에 적재된 예보 데이터, 공공 API 조회에 대한 ResultCode, ResultMsg 값을 리턴합니다.<br>
- DB는 개인적으로 사용하는 우분투 기반 실서버로 연동했습니다.<br>
- 데이터가 DB에 없는 경우의 테스트를 위해, DB의 데이터는 테스트 후 모두 삭제한 상태입니다.<br>
- "의정부시 의정부1동"의 x,y 값으로 고정했습니다.<br>

<span style="font-size: smaller; color:gray">( 참고사진 : 단기예보 조회서비스 X, Y 값 조회 파일 )</span><br>
<img src="xy.png">

<br>

<h3>[참고 사이트]</h3>
1. 코틀린 기본 문법<br>
   - https://cjw-awdsd.tistory.com/20 <br>
2. 코틀린 환경에서의 JPA 사용법<br>
   - https://ittrue.tistory.com/482 <br>
3. 멀티모듈 프로젝트 구성<br>
   - https://junuuu.tistory.com/627 <br>
   - https://cjw-awdsd.tistory.com/55 <br>

<br>
<br>
