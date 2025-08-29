package musiccoordinatorproject.infra.llm.gemini.chat.payload.error;

public record GeminiErrorMessage(
		String code,
		String message
		) {

}
