## 영화 예매 기능 요구 사항

### 영화 예매 단계
1. 출력된 상영 영화 기반으로 예약할 영화 번호를 입력받는다.
   1. 영화의 번호가 유효한지 체크한다 [ 정수형, 존재하는 영화, 이미 예약한 영화 ]
2. 예약할 시간표를 입력받는다. 
   1. 시작시간이 지난 시간표는 출력하지 않는다. 
   2. 시간표가 유효한지 체크한다. [ 시간표 번호가 일치하는지 검사 ]
3. 입력한 시간표에 남은 좌석의 갯수를 출력하고, 예약인원을 입력받는다. 
   1. 남은 좌석과 비교해, 예약인원이 많을 경우 오류를 던진다.
   2. 예약인원이 정수가 아닐 경우 오류를 던진다.
4. 1 - 3 단계를 모두 수행할 경우 최종 예매 확인을 진행한다. 입력 [ 1 : 확인, 2 : 취소, 3 : 종료 ]
   1. 2를 선택할 경우 1 - 3 단계를 처음부터 실행한다.

### 결제 단계
1. 사용할 수 있는 포인트가 있으면 포인트를 입력한다. ( 있어도 입력 안해도됨. )
   1. 입력한 포인트가 예매금액보다 높을 경우 ( 차액을 반환한다. )
2. 결제시 카드, 현금인지 입력 ( 할인률 계산 )
   1. 신용카드 : 5%, 현금 : 2%
   2. 포인트를 뺀 금액에서 할인률 계산
3. 최종 결제 금액 및 메시지 출력