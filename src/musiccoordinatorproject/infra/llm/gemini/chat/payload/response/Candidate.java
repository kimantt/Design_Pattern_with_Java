package musiccoordinatorproject.infra.llm.gemini.chat.payload.response;

import musiccoordinatorproject.infra.llm.gemini.chat.payload.Content;

public record Candidate(
		Content content,
		String finishReason,
		int index
		) {

}
