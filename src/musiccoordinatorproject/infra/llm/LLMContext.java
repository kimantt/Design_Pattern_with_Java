package musiccoordinatorproject.infra.llm;

import musiccoordinatorproject.infra.llm.gemini.chat.GeminiChatModel;

public class LLMContext {

	public BaseModel initChatModel(String url, String apiKey, LLMProvider provider) {
		return switch(provider) {
		case GEMINI -> GeminiChatModel.getInstance(url, apiKey);
		};
	}
}
