## 패키지 구조
```
├── article
│   ├── controller 컨트롤러(임시)
│   ├── domain 도메인
│   ├── infra 레파지토리
│   └── service 서비스
├── common 공통 패키지
└── └── exception 예외
```

## 게시글 조회 
```
http://localhost:8080/api/articles/{id}
```

### 응답
![응답값](https://github.com/DaeGang/Notion-Imitation/assets/58874665/05f844ba-6611-41c3-9470-32daa016d9bc)
```
id: 게시글 고유 ID
title: 제목
content: 본문
children: subPage
parents: breadcrumbs
```
