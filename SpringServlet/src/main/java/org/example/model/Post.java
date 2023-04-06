package org.example.model;

public class Post {
    private Long id;
    private String content;
    private static Long idCount = 1L;
    
    public Post(String content) {
        this.id = idCount++;
        this.content = content;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
}
