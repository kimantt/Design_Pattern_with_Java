package OOP.f_builder;

public class Run {

	public static void main(String[] args) {
		Book book = new Book.Builder()
				.title("해리포터")
				.author("포터해리")
				.page(300)
				.price(90000)
				.build();
		
		System.out.println(book);
	}

}
