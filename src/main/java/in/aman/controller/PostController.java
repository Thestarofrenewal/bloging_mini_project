package in.aman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.aman.binding.PostForm;
import in.aman.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/dashboard")
	public String getDashboardPage(Model model) {

		model.addAttribute("blogs", postService.viewBlogs(new PostForm()));

		return "dashboard";
	}

	@GetMapping("/createBlog")
	public String showCreateBlogForm(Model model) {

		model.addAttribute("blogForm", new PostForm());

		return "createBlog";
	}

	 private Integer getLoggedInUserId() {
	       
	        return 1; 
	    }
	@PostMapping("/createBlog")
	public String createBlog(@ModelAttribute("blogForm") PostForm blogForm, Model model) {
		 Integer loggedInUserId = getLoggedInUserId();

	        // Call postBlog method with the user ID
	        if (postService.postBlog(blogForm, loggedInUserId)) {
	            model.addAttribute("successMessage", "Blog post created successfully!");
	        } else {
	            model.addAttribute("errorMessage", "Failed to create blog post. Please try again.");
	        }
		return "redirect:/dashboard";
	}

}
