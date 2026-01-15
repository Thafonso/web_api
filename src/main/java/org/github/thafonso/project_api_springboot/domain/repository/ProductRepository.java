package org.github.thafonso.project_api_springboot.domain.repository;


import org.github.thafonso.project_api_springboot.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
