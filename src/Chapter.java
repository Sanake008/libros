import javax.persistence.*;

@Entity
@Table(name = "Chapter")
public class Chapter 
{
	private String title;
	private Integer chapterNumber;
	
	public Chapter()
	{
		
	}
	public Chapter(String title, Integer chapterNumber)
	{
		this.title = title;
		this.chapterNumber = chapterNumber;
	}
	
	@Id
	@Column(name = "chapter_number")
	public Integer getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	@Column(name = "chapter_title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString()
	{
		return "Title = " + title + " || Chapter Number = " + chapterNumber; 
	}

}
