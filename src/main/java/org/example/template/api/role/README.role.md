# API - ROLE
## GET    : /roles (권한 목록 조회)
- role : ADMIN
- header
    - X
- param
    - limit  : Integer
    - offset : Integer
- body
    - X
## GET    : /role/:id (권한 정보 조회)
- role : ADMIN
- header
    - X
- param
    - id : Integer
- body
    - X
## POST   : /role (권한 등록)
- role : ADMIN
- header
    - csrf_token : String
- param
    - X
- body
    - name : String
## PUT    : /role (권한 정보 수정)
- role : ADMIN
- header
    - csrf_token : String
- param
    - X
- body
    - name : String
## DELETE : /role/:id (권한 삭제)
- role : ADMIN
- header
    - csrf_token : String
- param
    - id : Integer
- body
    - X