package me.khmoon.demojpa3.post;

import org.junit.Test;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

@Configuration
public class PostRepositoryTestConfig {

  @Bean
  public ApplicationListener<PostPublishedEvent> postListener() {
    return event -> {
        System.out.println("------------------------");
        System.out.println(event.getPost().getTitle() + "is published!!");
        System.out.println("------------------------");
    };
  }

}