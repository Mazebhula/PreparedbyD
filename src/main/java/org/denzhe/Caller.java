package org.denzhe;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Caller {
    public String getGeneratedText() {
        return generatedText;
    }

    private String generatedText;
    public Caller(String prompt) {
        HttpClient client = HttpClient.newHttpClient();
        String payload = """
                {
                "model":"deepseek-r1:7b",
                "prompt":"%s",
                "stream":false
                }
                """.formatted(prompt.replace("\"", "\\\""));
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:11434/api/generate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the response JSON
            ObjectMapper mapper = new ObjectMapper();
            var jsonResponse = mapper.readTree(response.body());

            // Extract and print the generated text
            System.out.println(jsonResponse);
            generatedText = jsonResponse.get("response").asText();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
