package com.example.demo.azure.services;

import com.example.demo.azure.models.SentimentAnalysis;
import com.example.demo.azure.models.TextAnalyticsRequest;
import com.example.demo.azure.models.TextDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class AzureSentimentService {

    @Value("${AZURE_API_KEY}")
    private String azureApiKey;

    @Autowired
    private ObjectMapper mapper;

    private static final String AZURE_ENDPOINT = "https://landon-hotel-feedback-5460.cognitiveservices.azure.com";
    private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    public SentimentAnalysis requestSentimentAnalysis(String text, String language) throws IOException, InterruptedException {

        TextDocument document = new TextDocument("1", text, language);
        TextAnalyticsRequest requestBody = new TextAnalyticsRequest();
        requestBody.getDocuments().add(document);

        String endpoint = AZURE_ENDPOINT + "";



    }


}
