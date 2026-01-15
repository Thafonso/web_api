package org.github.thafonso.project_api_springboot.web.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.github.thafonso.project_api_springboot.service.ProductService;
import org.github.thafonso.project_api_springboot.web.dto.ProductRequest;
import org.github.thafonso.project_api_springboot.web.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/products", produces = "application/json", consumes = "application/json")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping(consumes = "*/*")
    public ResponseEntity <Page<ProductResponse>> list (@PageableDefault (size = 20, sort = "createdAt") Pageable products) {
        var page = service.list(products);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{id}", consumes = "*/*")
    public ResponseEntity <ProductResponse> get (@PathVariable @Positive Long Id) {
        var dto = service.get(Id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity <ProductResponse> create(@RequestBody @Valid ProductRequest req) {
        var saved = service.create(req);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(saved.Id()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity delete(@PathVariable Long Id ) {
         service.delete(Id);
         return ResponseEntity.noContent().build();
    }
}
