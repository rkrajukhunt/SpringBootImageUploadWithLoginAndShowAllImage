package com.emperorbrains.imageupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emperorbrains.imageupload.model.ImageUpload;
import com.emperorbrains.imageupload.repository.ImageRepository;
import com.emperorbrains.imageupload.repository.RoleRepository;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	public void saveImage(ImageUpload imageUpload) {
		imageRepository.save(imageUpload);
	}
	
	public List<ImageUpload> findById(int user_id) {
		return imageRepository.findByUser_id(user_id);
	}
}
