package musiccoordinatorproject.infra.llm.gemini.chat;

import java.util.List;

import musiccoordinatorproject.infra.json.JsonProvider;
import musiccoordinatorproject.infra.llm.BaseRequest;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.Content;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.Part;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.request.GenerationConfig;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.request.Items;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.request.RequestDocument;
import musiccoordinatorproject.infra.llm.gemini.chat.payload.request.ResponseSchema;

public class GeminiRequest<T extends Format> implements BaseRequest {
	
	private String content;
	private T format;
	
	public GeminiRequest(String content, T format) {
		this.content = content;
		this.format = format;
	}

	@Override
	public String messageToJson() {
		ResponseSchema<T> schema = 
				new ResponseSchema<T>(new Items<>(format));
		
		GenerationConfig<T> config =
				new GenerationConfig<>(schema);
		
		RequestDocument<T> document = new RequestDocument<>(
				List.of(new Content(List.of(new Part(content)))), config);
		
		return JsonProvider.gson().toJson(document);
	}

}
