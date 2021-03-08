package com.param.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.param.model.User;
import com.param.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String viewHomePage(Model model) 
	{
		model.addAttribute("ListUsers",userService.getAllUsers());
		return "index";
	}
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model)
	{
		User user=new User();
		model.addAttribute("user", user);
		return "new_user";
		
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user")User user) 
	{
		userService.saveUser(user);
		return"redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id")Long id,Model model ) 
	{
		User user=userService.getUserById(id);
		model.addAttribute("user",user);
		return "update_user";
	}
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id")long id)
	{
		this.userService.deleteUserById(id);
		return "redirect:/ ";
		
	}
}
