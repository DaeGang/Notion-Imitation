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

## 테이블 구조
![image](https://github.com/DaeGang/Notion-Imitation/assets/60501504/4167e9c2-2275-45ba-aade-7fd3d228f303)


## 게시글 조회 
```
http://localhost:8080/api/articles/{id}
```

### 응답
![image](https://github.com/DaeGang/Notion-Imitation/assets/60501504/6951fd68-d42c-4c8a-a8b4-9e801e36edc7)
![image](https://github.com/DaeGang/Notion-Imitation/assets/60501504/50bfbc5f-9888-4f2b-9a99-889c7e555900)


```
id: 게시글 고유 ID
title: 제목
content: 본문
parentId : 상위 페이지 ID
subPage: 하위페이지
breadcrumbs: 브레드크럼즈
```
