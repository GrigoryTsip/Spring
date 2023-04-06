package org.example.model;

import java.util.concurrent.atomic.AtomicLong;

public class Post {
    private Long id;
    private String content;
    private static Long idCount = 1L;
    
    public Post() {
    }
    
    public Post(String content) {
        //id = idCount.incrementAndGet();
        this.id = idCount++;
        this.content = content;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
