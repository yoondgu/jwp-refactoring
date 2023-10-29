package kitchenpos.core.fixture;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import kitchenpos.core.domain.menu.Menu;
import kitchenpos.core.domain.menu.MenuGroup;
import kitchenpos.core.domain.menu.MenuProduct;
import kitchenpos.core.domain.product.Product;

public class MenuFixture {

    public static Menu 세트_메뉴_1개씩(
            final String name,
            final BigDecimal price,
            final MenuGroup menuGroup,
            final List<Product> products
    ) {
        final List<MenuProduct> menuProducts = products.stream()
                .map(product -> new MenuProduct(product, 1))
                .collect(Collectors.toList());
        return new Menu(1L, name, price, menuGroup.getId(), menuProducts);
    }
}