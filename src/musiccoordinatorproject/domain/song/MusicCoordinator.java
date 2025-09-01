package musiccoordinatorproject.domain.song;

import java.util.Optional;

import com.google.zxing.WriterException;

import musiccoordinatorproject.infra.llm.BaseModel;
import musiccoordinatorproject.infra.llm.BaseResponse;
import musiccoordinatorproject.infra.llm.LLMContext;
import musiccoordinatorproject.infra.llm.LLMProvider;
import musiccoordinatorproject.infra.llm.exception.LLMException;
import musiccoordinatorproject.infra.llm.gemini.chat.GeminiRequest;
import musiccoordinatorproject.infra.qrcode.QrCodeGenerator;
import musiccoordinatorproject.infra.qrcode.dto.QrCodeDTO;

public class MusicCoordinator {
	
	private LLMContext context = new LLMContext();
	private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
	private final String API_KEY = "Gemini-API-KEY";
	
	public Optional<Song> recommend(String prompt) {
		try {
			prompt += ". 이 감정에 어울리는 한국 노래를 1곡 추천해줘.";
			BaseModel model = context.initChatModel(API_URL, API_KEY, LLMProvider.GEMINI);
			BaseResponse response = model.invoke(new GeminiRequest<SongFormat>(prompt, SongFormat.INSTANCE));
			Song song = Song.fromMap(response.messageToMap().getFirst());
			
			String qrCodeText = "https://www.youtube.com/results?search_query=" + song.artist() + "-" + song.name();
			
			QrCodeGenerator generator = new QrCodeGenerator();
			QrCodeDTO dto = new QrCodeDTO(qrCodeText, song.name());
			generator.generate(dto);
			
			return Optional.of(song);
			
		} catch(LLMException e) {
			System.out.println(e.code().message());
			//e.printStackTrace();
			
		} catch (WriterException e) {
			e.printStackTrace();
			
		}
		
		return Optional.empty();
	}
}
