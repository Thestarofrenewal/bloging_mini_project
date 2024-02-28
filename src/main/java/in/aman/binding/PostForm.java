package in.aman.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PostForm {
	
	private String title;
	
	private String description;
	
	private String content;
	
	private LocalDate createdOn;
	
	private LocalDate updatedOn;

}
