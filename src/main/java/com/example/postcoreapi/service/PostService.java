package com.example.postcoreapi.service;

import com.example.postcoreapi.entity.PostEntity;

import java.util.List;

public interface PostService {
    public void createPost(PostEntity postEntity);
    public List<PostEntity> getAllPosts();
    public PostEntity  getPostById(Long postId);
    public void  updatePostById(Long postId ,PostEntity postModel);
    public void  deletePostById(Long postId);

}
