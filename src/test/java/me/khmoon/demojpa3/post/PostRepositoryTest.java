package me.khmoon.demojpa3.post;

import com.querydsl.core.types.Predicate;
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


import java.util.Optional;

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
    postRepository.save(post.publish());

    Predicate predicate = QPost.post.title.containsIgnoreCase("hibernate");

    // 왜 안되냐
//    Optional<Post> one = postRepository.findOne(predicate);
//    assertThat(one).isNotEmpty();

  }
}