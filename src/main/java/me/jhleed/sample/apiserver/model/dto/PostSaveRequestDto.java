package me.jhleed.sample.apiserver.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jhleed.sample.apiserver.model.entity.Post;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
