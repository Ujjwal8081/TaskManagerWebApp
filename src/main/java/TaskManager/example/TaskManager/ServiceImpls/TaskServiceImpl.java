package TaskManager.example.TaskManager.ServiceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import TaskManager.example.TaskManager.DTOs.AddTaskDTO;
import TaskManager.example.TaskManager.DTOs.TaskResponseDTO;
import TaskManager.example.TaskManager.Service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {
	
	 private List<TaskResponseDTO> tasks = new ArrayList<>();
	
	 private int nextId = 1;

	    @Override
	    public TaskResponseDTO createTask(AddTaskDTO requestDTO) {
	    	TaskResponseDTO task = new TaskResponseDTO();
	        task.setId(nextId++); // Generate a unique ID
	        task.setTitle(requestDTO.getTitle());
	        task.setDescription(requestDTO.getDescription());
	        task.setCreatedAt(requestDTO.getCreatedAt());
	        task.setCompleted(requestDTO.isCompleted());
	        task.setTaskNote("NA");
	        tasks.add(task); // Add task to the list

	        return task;
	    }

	    @Override
	    public TaskResponseDTO updateTask(int id, AddTaskDTO requestDTO) {
	        for (TaskResponseDTO task : tasks) {
	            if (task.getId() == id) {
	                task.setTitle(requestDTO.getTitle());
	                task.setDescription(requestDTO.getDescription());
	                task.setCreatedAt(requestDTO.getCreatedAt());
	                task.setCompleted(requestDTO.isCompleted());
	                
	                return task;
	            }
	        }
	        return null; // Return null if task with given ID is not found
	    }

	    @Override
	    public TaskResponseDTO getTaskById(int id) {
	        for (TaskResponseDTO task : tasks) {
	            if (task.getId() == id) {
	                return task;
	            }
	        }
	        return null; // Return null if task with given ID is not found
	    }

	    @Override
	    public List<TaskResponseDTO> getAllTasks() {
	        return tasks;
	    }

	    @Override
	    public void deleteTask(int id) {
	        tasks.removeIf(task -> task.getId() == id);
	    }
	    @Override
	    public TaskResponseDTO addTaskNote(int id, AddTaskDTO requestDTO) {
	    	 for (TaskResponseDTO task : tasks) {
		            if (task.getId() == id) {
		            	task.setTaskNote(requestDTO.getTaskNote());
		            	tasks.add(task);
		            	return task;
		            }
	    	 }
	    	 return null;	 
	    }

}
