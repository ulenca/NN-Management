package beans;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import database.TaskService;
import model.Task;

@Named
@ViewScoped
public class TaskBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject TaskService taskService;
	
	@PostConstruct
	private void init() {
		tasks = taskService.findAll();
	}
	
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
