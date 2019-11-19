package me.jhleed.sample.apiserver.controller.rest;


import lombok.AllArgsConstructor;
import me.jhleed.sample.apiserver.model.common.ApiResponse;
import me.jhleed.sample.apiserver.model.dto.PostSaveRequestDto;
import me.jhleed.sample.apiserver.model.entity.Post;
import me.jhleed.sample.apiserver.service.PostService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post")
    public ApiResponse<Boolean> createPost(@RequestBody PostSaveRequestDto req) {
        ApiResponse<Boolean> result = new ApiResponse<>();
        try {
            service.save(req.toEntity());
            result.setData(true);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setData(false);
        }
        return result;
    }
}
