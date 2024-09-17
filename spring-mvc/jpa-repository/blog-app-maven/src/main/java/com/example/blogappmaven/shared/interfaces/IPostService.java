package com.example.blogappmaven.shared.interfaces;

import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.model.PostDTO;
import com.example.blogappmaven.shared.ICommon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IPostService extends ICommon<Post> {
    Page<Post> findAll(Pageable pageable, Sort sort, String search, String categoryName);

    Page<Post> findPostsByCategory(Long id, Pageable pageable);

    PostDTO convertToPostDTO(Post post);
}
