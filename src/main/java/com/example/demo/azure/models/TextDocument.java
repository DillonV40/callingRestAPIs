package com.example.demo.azure.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TextDocument {

    private String language;
    private String id;
    private String text;

    public TextDocument(String id, String text, String language) {
        super();
        this.id = id;
        this.text = text;
        this.language = language;
    }
}
