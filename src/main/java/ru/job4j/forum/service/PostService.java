package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.*;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public Post addPost(Post post) {
        posts.save(post);
        return post;
    }

    public Optional<Post> getPost(Long id) {
        return posts.findById(id);
    }

    public List<Post> getAllPosts() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void delete(long id) {
        posts.deleteById(id);
    }
}
