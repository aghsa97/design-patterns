package com.mycompany.app.easy.stack_overflow;

public class Tag {
    private final String id;
    private final String tag;
    
    public Tag(String id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
