package com.virtusa.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtusa.model.Post;
import com.virtusa.model.UserDetails;
import com.virtusa.service.PostService;
import com.virtusa.service.UserService;

@Controller
public class AdminController {

	@Autowired private UserService uservice;
	@Autowired private PostService pservice;
	@Autowired private HttpSession session;
	
	@GetMapping("")
	public String home() {
		return "index";
	}
	
	@PostMapping("")
	public String validate(String user_id,String password,RedirectAttributes ra) {
		UserDetails user=uservice.validate(user_id, password);
		if(user==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/";
		}else {
			session.setAttribute("user_namename", user.getUser_name());
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("edit", user.isAllowedit());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("edit/{id}")
	public String edituser(@PathVariable("id") String id,Model model) {
		model.addAttribute("user", uservice.findById(id));
		return "edituser";
	}
	
	@PostMapping("edit/{id}")
	public String updateUser(@PathVariable("id") String id,UserDetails userdetails) {
		UserDetails existuser=uservice.findById(id);
		userdetails.setPassword(existuser.getPassword());
		userdetails.setReportto(existuser.getReportto());
		uservice.saveUserDetails(userdetails);
		return "redirect:/users";
	}
	
	@PostMapping("/posts")
	public String saveReply(int id,String reply) {
		Post post=pservice.findById(id);
		post.setSolution(reply);
		post.setViews("display");
		pservice.savePost(post);
		return "redirect:/posts";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("users", uservice.listall());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerprocess(UserDetails userdetails,RedirectAttributes ra) {
		uservice.saveUserDetails(userdetails);
		return "redirect:/users";
	}
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
