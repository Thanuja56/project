package com.virtusa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.model.Post;
import com.virtusa.model.UserDetails;
import com.virtusa.repository.PostRepository;

@Service
public class PostService {

	@Autowired private PostRepository repo;
	
	public void savePost(Post post) {
		post.setHandleby(post.getCreatedby().getReportto());
		repo.save(post);
	}
	
	public void repostPost(int id,String subject,String reason) {
		Post post=findById(id);
		post.setViews("Repost");
		savePost(post);
		
		Post pt=new Post();
		pt.setCreatedby(post.getCreatedby());
		pt.setSubject(subject);
		pt.setDescription(reason);
		pt.setParentid(post);
		savePost(pt);
	}
	
	public List<Post> allposts(){
		return repo.findAll();
	}
	
	public List<Post> userPosts(UserDetails userdetails){
		return repo.findByCreatedby(userdetails);
	}
	
	public void deletePost(int id) {
		repo.delete(repo.getById(id));
	}
	
	public List<Post> handlerPosts(UserDetails userdetails){
		return repo.findByHandleby(userdetails);
	}
	
	public Post findById(int id) {
		return repo.getById(id);
	}
}

