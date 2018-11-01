package com.example.webservice.Dto.Posts;

import com.example.webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {

    private Long id;
    private String title;
    private String author;
    private String modifiedDate; // View에서는 Date 타입을 인식하지 못하기 때문에 String 으로 변환해 준다.

    public PostsMainResponseDto(Posts posts){
        id = posts.getId();
        title = posts.getTitle();
        author = posts.getAuthor();
        modifiedDate = toStringDateTime(posts.getModifiedDate()) ;

    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");

    }

}
