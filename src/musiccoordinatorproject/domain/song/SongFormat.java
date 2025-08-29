package musiccoordinatorproject.domain.song;

import musiccoordinatorproject.infra.llm.gemini.chat.Format;
import musiccoordinatorproject.infra.llm.gemini.chat.code.SchemaType;

public record SongFormat(
		SchemaType name,
		SchemaType artist,
		SchemaType reason
		) implements Format {

	public static final SongFormat INSTANCE = new SongFormat(SchemaType.STRING, SchemaType.STRING, SchemaType.STRING);
	
}
