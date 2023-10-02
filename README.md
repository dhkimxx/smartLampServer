# smartLampServer
iot capstone project server

## Schema
- User (사용자 테이블)
    |컬럼명|설명|
    |---|---|
    |userId|사용자 고유 아이디|
    |userPw|사용자 비밀번호|
    |userName|사용자 이름|
    |phone|사용자 연락처(전화번호)|
    |unitList|등록 디바이스 리스트|
    

- Unit (디바이스 유닛 테이블)
    |컬럼명|설명|
    |---|---|
    |unitCode|디바이스 고유 코드|
    |unitName|디바이스 이름|
    |distance|탐지 거리|
    |time|점등 시간|
    |brightness|램프 밝기|
