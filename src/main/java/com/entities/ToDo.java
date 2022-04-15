package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int todoId;
	private String toDoTitle;
	private String toDoDesc;
	private Date todoDate;
	public ToDo(String toDoTitle, String toDoDesc, Date todoDate) {
		super();
		this.toDoTitle = toDoTitle;
		this.toDoDesc = toDoDesc;
		this.todoDate = todoDate;
	}
	
	public ToDo() {
		super();
	}

	public String getToDoTitle() {
		return toDoTitle;
	}
	public void setToDoTitle(String toDoTitle) {
		this.toDoTitle = toDoTitle;
	}
	public String getToDoDesc() {
		return toDoDesc;
	}
	public void setToDoDesc(String toDoDesc) {
		this.toDoDesc = toDoDesc;
	}
	public Date getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	@Override
	public String toString() {
		return this.getToDoTitle() + ": " + this.getToDoDesc();
	}
	
	
}