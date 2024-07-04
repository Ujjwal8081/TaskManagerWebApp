package TaskManager.example.TaskManager.DTOs;

import java.util.Date;

public class AddTaskDTO {
    private String title;
    private String description;
    private Date createdAt;
    private boolean completed;
    
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddTaskDTO [title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", completed=");
		builder.append(completed);
		builder.append("]");
		return builder.toString();
	}
	
    
	
	

}
