package com.emperorbrains.imageupload.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.emperorbrains.imageupload.model.ImageUpload;

@Repository
public interface ImageRepository extends JpaRepository<ImageUpload, Long>{

	@Query("select img from ImageUpload img where img.user_id=?1")
	List<ImageUpload> findByUser_id(int user_id);
}
