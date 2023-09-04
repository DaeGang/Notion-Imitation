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
![image](https://github.com/DaeGang/Notion-Imitation/assets/60501504/924c4920-97b2-4b28-afc5-e9df23da00b5)


![image](https://github.com/DaeGang/Notion-Imitation/assets/60501504/6c9b94fe-9004-4e60-9216-3400aabf883a)



```
id: 게시글 고유 ID
title: 제목
content: 본문
parentId : 상위 페이지 ID
subPage: 하위페이지
breadcrumbs: 브레드크럼즈
```
