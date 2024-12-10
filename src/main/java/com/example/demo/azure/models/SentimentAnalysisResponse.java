package com.example.demo.azure.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysisResponse {

    private List<TextDocumentScore> documents = new ArrayList<>();

    public List<TextDocumentScore> getDocuments() { return documents; }

    public void setDocuments(List<TextDocumentScore> documents) { this.documents = documents; }

    @Getter
    @Setter
    static class TextDocumentScore {
        private String id;
        private double score;
    }
}
