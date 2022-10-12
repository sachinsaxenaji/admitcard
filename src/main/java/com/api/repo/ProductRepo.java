package com.api.repo;

import com.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
	
	@Query("select u from Product u where u.RollNo = :RollNo")
    public Product getCardByRollNumber(@Param("RollNo") String rolln);
}
