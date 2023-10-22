package kitchenpos.repository;

import java.util.List;
import kitchenpos.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsById(Long productId);

    List<Product> findAllByIdIn(List<Long> productIds);
}