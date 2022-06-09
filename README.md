# 📝나만의 블로그 만들기 - Version 2
##  **💡Spring Boot를 활용하여 나만의 블로그 만들기**

- **프로젝트 기간 : 2022.06.08~**
    
<br/>

## 💡 프로젝트 목표
- 블로그 version1 에서 부족했던 추가 기능을 사용하여 블로그 구현하기 
- [블로그ver1깃허브](https://github.com/emperor-juwon/blog_project_version_1)

<br/>

## 💡 블로그 ver1 과 비교하여 추가된 기능들
### API Controller 추가

- 블로그 ver1 에서는 페이지를 리턴하는 @Controller 에서 데이터를 리턴하는 경우가 생길 시에 @ResponseBody를 사용해서 데이터를 리턴했었다.
- 이번에는 데이터를 리턴하는 ApiController(@RestController)를 분리하여 구현했다.


### Global Exception처리 
- 내가 제어할 수 없는 위치에서 터지는 오류를 만났을 때, 내가 원하는 예외 처리를 해주기 위해 전역적으로 사용할 수 있는 Exception 처리를 만들어줬다.
- @ControllerAdvice를 사용하면 모든 exception을 낚아챌 수 있고, @ExceptionHandler 로 특정 예외에만 낚아챌 수 있다.


### Generic 와일드 카드 사용
- 데이터를 요청받고 응답하기 위해 ResponseDto를 만들어준다. 일일이 타입을 맞춰 적어주기 귀찮기 때문에 동적으로 타입 변경이 가능한 와일드 카드<T>를 사용했다.


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
  
## 💡****페이지별 상세 기능****
### 🛠 ****유저 관련 기능****


<br/>

### 🛠 ****게시판 관련 기능****

<br/>

## 💡구현 결과(영상 링크)


<br/>

## 💡ERD


<br/>

## 💡 프로젝트 리뷰 및 개선방향
