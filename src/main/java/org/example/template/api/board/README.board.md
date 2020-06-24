# API - BOARD
## GET    : /boards (게시글 목록 조회)
- role : ADMIN / USER
- header
    - X
- param
    - limit  : Integer
    - offset : Integer
- body
    - X
## GET    : /board/:id (게시글 조회)
- role : ADMIN / USER
- header
    - X
- param
    - id : Integer
- body
    - X
## POST   : /board (게시글 등록)
- role : ADMIN / USER
- header
    - csrf_token : String
- param
    - X
- body
    - title : String
    - content : String
    - account_id : String
## PUT    : /board (게시글 수정)
- role : ADMIN / USER(본인 작성글만 가능)
- header
    - csrf_token : String
- param
    - X
- body
    - title : String
    - content : String
## DELETE : /board/:id (게시글 삭제)
- role : ADMIN / USER(본인 작성글만 가능)
- header
    - csrf_token : String
- param
    - id : Integer
- body
    - X