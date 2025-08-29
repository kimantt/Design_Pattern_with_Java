package musiccoordinatorproject.infra.llm;

public interface BaseRequest {

	//List<Map<String, Object>> messageToMap();
	<T> String messageToJson();
}
