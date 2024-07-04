package TaskManager.example.TaskManager.DTOs;

import java.util.ArrayList;
import java.util.Date;

public class TaskResponseDTO {
	   private int id;
	    private String title;
	    private String description;
	    private Date createdAt;
	    private boolean completed;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public boolean isCompleted() {
			return completed;
		}
		public void setCompleted(boolean completed) {
			this.completed = completed;
		}
	    
	
}
