package musiccoordinatorproject.infra.qrcode.dto;

// 불변 데이터 클래스 (field : private final)
// equals, hashcode, toString, getter
// canonical 생성자
public record QrCodeDTO(
		String text,
		String fileName,
		int width,
		int height,
		String format
		) {

	// canonical 생성자 이외의 다른 생성자를 사용할 때는
	// 반드시 다른 생성자에게 객체 생성을 위임시켜야 한다.
	public QrCodeDTO(String text, String fileName) {
		this(text, fileName, 300, 300, "PNG");
	}
}
