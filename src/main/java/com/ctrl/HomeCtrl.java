package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ToDoDao;
import com.entities.ToDo;

@Controller
public class HomeCtrl {

	@Autowired
	ServletContext context;
	
	@Autowired
	ToDoDao todoDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("page", "home");
		List<ToDo> list = this.todoDao.getAll();
		model.addAttribute("todos", list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTODO(Model model) {
		ToDo t = new ToDo();
		model.addAttribute("page", "add");
		model.addAttribute("todo", t);
		return "home";
	}
	
	@RequestMapping(value="/saveToDo", method=RequestMethod.POST)
	public String saveToDo(@ModelAttribute("todo")ToDo t, Model model) {
		System.out.println(t);
		t.setTodoDate(new Date());
		this.todoDao.save(t);
		
		model.addAttribute("msg", "Successfully added");
		return "home";
	}
}