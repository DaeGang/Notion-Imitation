## 패키지 구조
```
.
├── java
│   └── com
│       └── wanted
│           └── teamassignment1
│               ├── config
│               ├── controller
│               ├── dao
│               ├── dto
│               ├── result 클라이언트에게 전달하는 데이터 형식 디렉토리
│               └── service
└── resources
    ├── mappers SQL 매퍼 파일 디렉토리
    ├── static
    └── templates
```

## 게시글 조회
```
http://localhost:8080/pages/{pageId}
```

### Response
![Response.jpg](..%2F..%2FDesktop%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-09-03%20%EC%98%A4%ED%9B%84%207.24.01.png)
```
code: 프로젝트 고유의 결과 코드
message: 결과 코드에 대응하는 메시지

data: 결과에 담긴 데이터
    pageId: 조회한 게시글의 고유 id
    title: 조회한 게시글의 제목
    content: 조회한 게시글의 내용
    parentPage: 조회한 게시글의 부모 게시글 id
    subPages: 조회한 게시글의 하위 페이지 객체 리스트
    breadCrumbs: 조회한 게시글의 breadcrumbs(array 형식)
```
