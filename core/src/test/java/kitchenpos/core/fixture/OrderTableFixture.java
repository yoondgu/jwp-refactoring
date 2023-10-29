package kitchenpos.core.fixture;

import kitchenpos.core.domain.ordertable.OrderTable;

public class OrderTableFixture {

    public static OrderTable 주문_테이블_생성() {
        return new OrderTable(1L, null, 0, false);
    }

    public static OrderTable 존재하지_않는_주문_테이블_생성() {
        return new OrderTable(-1L, null, 0, false);
    }

    public static OrderTable 빈_테이블_생성() {
        return new OrderTable(1L, null, 0, true);
    }
}