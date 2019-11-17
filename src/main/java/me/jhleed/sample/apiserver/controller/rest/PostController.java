package me.jhleed.sample.apiserver.controller.rest;


import lombok.AllArgsConstructor;
import me.jhleed.sample.apiserver.model.entity.Post;
import me.jhleed.sample.apiserver.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    private PostService service;

    @GetMapping("/hello")
    public String hello() {
        return "hello jongho 안녕 종호;";
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return service.getPost(id);
    }
}
