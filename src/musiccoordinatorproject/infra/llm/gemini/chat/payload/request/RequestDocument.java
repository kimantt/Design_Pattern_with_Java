package musiccoordinatorproject.infra.llm.gemini.chat.payload.request;

import java.util.List;

import musiccoordinatorproject.infra.llm.gemini.chat.payload.Content;

public record RequestDocument<T>(
		List<Content> contents,
		GenerationConfig<T> generationConfig
		) {

}
