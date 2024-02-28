package in.aman.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aman.entity.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {

}
