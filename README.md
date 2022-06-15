# 📝나만의 블로그 만들기 - Version 2
##  **💡Spring Boot를 활용하여 나만의 블로그 만들기**

- **프로젝트 기간 : 2022.06.08~ 2022.06.18**
    
<br/>

## 💡 프로젝트 목표
- 블로그 version1 의 코드를 리팩토링하여 중복되는 코드를 줄이고 가독성을 높임
- 블로그 version1 에서 하지 못했던 추가 기능 구현 (댓글)
- 추가 기능구현보다는 코드 리팩토링에 초점을 맞춤
- [블로그ver1깃허브](https://github.com/emperor-juwon/blog_project_version_1)

<br/>

## 💡 블로그 ver2 에서 업그레이드 된 부분
### API Controller 추가

- 블로그 ver1 에서는 페이지를 리턴하는 @Controller 에서 데이터를 리턴하는 경우가 생길 시에 @ResponseBody를 사용해서 데이터를 리턴했음
- 이번에는 데이터를 리턴하는 ApiController(@RestController)를 분리하여 구현
- [관련공부기록](https://blog.naver.com/fwangjuwon/222680204093)

### Global Exception처리 
- 내가 제어할 수 없는 위치에서 터지는 오류를 만났을 때, 내가 원하는 예외 처리를 해주기 위해 전역적으로 사용할 수 있는 Exception 처리
- @ControllerAdvice를 사용하면 모든 exception을 낚아챌 수 있고, @ExceptionHandler 로 특정 예외에만 낚아채도록 처리
- [관련공부기록](https://blog.naver.com/fwangjuwon/222680270814)


### ajax 사용
- 페이지 전체 리로딩이 아닌 부분 리로딩이 가능하여 통신한 결과를 통해 CSR(Client Side Rendering) 이 가능
- [관련공부기록](https://blog.naver.com/fwangjuwon/222754964393)

### throw 사용
- 강제로 터진 해당 Exception을 에러 핸들러가 낚아채도록 처리
- [관련공부기록](https://blog.naver.com/fwangjuwon/222682690840)

### interceptor를 사용한 인증처리
- 컨트롤러 메서드의 전처리와 후처리를 제어할 수 있도록 인터셉터 클래스 제공
- [관련공부기록](https://blog.naver.com/fwangjuwon/222685109976)

### 댓글기능 추가
- 게시글 상세보기할 때 댓글기능 추가
-> Post를 SELECT 하는데 Comment까지 가지고 올 수 없을 때 양방향 매핑(@OneToMany) 사용
- 양방향 매핑을 사용하면 MessageConverter가 getter를 때릴 때 무한 로딩 문제 생김 (n+1문제)
- [관련공부기록1](https://blog.naver.com/fwangjuwon/222686540045)
- [관련공부기록2](https://blog.naver.com/fwangjuwon/222734758279)

<br/>

 ## 💡 사용 기술

<img src="https://img.shields.io/badge/-Java-007396"/>  <img src="https://img.shields.io/badge/-Spring-6DB33F"/>  <img src="https://img.shields.io/badge/-Apach%20Tomcat-F8DC75"/> <img src="https://img.shields.io/badge/-MariaDB-071D49"/> 
<img src="https://img.shields.io/badge/-HTML5-E34F26"/> <img src="https://img.shields.io/badge/-CSS-1572B6"/> <img src="https://img.shields.io/badge/-JavaScript-F7DF1E"/> <img src="https://img.shields.io/badge/-JQuery-0769AD"/> 
<img src="https://img.shields.io/badge/-Github-181717"/> <img src="https://img.shields.io/badge/-Git-F05032"/> <img src="https://img.shields.io/badge/-BootStrap-7952B3"/> 

- **개발 언어**: Java 11, HTML 5, CSS, JavaScript
- **DataBase**: MariaDB 10.6

- **Library**
- ***Front***
    - Bootstrap 5.1.3, jQuery 3.5.1, Summernote, Mustache
- ***Back***
    - Spring Web, Spring Boot Devtools, Lombok, MariaDB Driver, Spring Data JPA
- **개발 환경** : VS Code, SpringBoot 2.5.12, Gradle, Lombok, JPA
<br/>
<br/>
  
## 💡****블로그 ver.2 에서 추가된 기능 ****

### 🛠 ****댓글 관련 기능****
- 댓글 작성 및 삭제 기능

| 댓글 작성| 본인 댓글만 삭제 |
|------|------|
|![commentwritereal](https://user-images.githubusercontent.com/104547351/173788224-13c82241-e3c6-44dd-9bb6-029e32671cc6.gif)|![commentwrite](https://user-images.githubusercontent.com/104547351/173788228-eb4d58f0-5aae-40cd-84d7-fadb45d39ad2.gif)
|
<br/>

## 💡ERD
<img width="423" alt="Screenshot_28" src="https://user-images.githubusercontent.com/104547351/173792144-15834a49-0ce6-4e96-be1d-363e27c6e384.png">


<br/>

## 💡 프로젝트 리뷰 및 개선방향
- RestController와 Controller를 나누어 사용하니 불필요한 코드 (@Responsebody, @Requestbody 등)를 줄일 수 있었음
- exception처리 및 throw처리로 error 발생을 줄일 수 있었음
- test했던 코드들(ex- systemout, console.log) 을 정리하면서 작업할 것
- 인증과 보안기능 강화 필요