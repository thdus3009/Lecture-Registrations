# Lecture-Registrations
특강 신청 서비스

## Description

- `특강 신청 서비스`를 구현해 봅니다.
- 항해 플러스 토요일 특강을 신청할 수 있는 서비스를 개발합니다.
- 특강 신청 및 신청자 목록 관리를 RDBMS를 이용해 관리할 방법을 고민합니다.

## Requirements

- 아래 2가지 API 를 구현합니다.
    - 특강 신청 API
    - 특강 신청 여부 조회 PI
- 각 기능 및 제약 사항에 대해 단위 테스트를 반드시 하나 이상 작성하도록 합니다.
- 다수의 인스턴스로 어플리케이션이 동작하더라도 기능에 문제가 없도록 작성하도록 합니다.
- 동시성 이슈를 고려하여 구현합니다.

<br>

### 특강 신청 api ( POST /lectures/{user_id}/registrations/{lecture_id} )

> 동일한 아이디는 중복신청 불가 <br>
> 선착순 30명, 이미 신청자가 30명이 초과하면 이후 신청자는 요청 실패
> 

### 특강 신청 완료 여부 조회 api ( GET /lectures/{user_id}/registrations )

> 특정 userId로 특강 신청 완료 여부를 조회 <br>
> (return true / false)


![스크린샷 2024-03-27 오전 6 48 49](https://github.com/thdus3009/Lecture-Registrations/assets/63095234/9fabf8d0-e950-4e4f-98f2-18675589a3da)
