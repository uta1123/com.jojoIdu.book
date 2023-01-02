package com.jojoIdu.book.springboot.service.posts;

import com.jojoIdu.book.springboot.domain.posts.Posts;
import com.jojoIdu.book.springboot.domain.posts.PostsRepository;
import com.jojoIdu.book.springboot.web.dto.PostsResponseDto;
import com.jojoIdu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoIdu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    //쿼리 날리는 부분이 없음
    //JPA 영속성 컨텍스트 -> 엔티티를 영구저장하는 환경
    // 엔티티가 영속성 컨텍스트에 포함되어 있는가 ?
    //더티체킹
    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return id;
    }


    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
