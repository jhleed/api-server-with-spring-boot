package me.jhleed.sample.apiserver.service;

import lombok.AllArgsConstructor;
import me.jhleed.sample.apiserver.model.entity.Post;
import me.jhleed.sample.apiserver.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository repository;

    public Post getPost(Long id) {
        Optional<Post> post = repository.findById(id);
        return post.get();
    }

    public void save(Post entity) {
        repository.save(entity);
    }
}
