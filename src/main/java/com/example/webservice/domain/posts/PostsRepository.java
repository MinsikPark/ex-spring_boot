package com.example.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository  extends JpaRepository<Posts, Long> {

    /*
    Repository는 mybatis에서 보통 DAO라고 불리는 DB Layer 접근자이며 인터페이스로 생성한다.
    단순히 인터페이스를 생성후, JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동생성 됩니다.
    특별히 @Repository를 추가할 필요도 없습니다.
     */
    @Query( "select p from Posts p order by p.id desc")
    Stream<Posts> findAllDesc();

}
