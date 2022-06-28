package com.example.postcoreapi.controller;

import com.example.postcoreapi.entity.PostEntity;
import com.example.postcoreapi.service.PostService;
import com.example.postcoreapi.util.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostValidator postValidator;

    @PostMapping("/add")
    public ResponseEntity<String> createPost(@Valid @RequestBody PostEntity postEntity, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>("ERRORS WIT POSTID",HttpStatus.NOT_FOUND);
        }
        postService.createPost(postEntity);

        return new ResponseEntity<String>("Created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostEntity> getAllModel(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostEntity getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable Long postId ,@Valid @RequestBody PostEntity postmodel){
        postService.updatePostById(postId,postmodel);

        return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> delete(@PathVariable Long postId){
        postService.deletePostById(postId);

        return new ResponseEntity<>("DELETED",HttpStatus.OK);
    }

}
