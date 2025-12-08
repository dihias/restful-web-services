package com.didi.rest.webservices.restful_web_services.user.jpa;

import com.didi.rest.webservices.restful_web_services.user.Post;
import com.didi.rest.webservices.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
