package OOP.g_factory;

public class Run {

	public static void main(String[] args) {
		SMTPConnector connector = ConnectorFactory.create(EmailConfig.DAUM);
		connector.connect();
	}

}
