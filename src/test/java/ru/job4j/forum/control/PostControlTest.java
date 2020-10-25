package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {
    @MockBean
    private PostService posts;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PostControl control;

    @Test
    @WithMockUser
    public void createPostTest() throws Exception {
        this.mockMvc.perform(post("/")
                .param("id", "1")
                .param("name", "some name")
                .param("desc", "some desc")
                .param("created", "Fri Oct 16 20:47:19 MSK 2020"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).addPost(argument.capture());
        assertThat(argument.getValue().getName(), is("some name"));
    }

    @Test
    @WithMockUser
    public void editPostTest() throws Exception {
        Calendar calendar = new Calendar.Builder().build();
        Post post = new Post(1, "postName", "postDesc", calendar);
        this.control.create(
                post.getId(),
                post.getName(),
                post.getDesc(),
                "Fri Oct 16 20:47:19 MSK 2020");
        this.mockMvc.perform(get("/edit/{id}", post.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    public void test() {
        assertThat(control).isNotNull();
    }

    @Test
    @WithAnonymousUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/login"))//делаем запрос на главную страницу "/"
                .andDo(print())// вывод в консоль результата
                .andExpect(status().isOk())// ждем результата нашего запроса 200
                .andExpect(content()
                        .string(containsString(""))//ожидаем контент который содержит строку
                );
    }

    @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void correctLoginTest() throws Exception {
        this.mockMvc.perform(formLogin().user("user").password("123"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void badCredential() throws Exception {
        this.mockMvc.perform(post("/login").param("username", "1234"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error=true"));

    }
}