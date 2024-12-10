package com.example.demo.azure.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SentimentAnalysis {

    private TextDocument document;
    private String sentiment;

    public SentimentAnalysis(TextDocument document) { this.document = document; }

    public SentimentAnalysis(TextDocument document, String sentiment) {
        this.document = document;
        this.sentiment = sentiment;
    }
}
