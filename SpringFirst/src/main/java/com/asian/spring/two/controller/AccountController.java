package com.asian.spring.two.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asian.spring.two.entity.Account;
import com.asian.spring.two.entity.TaskJob;
import com.asian.spring.two.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	@Qualifier(AccountService.NAME_SERVICE)
	private AccountService accountService;
	private List<TaskJob> list;
	private List<TaskJob> listResult;
	private Date timeUpdate = new Date(new java.util.Date().getTime());
	
	@RequestMapping("/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		if (list == null){
		list = accountService.list();
		listResult = accountService.list();
		}
		model.addObject("list", list);
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value = "/newTask", method = RequestMethod.GET)
	public ModelAndView newAccount(ModelAndView model) {
		TaskJob task= new TaskJob();
		task.setTimeUpdate(timeUpdate);
		model.addObject("task", task);
		model.setViewName("Task");
		return model;
	}
	
	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute TaskJob task) {
		task.setTimeUpdate(timeUpdate);
		accountService.saveOrUpdate(task,list);		
		copy(listResult, list);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		String idTask = (request.getParameter("idTask"));
		accountService.delete(idTask,list);
		copy(listResult, list);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/sortById")
	public ModelAndView sortById() {
		Collections.sort(this.list, TaskJob.ID_TASK);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/sortByName")
	public ModelAndView sortByName() {
		Collections.sort(this.list, TaskJob.TASK_NAME_COMPARETO);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editTask", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		String idTask = (request.getParameter("idTask"));
		TaskJob task = accountService.getTask(idTask,list);
		ModelAndView model = new ModelAndView("Task");
		task.setTimeUpdate(timeUpdate);
		model.addObject("task", task);
		
		return model;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(HttpServletRequest request,ModelAndView model) {
		String keyword = (request.getParameter("keyword"));
		if (keyword == ""){
			copy(list, listResult);
		}else{
		list = accountService.search(keyword,list);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/saveJob")
	public ModelAndView saveContact(){
		accountService.saveJob(listResult);
		list = null;
		return new ModelAndView("redirect:/");
	}
	
	public void copy(List<TaskJob> list1,List<TaskJob> list2){
		list1.removeAll(list1);
		for (int i = 0;i < list2.size();i++)
			list1.add(list2.get(i));
	}
}
