package in.aman.service;

import java.util.List;

import in.aman.binding.PostForm;
import in.aman.entity.PostEntity;

public interface PostService {
	

	public boolean postBlog(PostForm form, Integer userId);
	
	public List<PostEntity> viewBlogs(PostForm form);

}
