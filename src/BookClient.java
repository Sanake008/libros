import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import antlr.CppCodeGenerator;


public class BookClient {

	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		InsertInDataBase(EnterRegistrys());
	}
	
	private static void InsertInDataBase(List<Object> elements)
	{
		Session session = HibernateUtil.getsFactory().openSession();
		
		for (Object object : elements) 
		{
			session.beginTransaction();
			if(object instanceof Book)
			{
				Book book = (Book)object;
				session.save(book);
				session.getTransaction().commit();
			}
			else if(object instanceof Chapter)
			{
				Chapter chapter = (Chapter) object;
				session.save(chapter);
				session.getTransaction().commit();
			}
			else if(object instanceof Publisher)
			{
				Publisher publisher = (Publisher)object;
				session.save(publisher);
				session.getTransaction().commit();
			}
		}
		
		session.close();
	}
	
	private static List<Object> EnterRegistrys()
	{
		List<Object> registrys = new ArrayList<Object>();
		
		while(!sc.next().equals("insert"))
		{
			System.out.println("Welcome to the system please enter the regystris");
		
			Book book;
			
			System.out.println("Enter the isbn's book: ");
			String isbn_book = sc.next();
			
			System.out.println("Enter Book name: ");
			String book_name = sc.next();
			
			System.out.println("Data Publisher: ");
			
			System.out.println("Publisher code: ");
			String publisher_code = sc.next();
			
			System.out.println("Publisher name: ");
			String publisher_name = sc.next();
			
			Publisher publisher = new Publisher(publisher_code, publisher_name);
				
			book = new Book(isbn_book, book_name, publisher);
			
			System.out.println("Number of chapters");
			int chapters = sc.nextInt();
			int cont = 0;
			List<Object> chaptersList = new ArrayList<Object>();
			while(cont < chapters)
			{
				System.out.println("Enter the title: ");
				String chapter_title = sc.next();
				
				System.out.println("Enter the chapter number: ");
				Integer chapter_number = sc.nextInt();
				
				Chapter chapter = new Chapter(chapter_title, chapter_number);
				//book.getChapters().add(chapter);
				chaptersList.add(chapter);
				cont++;
			}
			registrys.add(book);
			registrys.add(publisher);
			for (Object object : chaptersList) 
			{
				registrys.add(object);
			}
			//chaptersList.forEach(item->registrys.add(item));
		}
		return registrys;
	}

}
