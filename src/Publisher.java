import javax.persistence.*;

@Entity
@Table(name = "Publisher")
public class Publisher 
{
	private String code;
	private String name;
	
	public Publisher()
	{
	}
	
	public Publisher(String code, String name)
	{
		this.code = code;
		this.name = name;
	}

	@Id
	@Column(name = "publisher_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "publisher_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
