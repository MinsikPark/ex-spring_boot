package com.example.webservice.web;

import com.example.webservice.Dto.Posts.PostsSaveRequestDto;
import com.example.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @ResponseBody를 모든 메소드에서 적용시켜준다.
 */
@AllArgsConstructor
/**
 *  Spring에서 Bean 객체를 주입받는 방법은 크게 두가지가 있다.
 *  하나는 @Autowired이며
 *  다른 하나는 생성자로 주입받는 방법이다.
 *
 * 이때, 생성자로 주입받는 방법을 사용하기 위해서는
 * @AllArgsConstructor 어노테이션을 활용한다.
 * 이는 Lombok 라이브러리에서 제공하는 어노테이션이다.
 * 이를 활용함으로써 생성자에 변화가 생길 때 마다 수정해야 하는 번거로움을 상당히 줄일 수 있다.
 */
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }


    @PostMapping("posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
