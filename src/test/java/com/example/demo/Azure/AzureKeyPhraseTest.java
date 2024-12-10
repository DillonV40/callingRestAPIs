package com.example.demo.Azure;

import com.example.demo.azure.models.TextDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class AzureKeyPhraseTest {

    private static final String AZURE_ENDPOINT = "https://landon-hotel-feedback-5460.cognitiveservices.azure.com";
    private static final String AZURE_ENDPOINT_PATH = "";
    private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private static final String EXAMPLE_JSON = """
            {
              "kind": "KeyPhraseExtraction",
              "parameters": {
                "modelVersion": "latest"
              },
              "analysisInput": {
                "documents": [
                  {
                    "id": "1",
                    "language": "en",
                    "text": "Microsoft was founded by Bill Gates and Paul Allen."
                  },
                  {
                    "id": "2",
                    "language": "en",
                    "text": "Text Analytics is one of the Azure Cognitive Services."
                  },
                  {
                    "id": "3",
                    "language": "en",
                    "text": "My cat might need to see a veterinarian."
                  }
                ]
              }
            }
            """;

    private static final String textForAnalysis = "Microsoft was founded by Bill Gates and Paul Allen.";

    @Autowired
    public ObjectMapper mapper;

    @Test
    public void getKeyPhrases() throws IOException, InterruptedException {

        TextDocument document = new TextDocument("1", textForAnalysis, "en");


    }
}
