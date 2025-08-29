package musiccoordinatorproject.infra.llm;

public interface BaseModel {
	BaseResponse invoke(BaseRequest message);
}
