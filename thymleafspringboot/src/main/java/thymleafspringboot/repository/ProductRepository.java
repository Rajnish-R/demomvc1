package thymleafspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thymleafspringboot.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
