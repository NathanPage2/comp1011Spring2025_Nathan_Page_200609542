package com.example.comp1011spring2025_nathan_page_200609542;

public class QuestionOption {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content.length() < 3)
            throw new IllegalArgumentException("The length of the content is less than 3!");

        this.content = content;
    }
    public QuestionOption(String content) {
        setContent(content);
    }
}