package com.example.webservice.service;

import com.example.webservice.Dto.Posts.PostsSaveRequestDto;
import com.example.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        // Controller에서 Dto를 Entity로 변환하지 않고 보내는 이유는
        // Controller와 Service의 역할을 확실하게 분담하기 위해서이다.
        // 대개 Controller는 View와의 연결을, Service는 비즈니스로직과 트랜젝션을 관리하기 때문이다.

        return postsRepository.save(dto.toEntity()).getId();

    }

}
