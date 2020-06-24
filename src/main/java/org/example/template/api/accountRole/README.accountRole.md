# API - ACCOUNT_ROLE
## GET    : /account_roles (사용자 권한 목록 조회)
- role : ADMIN
- header
    - X
- param
    - limit  : Integer
    - offset : Integer
- body
    - X
## GET    : /account_role/:account_id (사용자 권한 정보 조회)
- role : ADMIN
- header
    - X
- param
    - account_id : Integer
- body
    - X
## POST   : /account_role (사용자 권한 추가)
- role : ADMIN
- header
    - csrf_token : String
- param
    - X
- body
    - account_id : Integer
    - role_id : Integer
## PUT    : /account_role (사용자 권한 수정)
- role : ADMIN
- header
    - csrf_token : String
- param
    - X
- body
    - account_id : Integer
    - role_id : Integer
## DELETE : /account/:id (사용자 권한 삭제)
- role : ADMIN
- header
    - csrf_token : String
- param
    - id : Integer
- body
    - X