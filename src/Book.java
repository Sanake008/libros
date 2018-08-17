
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Book")
public class Book 
{
	private String isbn;
	private String name;
	/*private Publisher publisher;
	private List<Chapter> chapters;*/
	
	public Book(){}
	
	public Book(String isbn, String name, Publisher publisher)
	{
		this.isbn = isbn;
		this.name = name;
		//this.publisher = publisher;
	}
	
	/*
	 * queda pendiente de revisar como es que hare todo este show
	 * este sera un cambio que solo se vera en la rama de pruebas
	 * */
	
	@Id
	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "book_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}*/
}
