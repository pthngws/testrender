package com.group4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.entity.ProductDetailEntity;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long>{

}