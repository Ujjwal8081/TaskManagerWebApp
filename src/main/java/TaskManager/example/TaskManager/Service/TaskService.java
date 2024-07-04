package TaskManager.example.TaskManager.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import TaskManager.example.TaskManager.DTOs.AddTaskDTO;
import TaskManager.example.TaskManager.DTOs.TaskResponseDTO;

@Service
public interface TaskService {
	 TaskResponseDTO createTask(AddTaskDTO requestDTO);

	    TaskResponseDTO updateTask(int id, AddTaskDTO requestDTO);

	    TaskResponseDTO getTaskById(int id);

	    List<TaskResponseDTO> getAllTasks();

	    void deleteTask(int id);
}
