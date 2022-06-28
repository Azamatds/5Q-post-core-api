package com.example.postcoreapi.service;

import com.example.postcoreapi.entity.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

//    private static final HashMap<String,PostModel> model = new HashMap<>();
//
//    static {
//        PostModel postModel = new PostModel(UUID.randomUUID().toString(),"1","first","book","OK");
//        PostModel postMode2 = new PostModel(UUID.randomUUID().toString(),"2","second","laptop","OK");
//        PostModel postMode3 = new PostModel(UUID.randomUUID().toString(),"3","third","phone","OK");
//
//        model.put(postModel.getPostId(),postModel);
//        model.put(postMode2.getPostId(),postMode2);
//        model.put(postMode3.getPostId(),postMode3);
//    }

    @Override
    public void createPost(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostEntity getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    @Transactional
    public void updatePostById(Long postId,PostEntity post) {
        post.setPostId(postId);
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
