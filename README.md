# WORDATA_BackEnd

이 레포지터리는 Wordata project demo 파일입니다.

Spring Initializr로 gradle을 사용하게 파일을 작성하였으며

아래와 같은 의존성을 작성하였음

web,debtools,lombok

thymeleaf,thymeleaf(layout),thymeleaf(security)

jpa,mysql

security



Front-end templates제작: Lee EunHak[(dev-eunak)](https://github.com/dev-eunak/WORDATA-web)



개발 내용

| title             | Description                                                  |
| ----------------- | ------------------------------------------------------------ |
| wordatatest       | - gradle project 생성<br>- templates 가저오기 <br/> [(templates)](https://github.com/dev-eunak/WORDATA-web)<br/>  + thymeleaf 적용<br/>  + layout적용<br/>  + layout용 html 분할 [참고](/layout.md)<br/>- MySQL,JPA 적용<br/>- spring security 적용 & 회원가입 적용<br/>- 유저별 권한 설정<br/>  + 로그인하지 않은 유저는 로그인, 회원가입 버튼이 보인다.<br/>  + 로그인한 유저는 유저이름, 로그아웃 버튼이 보인다.<br/>  + 인증된 유저만 단어장과 데이터 분석을 사용할 수 있음 |
| wordatatest(ver2) | wordatatest에서 UserService에 UserDetailsService를 implement하여 login 기능을 다시 구현하였다. 해당 과정에서 AuthenticationProvider를 구현한 MyAuthenticationProvider를 삭제하고 추후에 유저에게 가입 일자를 등록하여 만료/잠김 등의 기능을 확인할 예정 |
|                   |                                                              |

