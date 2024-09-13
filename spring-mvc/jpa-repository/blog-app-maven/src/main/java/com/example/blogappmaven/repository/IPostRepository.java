package com.example.blogappmaven.repository;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    // Tìm kiếm bài viết theo tiêu đề, bao gồm danh mục
    @Query("SELECT p FROM Post p JOIN FETCH p.category WHERE p.title LIKE %:title%")
    Page<Post> findByTitleContaining(@Param("title") String title, Pageable pageable);

    // Tìm kiếm bài viết theo danh mục, bao gồm danh mục
    @Query("SELECT p FROM Post p JOIN FETCH p.category WHERE p.category = :category")
    Page<Post> findByCategory(@Param("category") Category category, Pageable pageable);

    // Tìm kiếm bài viết theo tiêu đề và danh mục, bao gồm danh mục
    @Query("SELECT p FROM Post p JOIN FETCH p.category WHERE p.title LIKE %:title% AND p.category = :category")
    Page<Post> findByTitleContainingAndCategory(@Param("title") String title, @Param("category") Category category, Pageable pageable);

    // Tìm tất cả các bài viết, bao gồm danh mục
    @Query("SELECT p FROM Post p JOIN FETCH p.category")
    Page<Post> findAllWithCategory(Pageable pageable);
}
