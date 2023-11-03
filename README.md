# SmartLampServer

## 프로젝트 구조

```
main
 ┣ java
 ┃ ┗ smartLamp
 ┃ ┃ ┗ smartLampspring
 ┃ ┃ ┃ ┣ Entity
 ┃ ┃ ┃ ┃ ┣ Unit.java
 ┃ ┃ ┃ ┃ ┗ User.java
 ┃ ┃ ┃ ┣ controller
 ┃ ┃ ┃ ┃ ┣ UnitController.java
 ┃ ┃ ┃ ┃ ┗ UserController.java
 ┃ ┃ ┃ ┣ dto
 ┃ ┃ ┃ ┃ ┣ UnitInfoDto.java
 ┃ ┃ ┃ ┃ ┗ UserInfoDto.java
 ┃ ┃ ┃ ┣ repository
 ┃ ┃ ┃ ┃ ┣ JpaUnitRepository.java
 ┃ ┃ ┃ ┃ ┣ JpaUserRepository.java
 ┃ ┃ ┃ ┃ ┣ MemoryUnitRepository.java
 ┃ ┃ ┃ ┃ ┣ MemoryUserRepository.java
 ┃ ┃ ┃ ┃ ┣ UnitRepository.java
 ┃ ┃ ┃ ┃ ┗ UserRepository.java
 ┃ ┃ ┃ ┣ service
 ┃ ┃ ┃ ┃ ┣ UnitService.java
 ┃ ┃ ┃ ┃ ┗ UserService.java
 ┃ ┃ ┃ ┣ sms
 ┃ ┃ ┃ ┃ ┗ sendSms.java
 ┃ ┃ ┃ ┣ SmartLampSpringApplication.java
 ┃ ┃ ┃ ┗ SpringConfig.java
 ┗ resources
 ┃ ┣ properties
 ┃ ┃ ┗ env.properties
 ┃ ┣ templates
 ┃ ┃ ┗ hello.html
 ┃ ┗ application.properties
```

## 스키마

### User (사용자 테이블)

| 컬럼명     |설명             |
|----------|----------------|
| user_id  | 사용자 고유 아이디  |
| user_pw  | 사용자 비밀번호    |
| user_name| 사용자 이름       |
| phone    | 사용자 전화번호    |


### Unit (디바이스 유닛 테이블)

| 컬럼명       | 설명            |
|------------|----------------|
| unitCode   | 디바이스 고유 코드 |
| unit_name  | 디바이스 이름     |
| brightness | 램프 밝기        |
| distance   | 탐지 거리        |
| time       | 점등 시간        |
| user_id    | 사용자 아이디     |