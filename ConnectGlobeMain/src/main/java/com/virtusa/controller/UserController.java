package com.virtusa.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtusa.service.PostService;
import com.virtusa.model.Post;

import com.virtusa.service.UserService;

@Controller
public class UserController {

	
	@Autowired private UserService uservice;
	@Autowired private PostService pservice;
	@Autowired private HttpSession session;
	
	@GetMapping("/action")
	public String addpost(Model model) {
		String user_id=session.getAttribute("use_rid").toString();
		model.addAttribute("list", pservice.userPosts(uservice.findById(user_id)));
		return "action";
	}
	
	@PostMapping("/repost")
	public String repostPost(int id,String subject,String reason) {
		pservice.repostPost(id,subject,reason);
		return "redirect:/action";
	}
	
	@PostMapping("/action")
	public String savePost(Post post,RedirectAttributes ra) {
		pservice.savePost(post);
		ra.addFlashAttribute("msg", "Post done successfully");
		return "redirect:/action";
	}
	
	@GetMapping("/delpost/{id}")
	public String deletepost(@PathVariable("id")int id) {
		pservice.deletePost(id);
		return "redirect:/action";
	}
}
