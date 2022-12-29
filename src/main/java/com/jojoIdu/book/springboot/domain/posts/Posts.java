package com.jojoIdu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity //테이블과 연결될 클래스임을 명시, 카멜케이스함수 명을 테이블명 언더스코어 네이밍으로 변경 매핑 , Setter는 사용하지말것
//실제 DB테이블과 매칭될 클래스임
public class Posts {


    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)// PK 생성규칙을 나타냄 해당 옵션은 auth_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title ;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content ;


    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성 , 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
