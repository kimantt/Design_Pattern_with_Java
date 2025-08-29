package musiccoordinatorproject.infra.llm.gemini.chat.payload;

import java.util.List;

public record Content(
		List<Part> parts,
		String role
		) {

	public Content(List<Part> parts) {
		this(parts, null);
	}
	
}
