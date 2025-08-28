package musiccoordinatorproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Run {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
			     .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent"))
			     .timeout(Duration.ofMinutes(2))
			     .header("Content-Type", "application/json")
			     .header("X-goog-api-key", "Your-gemini-api-key")
			     .POST(BodyPublishers.ofString("{\r\n"
			     		+ "  \"contents\": [\r\n"
			     		+ "    {\r\n"
			     		+ "      \"parts\": [\r\n"
			     		+ "        {\r\n"
			     		+ "          \"text\": \"나 오늘 행복해. 오늘 감정에 어울리는 노래 한 곡 추천해줘.\"\r\n"
			     		+ "        }\r\n"
			     		+ "      ]\r\n"
			     		+ "    }\r\n"
			     		+ "  ],\r\n"
			     		+ "  \"generationConfig\": {\r\n"
			     		+ "    \"responseMimeType\": \"application/json\",\r\n"
			     		+ "    \"responseSchema\": {\r\n"
			     		+ "      \"type\": \"OBJECT\",\r\n"
			     		+ "      \"properties\": {\r\n"
			     		+ "        \"name\": { \"type\": \"STRING\" },\r\n"
			     		+ "        \"artist\": { \"type\": \"STRING\" },\r\n"
			     		+ "        \"reason\": { \"type\": \"STRING\" }\r\n"
			     		+ "      },\r\n"
			     		+ "      \"propertyOrdering\": [\"name\", \"artist\", \"reason\"]\r\n"
			     		+ "    }\r\n"
			     		+ "  }\r\n"
			     		+ "}"))
			     .build();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.body());
		
		
		System.out.println("----------끝----------");
	}

}
