package musiccoordinatorproject.infra.llm.gemini.chat.payload.request;

public record Items<T>(
		String type,
		T properties
		) {

	public Items(T properties) {
		this("OBJECT", properties);
	}

}
