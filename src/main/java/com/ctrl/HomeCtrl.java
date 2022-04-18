package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ToDoDao;
import com.entities.ToDo;

@Controller
public class HomeCtrl {

	@Autowired
	ServletContext context;
	
	@Autowired
	ToDoDao todoDao;
	
	//  Home
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("page", "home");
		List<ToDo> list = this.todoDao.getAll();
		model.addAttribute("todos", list);
		return "home";
	}
	
	// Add ToDo
	@RequestMapping("/add")
	public String addTODO(Model model) {
		ToDo t = new ToDo();
		model.addAttribute("page", "add");
		model.addAttribute("todo", t);
		return "home";
	}
	
	//  Save ToDo
	@RequestMapping(value="/saveToDo", method=RequestMethod.POST)
	public RedirectView saveToDo(@ModelAttribute("todo")ToDo t, Model model, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		t.setTodoDate(new Date());
		this.todoDao.save(t);
		
		model.addAttribute("msg", "Successfully added");
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	
	@RequestMapping("/deleteToDo/{todoId}")
	public RedirectView deleteToDo(@PathVariable("todoId") int todoId, HttpServletRequest request)
	{
		this.todoDao.deleteToDo(todoId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	
	@RequestMapping("/editToDo/{todoId}")
	public String editToDo(@PathVariable("todoId") int todoId, Model model)
	{
		ToDo toDo = this.todoDao.getToDo(todoId);
		model.addAttribute("page", "update");
		model.addAttribute("toDo" ,toDo);
		return "home";
	}
}