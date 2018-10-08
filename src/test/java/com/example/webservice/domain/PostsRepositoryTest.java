package com.example.webservice.domain;

import com.example.webservice.domain.posts.Posts;
import com.example.webservice.domain.posts.PostsRepository;
import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();

    }
    @Test
    public void callStoredPosts(){
        //given
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .content("테스트 본문")
            .author("pms3300").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        /*
        Tip)
        DB가 설치가 안되어있는데 Repository를 사용할 수 있는 이유는, SpringBoot에서의 테스트 코드는 메모리 DB인 H2를 기본적으로 사용하기 때문입니다.
        테스트 코드를 실행하는 시점에 H2 DB를 실행시킵니다.
        테스트가 끝나면 H2 DB도 같이 종료됩니다.

        http://localhost:8080/h2-console를 입력해 확인 가능

        JDBCURL = jdbc:h2:mem:testdb

         */
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_Regi(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("pms3300")
                .build());
        //when

        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));


    }


}
