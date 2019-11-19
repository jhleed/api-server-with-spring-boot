package me.jhleed.sample.apiserver.controller.rest;

import me.jhleed.sample.apiserver.model.entity.Post;
import me.jhleed.sample.apiserver.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    @Disabled("같은 시간을 가진다.")
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        repository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());
        //when
        Iterable<Post> postsList = repository.findAll();

        //then
        Post posts = postsList.iterator().next();

        //실패, 생성 시간과 수정 시간이 동일하다.
        assertAll(
                () -> assertTrue(posts.getCreatedTime().isAfter(now)),
                () -> assertTrue(posts.getModifiedTime().isAfter(now))
        );
    }
}