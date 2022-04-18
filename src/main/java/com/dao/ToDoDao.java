package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.ToDo;

@Component
public class ToDoDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//Add/ Save ToDo
	@Transactional
	public void save(ToDo t)
	{
		this.hibernateTemplate.saveOrUpdate(t);
	}
	
	// Fetch All ToDo
	public List<ToDo> getAll()
	{
		List<ToDo> todos = this.hibernateTemplate.loadAll(ToDo.class);
		return todos;
	}
	
	//Delete ToDo
	@Transactional
	public void deleteToDo(int toDoId) 
	{
		ToDo todo = this.hibernateTemplate.load(ToDo.class, toDoId);
		this.hibernateTemplate.delete(todo);
	}
	
	//fetch single ToDo
	public ToDo getToDo(int todoId)
	{
		ToDo toDo = this.hibernateTemplate.get(ToDo.class, todoId);
		return toDo;
	}
}
