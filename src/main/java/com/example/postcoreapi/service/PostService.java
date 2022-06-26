package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    public void createPost(PostModel postModel);
    public List<PostModel> getAllPosts();
    public PostModel  getPostById(String postId);
    public void  updatePostById(String postId ,PostModel postModel);
    public void  deletePostById(String postId);

}
