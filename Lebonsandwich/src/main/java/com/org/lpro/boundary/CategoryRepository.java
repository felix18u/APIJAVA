package com.org.lpro.boundary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.lpro.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,String>{
	
	
}
