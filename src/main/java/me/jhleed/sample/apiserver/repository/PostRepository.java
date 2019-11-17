package me.jhleed.sample.apiserver.repository;

import me.jhleed.sample.apiserver.model.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
