package me.jhleed.sample.apiserver.controller.rest;

import me.jhleed.sample.apiserver.model.entity.Post;
import me.jhleed.sample.apiserver.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController controller;

    @Autowired
    private PostRepository repository;

    @BeforeEach
    void setUp() {
        repository.save(Post.builder()
                .author("jongholee")
                .content("it's content")
                .title("it's title")
                .build());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPost() {
        Long id = 1L;
        Post post = controller.getPost(id);
        assertNotNull(post);
    }
}