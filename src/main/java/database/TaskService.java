package database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import model.Task;

@Stateless
public class TaskService extends CrudAbstractService<Task> {

	public TaskService() {
		super(Task.class);
	}

}
