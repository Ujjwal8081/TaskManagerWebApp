package TaskManager.example.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TaskManager.example.TaskManager.DTOs.AddTaskDTO;
import TaskManager.example.TaskManager.DTOs.TaskResponseDTO;
import TaskManager.example.TaskManager.Service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/taskManager")
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping("/addTask")
	public ResponseEntity<TaskResponseDTO> createTask(@RequestBody AddTaskDTO requestDTO) {
		TaskResponseDTO createdTask = taskService.createTask(requestDTO);
		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}

	@GetMapping("/getTaskById/{id}")
	public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable int id) {
		TaskResponseDTO task = taskService.getTaskById(id);
		if (task != null) {
			return new ResponseEntity<>(task, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllTasks")
	public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
		List<TaskResponseDTO> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	@PutMapping("/updateTask/{id}")
	public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable int id, @RequestBody AddTaskDTO requestDTO) {
		TaskResponseDTO updatedTask = taskService.updateTask(id, requestDTO);
		if (updatedTask != null) {
			return new ResponseEntity<>(updatedTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/addTaskNote/{id}")
	public ResponseEntity<TaskResponseDTO> addTaskNote(@PathVariable int id, @RequestBody AddTaskDTO requestDTO){
		TaskResponseDTO addedNote = taskService.addTaskNote(id, requestDTO);
		return new ResponseEntity<>(addedNote, HttpStatus.CREATED);
	}
	

}
