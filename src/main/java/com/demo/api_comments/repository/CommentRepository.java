package com.demo.api_comments.repository;

import com.demo.api_comments.model.CommentModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <CommentModel, Integer> {

   @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM CommentModel p WHERE p.idProduct = :idProduct")
   Boolean existsByIdProduct(Integer idProduct);

   @Query("SELECT c FROM CommentModel c WHERE c.idProduct = :idProduct")
   List <CommentModel> findAllByIdProduct(Integer idProduct);
}
