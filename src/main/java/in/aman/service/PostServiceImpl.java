package in.aman.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aman.binding.PostForm;
import in.aman.entity.PostEntity;
import in.aman.entity.UserEntity;
import in.aman.repo.PostRepo;
import in.aman.repo.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	 public boolean postBlog(PostForm form, Integer userId) {
        try {
            PostEntity entity = new PostEntity();
            BeanUtils.copyProperties(form, entity);

            // Check if the user ID is valid
            if (userId != null) {
                // Fetch the user from the database using the ID
                UserEntity userEntity = userRepo.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

                // Set the user for the blog post
                entity.setUser(userEntity);

                // Save the blog post
                postRepo.save(entity);

                return true;
            } else {
                // Handle the case where the user ID is not valid
                return false;
            }
        } catch (Exception e) {
            // Handle exceptions, log them, and return false or rethrow if necessary.
            e.printStackTrace();
            return false;
        }
    }

	
	@Override
	public List<PostEntity> viewBlogs(PostForm form) {
		
		List<PostEntity> list = postRepo.findAll();
		
		return list;
	}

}
