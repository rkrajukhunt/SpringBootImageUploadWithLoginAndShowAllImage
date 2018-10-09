package com.emperorbrains.imageupload.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.emperorbrains.imageupload.model.ImageUpload;
import com.emperorbrains.imageupload.service.ImageService;

@Controller
public class FileUploadController {

	@Autowired
	public ImageService imageService;
	
	@RequestMapping(value = "/admin/upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files,@RequestParam("user_id") int user_id) {
		String uploadDirectory = System.getProperty("user.dir")+"/target/classes/static/images";
     	
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
				Files.write(fileNameAndPath, file.getBytes());
				imageService.saveImage(new ImageUpload(user_id,fileNameAndPath.getFileName().toString(),uploadDirectory));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());
		return "redirect:/admin/home";
	}

}
