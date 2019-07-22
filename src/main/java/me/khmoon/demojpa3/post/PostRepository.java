package me.khmoon.demojpa3.post;

import me.khmoon.demojpa3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends MyRepository<Post, Long> {

}
