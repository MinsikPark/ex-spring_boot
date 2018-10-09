package com.example.webservice.service;

import com.example.webservice.Dto.Posts.PostsSaveRequestDto;
import com.example.webservice.domain.posts.Posts;
import com.example.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void savePostUsingService(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                    .title("테스트 타이틀")
                                    .content("테스트 본문")
                                    .author("pms3300").build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);

        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}
