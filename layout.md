# Layout 설명

기본적으로 모든 layout은 templates.fragment에 구현

## 목차

- [layout](#layout)
  - [commonHead](#commonHead)
  - [commonHeader](#commonHeader)
  - [commonFooter](#commonFooter)
  - [commonJavaScript](#commonJavaScript)
- [llayout](#llayout)
  - [lHeader](#lHeader)

### layout

기본적으로 index, login, joinMembership을 제외한 모든 파일이 사용할 layout

```html
<head>
    <meta charset="UTF-8">
    <title layout:title-parttern="$LAYOUT_TITLE : $CONTENT_TITLE">WORDATA</title>
    <!-- 공통 meta tag css 폰트 사용 head 추가-->
    <th:block th:replace="fragment/commonHead"></th:block>
</head>
<body>
<!-- 공통 header 추가 -->
<header
        th:replace="fragment/commonHeader :: 'header'"></header>

<!-- page content body -->
<th:block layout:fragment="body"></th:block>

<!--공통 footer -->
<footer th:replace="fragment/commonFooter :: footer"></footer>

<!--공통 javaScript-->
<th:block th:replace="fragment/commonJavaScript"></th:block>

<!--page content javaScript-->
<th:block layout:fragment="pageCustomScript"></th:block>

</body>
```

위와 같은 구성을 따른다.



만약 각 페이지마다 따로 Script를 작성할시는 해당 페이지에 아래와 같이 사용한다.

```html
<th:block layout:fragment="pageCustomScript"></th:block>

<!-- ex) joinMembership.html.html -->
<th:block layout:fragment="pageCustomScript">
    <script type="text/javascript">
        // 내용
    </script>
</th:block>
```



[목록](#)

#### commonHead

공통으로 사용되는 ```<head>``` 영역을 구현

또한 각 페이지마다 따로 사용할 폰트는 아래와 같이 각페이지에 적용한다.

```html
<th:block layout:flagment="pageCustomFonts"></th:block>

<!-- ex) joinMembership.html -->
<th:block layout:flagment="pageCustomFonts">
        <link href="https://fonts.googleapis.com/css?family=Luckiest+Guy&display=swap" rel="stylesheet">
</th:block>
```

[목록](#)

#### commonHeader

공통으로 사용되는 `<header>`영역을 구현

[목록](#)



#### commonFooter

공통으로 사용되는 `<footer>`영역을 구현

[목록](#)

#### 

#### commonJavaScript

공통으로 사용되는 javaScript 영역을 구현



만약 페이지따로 사용할 Script가 있다면

```html
<th:block layout:fragment="pageCustomScript"></th:block>

<!-- ex) joinMembership.html.html -->
<th:block layout:fragment="pageCustomScript">
    <script type="text/javascript">
        // 내용
    </script>
</th:block>
```

위와 같이 각페이지에서 사용한다.

[목록](#)

#### 

### llayout

login,joinMembership의 경우에는 `<header>`영역이 다르므로 다른 레이아웃을 만듦

> 이경우 thymeleaf 문법으로 기존 layout.html과 commonHeader.html에 합쳐서 사용이 가능 할 것 같다.
>
> 하지만 조금의 시간이 걸릴 것으로 예상하여 일단은 따로 나누어 구현하였다.

기존 layout과 크게 다르지 않다.

[목록](#)

#### 

#### lHeader

로그인과 회원가입에서 사용되는 `<header>`영역을 구현

[목록](#)

#### 

