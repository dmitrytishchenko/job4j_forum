package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping({"/create"})
    public String createNewPost(@ModelAttribute Post post) {
        return "create";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(@RequestParam("id") long id,
                         @RequestParam("name") String name,
                         @RequestParam("desc") String desc,
                         @RequestParam("created") String created
    ) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        cal.setTime(sdf.parse(created));
        Post post = new Post(id, name, desc, cal);
        posts.addPost(post);
        return "redirect:/index";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("post", posts.getPost(id).get());
        return "post";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable long id, Model model) {
        Optional<Post> post = posts.getPost(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
        }
        return "edit";
    }
}
