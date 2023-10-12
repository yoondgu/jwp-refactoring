# 키친포스

## 요구 사항

### 상품

* `API` 상품을 등록할 수 있다.
    - [x] 상품을 등록할 때는 이름과 가격 정보를 저장한다.
        - [ ] 이름: 255자 이하
        - [ ] 가격: 19자리, 소수점 2자리까지 가능
* `API` 모든 상품 목록을 조회할 수 있다.

### 메뉴 그룹

* `API` 특정 메뉴를 그룹으로 묶을 수 있는 메뉴 그룹을 등록할 수 있다.
    - [x] 메뉴 그룹을 등록할 때는 그룹의 이름을 저장한다.
* `API` 모든 메뉴 그룹 목록을 조회할 수 있다.

### 메뉴

* `API` 실제로 주문받을 수 있는 메뉴를 등록할 수 있다.
    - [x] 메뉴를 등록할 때는 이름, 가격, 소속된 메뉴 그룹, 구성된 메뉴 상품 목록을 저장한다.
        - [ ] 이름: 255자 이하
        - [ ] 가격: 19자리, 소수점 2자리까지 가능, 0
    - [x] 메뉴는 1 종류 이상의 메뉴 상품으로 구성되어 있으며, 각 메뉴 상품은 수량을 가진다.
    - [x] 메뉴는 1개의 메뉴 그룹에 속한다.
    - 메뉴를 구성하는 상품을 메뉴 상품이라고 한다.
        - [x] 메뉴 가격은 메뉴 상품들의 가격 총 합보다 클 수 없다.
* `API` 모든 메뉴 목록을 조회할 수 있다.

### 주문

* `API` 주문 정보를 등록할 수 있다.
    - [x] 주문을 등록할 때는 주문이 발생한 테이블(이하 주문 테이블), 주문 항목 목록, 주문 일시를 저장한다.
        - [ ] 주문 항목은 메뉴 정보와 수량으로 이루어져 있다.
    - [x] 새로 등록된 주문의 상태는 '조리' 상태이다.
    - [x] 주문 항목은 최소 1개 이상이어야 한다.
* `API` 특정 주문의 상태를 '식사' 또는 '계산 완료'로 변경할 수 있다.
* `API` 모든 주문 목록을 조회할 수 있다.

### 테이블

* `API` 주문 테이블을 새로 등록할 수 있다.
    - [x] 주문 테이블을 등록할 때는 소속된 단체 지정, 인원 수, 빈 테이블 여부를 저장한다.
        - [ ] 인원 수는 0명 이상이다.
    - [x] 모든 주문 테이블은 등록 시점에는 소속된 단체가 없다.
* `API` 특정 테이블을 빈 테이블로 변경할 수 있다. (주문 불가한 테이블)
    - [ ] 해당하는 테이블 id가 존재해야 한다.
    - [x] 해당 테이블이 속한 단체가 없어야 한다.
    - [x] 해당 테이블은 '조리', '식사' 상태가 아니어야 한다.
* `API` 특정 테이블의 방문한 손님 수를 변경할 수 있다.
    - [ ] 해당하는 테이블 id가 존재해야 한다.
    - [x] 방문한 손님 수는 0 이상이어야 한다.
    - [x] 해당하는 테이블은 빈 테이블이 아니어야 한다.

### 단체 지정

* `API` 단체를 새로 지정할 수 있다.
    - [ ] 단체를 지정할 때는 단체에 속한 테이블 목록과 생성 일시를 저장한다.
    - [ ] 단체에 속한 테이블은 2개 이상이어야 한다.
    - [ ] 단체에 속한 테이블들은 모두 빈 테이블이어야 한다.
* `API` 단체 지정된 테이블들을 개별 테이블로 쪼갤 수 있다.
    - [ ] 해당 테이블들은 '조리', '식사' 상태가 아니어야 한다.

## 클래스 다이어그램

![class-diagram](https://www.plantuml.com/plantuml/png/XLCzRzim4DtvAwxkbjP3XmuL325j7HX6xIX0lBKTpj8r8SeFXJmDGP7_Nf6GJpO4MFP2FZs-UyTxl8sCWJjhr3j-9alG6jHEiM-1FHmzixVGw40rQ-zK_AjTYm4j6Es8Nri27_ZPArKRZ17sv3hufm2MOFlbG_1DLtCiOASZh_OZL0fd4tpNRfkUujrJHlNvfWswfWA-wQSrrTgYoQX3suEF77HFUvFYWzhWG7Ikd113mvcN3XrhVYt0z2V5v8M_I2yN1lDvOPoqgz1G65HzMX_mQ4Xe0ZyoSXV5ck3K7BIbnAxHh94fRSVFE-reosHFTrkTWwNqFx4ad9c69pwdLp1ezsmBrTWAh5QGC0gOCWDbcKjzWFtTrrsHLz-h_SFkxh2jxa_xwiVsVbECJkN21fjas-JnwBqXT1dYz7acFRsD8uNgpwQZc6Ae7KiD6VoLdCr7w20k9hEMqGXIJaNhGCZKh94ditvJAhyd-Iq-BU1c-VFzvo_f_p4_rT_B4XRdR-sNkrcS1rlbylCQ5wdAAfTvKMEdypgPEuZ8NjsIQpfh_WC0)

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |
