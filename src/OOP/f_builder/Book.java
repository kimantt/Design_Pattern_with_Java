package OOP.f_builder;

public class Book {

	private String title;
	private String author;
	private int page;
	private int price;
	
	private Book(Builder builder) {
		title = builder.title;
		author = builder.author;
		page = builder.page;
		price = builder.price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", page=" + page + ", price=" + price + "]";
	}

	public static class Builder {
		private String title;
		private String author;
		private int page;
		private int price;
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder page(int page) {
			this.page = page;
			return this;
		}
		
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}
	
	// JavaBeans Pattern
	// 1. 기본생성자로 인스턴스 생성 + setter로 초기화
	// 가독성이 좋음
	// ex) Book book = new Book(); book.setAuthor("포터해리");
	// immutable 객체를 생성할 수 없음
	
	// 점층적 생성자 패턴
	// 2. 매개변수가 있는 생성자를 사용해서 인스턴스화와 동시에 초기화
	// 가독성이 좋지 않음 ex) new Book("해리포터", "포터해리" 9999, 9000);
	// immutable 객체를 생성할 수 있다
	
	// Builder 패턴
	// 가독성이 좋고 immutable 객체도 만들 수 있다
}
