package musiccoordinatorproject.infra.llm.gemini.chat.payload.response;

import java.util.List;
import java.util.Map;

public record ResponseDocument(
		List<Candidate> candidates,
		Map<String, Object> usageMetadata,
		String modelVersion,
		String responseId) {

}
