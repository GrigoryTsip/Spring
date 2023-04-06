package org.example.repository;

import org.example.exception.NotFoundException;
import org.example.model.Post;
import org.example.model.PostDouble;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Stub
@Repository
public class PostRepository {
    
    private static final ConcurrentHashMap<Long, Post> postMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, PostDouble> postDobleMap = new ConcurrentHashMap<>();
    
    public PostRepository() {
    
    }
    
    public List<Post> all() {
        if (postMap.isEmpty()) {
            throw new NotFoundException("Список постов пуст");
        }
        List<Post> data = new ArrayList<>();
        for (Map.Entry<Long, Post> entry : postMap.entrySet()) {
            if (!postDobleMap.get(entry.getKey()).isDelete()) data.add(entry.getValue());
        }
        if (data.isEmpty()) {
            throw new NotFoundException("Список постов пуст");
        }
        return data;
    }
    
    public Optional<Post> getById(Long id) {
        if (id != null && postMap.containsKey(id)
        && !postDobleMap.get(id).isDelete()) {
            return Optional.ofNullable(postMap.get(id));
        }
        throw new NotFoundException("Неверный идентификатор поста");
    }
    
    public Post save(Post post) {
        if (post.getId() != null && postMap.containsKey(post.getId())) {
            postMap.put(post.getId(), post);
        } else {
            Post newPost = new Post(post.getContent());
            postMap.put(newPost.getId(), newPost);
            
            PostDouble newPostDouble = new PostDouble();
            postDobleMap.put(newPost.getId(), newPostDouble);
            return newPost;
        }
        return post;
    }
    
    public void removeById(Long id) {
        if (id != null) {
            if (postMap.containsKey(id)) postDobleMap.get(id).setIsDelete();
        }
    }
}
