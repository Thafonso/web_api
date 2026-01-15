package org.github.thafonso.project_api_springboot.service;

import lombok.RequiredArgsConstructor;
import org.github.thafonso.project_api_springboot.domain.entity.Product;
import org.github.thafonso.project_api_springboot.domain.repository.ProductRepository;
import org.github.thafonso.project_api_springboot.web.dto.ProductRequest;
import org.github.thafonso.project_api_springboot.web.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

    public Page<ProductResponse> list (Pageable pageable) {
        return repo.findAll(pageable).map(this::toResponse);
    }
    public ProductResponse get(Long Id) {
        return toResponse(findOrThrow(Id));
    }

    public ProductResponse create(ProductRequest req) {
        var entity = Product.builder().productName(req.productName()).productPrice(req.productPrice()).category(req.category()).build();
        return toResponse(repo.save(entity));
    }

    public void delete (Long Id){
        findOrThrow(Id);
        repo.deleteById(Id);
    }

    private Product findOrThrow(Long Id) {
        return repo.findById(Id).orElseThrow(()-> new NotFoundException("Id not found"));
    }

    private ProductResponse toResponse (Product p) {
        return new ProductResponse(p.getId(), p.getProductName(), p.getProductPrice(), p.getCategory(), p.getCreatedAt());
    }

}
