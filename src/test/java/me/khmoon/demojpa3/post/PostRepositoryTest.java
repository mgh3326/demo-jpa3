package me.khmoon.demojpa3.post;

import me.khmoon.demojpa3.post.Post;
import me.khmoon.demojpa3.post.PostPublishedEvent;
import me.khmoon.demojpa3.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;


  @Test
  public void crud() {
    Post post = new Post();
    post.setTitle("hipernate");

    assertThat(postRepository.contains(post)).isFalse();

    postRepository.save(post.publish());
    assertThat(postRepository.contains(post)).isTrue();


    postRepository.delete(post);
    postRepository.flush();

  }
}