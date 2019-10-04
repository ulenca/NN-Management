package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ordered_by", referencedColumnName = "id")
	private TeamMember orderedBy;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Enumerated(EnumType.STRING)
	@Column(name="priority")
	private TaskPriority priority;
	
	@Column(name="description")
	private String description;
	
	@Column(name="notes")
	private String notes;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private TaskStatus status;
		
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name="task_assigned_members", 
			joinColumns= {@JoinColumn(name="task_id")}, 
			inverseJoinColumns= {@JoinColumn(name="team_member_id")}
			)
	private Set<TeamMember> assignedMembers = new HashSet<TeamMember>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderedBy() {
		return orderedBy.toString();
	}

	public void setOrderedBy(TeamMember orderedBy) {
		this.orderedBy = orderedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssignedMembers() {
		StringJoiner joiner = new StringJoiner(",");
		for (TeamMember e:assignedMembers) {
			joiner.add(e.toString());
		}
		return joiner.toString();
	}

	public void setAssignedMembers(Set<TeamMember> assignedMembers) {
		this.assignedMembers = assignedMembers;
	}

	
}
