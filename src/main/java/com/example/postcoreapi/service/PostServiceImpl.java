package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{
    private static final HashMap<String,PostModel> model = new HashMap<>();

    static {
        PostModel postModel = new PostModel(UUID.randomUUID().toString(),"1","first","book","OK");
        PostModel postMode2 = new PostModel(UUID.randomUUID().toString(),"2","second","laptop","OK");
        PostModel postMode3 = new PostModel(UUID.randomUUID().toString(),"3","third","phone","OK");

        model.put(postModel.getPostId(),postModel);
        model.put(postMode2.getPostId(),postMode2);
        model.put(postMode3.getPostId(),postMode3);
    }
    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        model.put(postModel.getPostId(),postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(model.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return model.get(postId);
    }

    @Override
    public void updatePostById(String postId,PostModel postModel) {
        postModel.setPostId(postId);
        model.put(postId,postModel);
    }

    @Override
    public void deletePostById(String postId) {
        model.remove(postId);
    }
}
