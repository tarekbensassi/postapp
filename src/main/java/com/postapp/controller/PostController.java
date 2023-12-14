package com.postapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postapp.entity.Post;
import com.postapp.repository.PostRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PostController {

	
	   private final PostRepository postRepository;

	    public PostController(PostRepository postRepository) {
	        this.postRepository = postRepository;
	    }
	    
	    @GetMapping("/posts")
	    public ResponseEntity<?> getAllPosts() {
	        try {
	            Iterable<Post> posts = postRepository.findAll();

	            if (((List<Post>) posts).isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }

	            return new ResponseEntity<>(posts, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred while fetching the posts.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
		Post PostData = postRepository.findById(id).get();

		if (PostData!=null) {
			return new ResponseEntity<>(PostData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post Post) {
		try {
			Post _Post = postRepository
					.save(new Post(Post.getTitle(), Post.getDescription(), false));
			return new ResponseEntity<>(_Post, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post Post) {
		Optional<Post> PostData = postRepository.findById(id);

		if (PostData.isPresent()) {
			Post _Post = PostData.get();
			_Post.setTitle(Post.getTitle());
			_Post.setDescription(Post.getDescription());
			_Post.setPublished(Post.isPublished());
			return new ResponseEntity<>(postRepository.save(_Post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
		try {
			postRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/posts")
	public ResponseEntity<HttpStatus> deleteAllPosts() {
		try {
			postRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/posts/published")
	public ResponseEntity<List<Post>> findByPublished() {
		try {
			List<Post> Posts = postRepository.findByPublished(true);

			if (Posts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Posts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
