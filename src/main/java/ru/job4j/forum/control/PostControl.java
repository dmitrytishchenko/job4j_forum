package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/post"})
    public String getPost(@RequestParam(value = "id", required = false) Long id, Model model) {
        Optional<Post> post = posts.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping({"/edit"})
    public String editPost(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null) {
            Optional<Post> post = posts.getPost(Long.valueOf(id));
            model.addAttribute("post", post);
        }
        return "edit";
    }

    @PostMapping
    public String create(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("desc") String desc,
                         @RequestParam("created") String created,
                         Model model) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        cal.setTime(sdf.parse(created));
        Post post = new Post(id, name, desc, cal);
        posts.addPost(post);
        model.addAttribute("posts", posts.getAllPosts());
        return "index";
    }
}
