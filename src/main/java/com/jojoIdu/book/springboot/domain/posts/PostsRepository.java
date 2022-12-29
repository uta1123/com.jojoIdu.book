package com.jojoIdu.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//일반적 DAO 클래스 서비스에서 이걸 호출함. JpaRepository<Entity클래스,PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동 생성
//Entity클래스와 기본 EntityRepository는 함께 위치해야함 그리고 이 둘의 합을 Domain 패키지에 같이 놓음.
@Repository
public interface PostsRepository extends JpaRepository<Posts,Long>{
}
