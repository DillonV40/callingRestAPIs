package com.example.demo.Azure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AzureNamedEntitiesTest {

    @Value("${AZURE_API_KEY}")
    private String azureApiKey;

    private static final String AZURE_ENDPOINT = "https://landon-hotel-feedback-5460.cognitiveservices.azure.com";

    private static final String AZURE_ENDPOINT_PATH = "/language/:analyze-text?api-version=2024-11-01";

    private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";

    private static final String CONTENT_TYPE = "Content-Type";

    private static final String APPLICATION_JSON = "application/json";

    private static final String EXAMPLE_JSON = """
            {
              "kind": "SentimentAnalysis",
              "parameters": {
                "modelVersion": "latest"
              },
              "analysisInput": {
                "documents": [
                  {
                    "id": "1",
                    "language": "en",
                    "text": "Great atmosphere. Close to plenty of restaurants, hotels, and transit! Staff are friendly and helpful."
                  },
                  {
                    "id": "2",
                    "language": "en",
                    "text": "Horrible atmostphere. The workers do not know what they are doing. The food was just frozen meals microwaved, I will not be coming back."
                  },
                  {
                    "id": "3",
                    "language": "en",
                    "text": "Normal atmostphere. The food is of italian origin. They have spagetti, meat balls, and wine."
                  }
                ]
              }
            }
            """;

    @Test
    public void getEntities() throws IOException, InterruptedException {

        // 1. Create a client
        HttpClient client = HttpClient.newHttpClient();

        // 2. Create a request
        HttpRequest request = HttpRequest.newBuilder()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .header(API_KEY_HEADER_NAME, azureApiKey)
                .uri(URI.create(AZURE_ENDPOINT + AZURE_ENDPOINT_PATH))
                .POST(HttpRequest.BodyPublishers.ofString(EXAMPLE_JSON))
                .build();

        // 3. Send the request and receive response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 4. Work with the response
        assertEquals(200, response.statusCode());
        System.out.println(response.body());
    }

}
