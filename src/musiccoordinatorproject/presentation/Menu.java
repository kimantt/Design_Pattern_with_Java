package musiccoordinatorproject.presentation;

import java.util.Optional;
import java.util.Scanner;

import musiccoordinatorproject.domain.song.MusicCoordinator;
import musiccoordinatorproject.domain.song.Song;

public class Menu {
	
	MusicCoordinator coordinator = new MusicCoordinator();

	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("오늘 기분을 말씀해주세요. 어울리는 노래를 추천해드립니다. (종료:exit)");
			System.out.print("입력 : ");
			String inp = sc.nextLine();
			
			if (inp.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			Optional<Song> optional = coordinator.recommend(inp);
			
			if (optional.isEmpty()) {
				System.out.println("오늘은 추천할 노래가 없어요.");
				continue;
			}
			
			System.out.println("-------------------------------");
			Song song = optional.get();
			System.out.println("노래 제목 : " + song.artist() + "-" + song.name());
			System.out.println("추천 이유 : " + song.reason());
			System.out.println("-------------------------------");
			
		}
		
		sc.close();
	}
	
}
