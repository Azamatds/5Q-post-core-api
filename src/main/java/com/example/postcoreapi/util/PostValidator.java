package com.example.postcoreapi.util;


import com.example.postcoreapi.entity.PostEntity;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    private final PostService postService;

    @Autowired
    public PostValidator(PostService postService) {
        this.postService = postService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PostEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostEntity p = (PostEntity) target;

        if(postService.getAllPosts()== null){
            errors.rejectValue("fullPostId", "", "Пост с таким ид уже существует");
        }

    }
}
