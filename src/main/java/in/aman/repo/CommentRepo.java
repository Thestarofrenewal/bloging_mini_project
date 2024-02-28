package in.aman.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aman.entity.CommentEntity;

public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {

}
