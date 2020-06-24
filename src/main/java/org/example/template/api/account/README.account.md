# API - ACCOUNT
## GET    : /accounts (사용자 목록 조회)
- role : ADMIN
- header
    - X
- param
    - limit  : Integer
    - offset : Integer
- body
    - X
## GET    : /account/:id (사용자 정보 조회)
- role : ADMIN / USER(본인정보만 가능)
- header
    - X
- param
    - id : Integer
- body
    - X
## POST   : /account (사용자 등록)
- role : ADMIN / USER
- header
    - csrf_token : String
- param
    - X
- body
    - username : String
    - password : String
## PUT    : /account (사용자 정보 수정)
- role : ADMIN / USER(본인정보만 가능)
- header
    - csrf_token : String
- param
    - X
- body
    - username : String
    - password : String
## DELETE : /account/:id (사용자 삭제)
- role : ADMIN / USER(본인정보만 가능)
- header
    - csrf_token : String
- param
    - id : Integer
- body
    - X