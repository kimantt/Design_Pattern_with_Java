package musiccoordinatorproject.infra.llm.gemini.chat.payload.request;

public record ResponseSchema<T>(
		String type,
		Items<T> items
		) {

	public ResponseSchema(Items<T> items) {
		this("ARRAY", items);
	}
	
}
