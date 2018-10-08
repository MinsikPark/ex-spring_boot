package com.example.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 자동 추가, 기본생성자의 접근권한 설정
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동 생성
@Entity // 테이블과 링크될 클래스이다. 언더스코어 네임밍(_)으로 이름을 매칭한다.
        // SalesManager.java >> sales_Manager table
public class Posts extends BaseTimeEntity{

    /**
     *
     * 절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
     *
     *
     * @NoArgsConstructor
     * @Getter
     * @Builder
     * 이 세가지 어노테이션은 Lombok 라이브러리의 어노테이션이다.
     *
     */



    @Id // 테이블의 PK가 된다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙,스프링부트 2.0이상에서는 이와 같은 옵션이 필수
    private long id;

    @Column(length = 500, nullable = false) // 굳이 선언하지 않아도 컬럼이 되나 , 기본값에 변형을 주기 위해서 사용한다 .
                                            // 문자열의 경우 varchar(255)가 기본 옵션이다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /**
     * builder패턴활용 가능
     * 만약, 생성자의 파라미터가 복잡해지면, 원하는 인스턴스변수에 정확한 값이 들어갔는지를 명확히 확인할 수 없다.
     * builder패턴은 이러한 문제점을 보완하는 패턴으로 예를들어
     *
     * test(int a, int b)의 생성자의 경우, 객체를 생성할 때
     * test().a(a).b(b).build()
     * 의 형태로 객체를 생성함으로써 멤버필드 변수에 정확한 값을 입력하기 수월해진다.
     */
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
