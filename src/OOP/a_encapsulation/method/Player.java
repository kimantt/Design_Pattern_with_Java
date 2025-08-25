package OOP.a_encapsulation.method;

public class Player {

	private String instrument;

	public Player(String instrument) {
		this.instrument = instrument;
	}
	
	public void play() {
		prepare();
		playing();
		stop();
		leave();
	}
	
	private void prepare() {
		System.out.println(instrument + " 연주를 준비합니다.");
	}
	
	private void playing() {
		System.out.println(instrument + " 연주를 시작합니다.");
	}
	
	private void stop() {
		System.out.println("연주를 중단합니다.");
	}
	
	private void leave() {
		System.out.println("공연장을 떠납니다.");
	}
	
}
