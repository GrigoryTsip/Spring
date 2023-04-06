package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Post;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;
    
    public PostController(PostService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Post> all() {
        return service.all();
    }
    
    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }
    
    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        
        service.removeById(id);
    }
}
