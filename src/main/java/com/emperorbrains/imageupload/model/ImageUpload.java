package com.emperorbrains.imageupload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "image_upload	")
public class ImageUpload {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Nullable private int user_id;
	@Nullable private String fileName;
	@Nullable private String basePath;
	/**
	 * @param id
	 * @param user_id
	 * @param fileName
	 * @param basePath
	 */
	public ImageUpload(Long id, int user_id, String fileName, String basePath) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.fileName = fileName;
		this.basePath = basePath;
	}
	
	public ImageUpload(int user_id, String fileName, String basePath) {
		super();
		this.user_id = user_id;
		this.fileName = fileName;
		this.basePath = basePath;
	}
	
	public ImageUpload() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	
}
