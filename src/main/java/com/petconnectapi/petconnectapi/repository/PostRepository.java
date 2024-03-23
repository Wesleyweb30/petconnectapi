package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.petconnectapi.petconnectapi.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
}

