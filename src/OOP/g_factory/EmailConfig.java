package OOP.g_factory;

public enum EmailConfig {

	NAVER("smtp.naver.com", "mc", "123abc", 5000),
	DAUM("smtp.daum.net", "mc", "123abc", 5000),
	GOOGLE("smtp.google.com", "mc", "123abc", 5000);
	
	public final String url;
	public final String id;
	public final String password;
	public final int timeout;
	
	private EmailConfig(String url, String id, String password, int timeout) {
		this.url = url;
		this.id = id;
		this.password = password;
		this.timeout = timeout;
	}
	
}
