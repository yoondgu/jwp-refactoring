package kitchenpos.application;

import java.util.List;
import kitchenpos.domain.Product;
import kitchenpos.dto.ProductCreateRequest;
import kitchenpos.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(final ProductCreateRequest request) {
        return productRepository.save(new Product(request.getName(), request.getPrice()));
    }

    @Transactional(readOnly = true)
    public List<Product> list() {
        return productRepository.findAll();
    }
}
