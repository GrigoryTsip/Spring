package org.example.model;

public class PostDouble {
    Boolean isDelete;
    
    public PostDouble() {
        this.isDelete = false;
    }
    
    public void setIsDelete() {
        this.isDelete = true;
    }
    
    public boolean isDelete() {
        return this.isDelete;
    }
}
