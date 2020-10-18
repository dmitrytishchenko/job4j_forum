package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.*;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private int idPost;

    public PostService() {
        posts.add(new Post(
                ++idPost,
                "Продаю машину лада",
                "Осуждения продажи",
                Calendar.getInstance()));
    }

    public Post addPost(Post post) {
        posts.add(post);
        return post;
    }

    public Post getPost(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    public List<Post> getAllPosts() {
        return posts;
    }
}
