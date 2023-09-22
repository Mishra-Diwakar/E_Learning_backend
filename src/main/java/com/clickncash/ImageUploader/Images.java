package com.clickncash.ImageUploader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.clickncash.entity.User;
import com.clickncash.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@Component
public class Images {
	
	@Autowired
	UserRepository userRepository;
	public final String VIDEO_PATH="C:\\Users\\admin\\angular\\eLearning\\src\\assets\\images";
	public final String COURSE_CARD="C:\\Users\\admin\\angular\\eLearning\\src\\assets\\images\\CourseCard";
	public String uploadCourseBanner(MultipartFile multipartFile) {
		String filename=multipartFile.getOriginalFilename();
		   String mimeType =  multipartFile.getContentType();
		   System.out.println(mimeType);
		   if(mimeType.substring(0,5).equalsIgnoreCase("image") && (multipartFile.getSize()!=0)){
			   try {
				   Files.copy(multipartFile.getInputStream(), Paths.get(COURSE_CARD+"\\"+ filename),StandardCopyOption.REPLACE_EXISTING );
				   return "uploaded";
			   }catch (Exception e) {
				  e.printStackTrace();
				return "error";
			}
		   }else if(!mimeType.substring(0,5).equalsIgnoreCase("image")) {
			   return "not image";
		   }

		   return "not uploaded";
	}
	
	public String uploadFile(MultipartFile multipartFile) {
		String filename=multipartFile.getOriginalFilename();
		   String mimeType =  multipartFile.getContentType();
		   System.out.println(mimeType);
		   if(mimeType.substring(0,5).equalsIgnoreCase("video") && (multipartFile.getSize()!=0)){
			   try {
				   Files.copy(multipartFile.getInputStream(), Paths.get(VIDEO_PATH+"\\"+ filename),StandardCopyOption.REPLACE_EXISTING );
				   return "uploaded";
			   }catch (Exception e) {
				  e.printStackTrace();
				return "error";
			}
		   }else if(mimeType.substring(0,5).equalsIgnoreCase("image") && (multipartFile.getSize()!=0)) {
			   try {
				   Files.copy(multipartFile.getInputStream(), Paths.get(VIDEO_PATH+"\\"+ filename),StandardCopyOption.REPLACE_EXISTING );
				   return "uploaded";
			   }catch (Exception e) {
				  e.printStackTrace();
				return "error";
			}
		   }
		   return "not uploaded";
	}
//	public String uploadVideoBanner(MultipartFile multipartFile) {
//		String filename=multipartFile.getOriginalFilename();
//		   String mimeType =  multipartFile.getContentType();
//		   System.out.println(mimeType);
//		   if(mimeType.substring(0,5).equalsIgnoreCase("image") && (multipartFile.getSize()!=0)){
//			   try {
//				   Files.copy(multipartFile.getInputStream(), Paths.get(VIDEO_PATH+"\\"+ filename),StandardCopyOption.REPLACE_EXISTING );
//				   return "uploaded";
//			   }catch (Exception e) {
//				  e.printStackTrace();
//				return "error";
//			}
//		   }else if(!mimeType.substring(0,5).equalsIgnoreCase("video")) {
//			   return "not video";
//		   }
//
//		   return "not uploaded";
//	}
	public String deleteCourseBanner(String fileName) {
		try {
			String filePath = COURSE_CARD+"\\"+fileName;
			File file = new File(filePath);
			if (file.exists()) {
				if (file.delete()) {
					return "deleted";
				}else {
					return "not deleted";
				}
			}
			return "not found";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}	   
	}
	
	public boolean deleteFile(String fileName) {
		try {
			String filePath = VIDEO_PATH+"\\"+fileName;
			File file = new File(filePath);
			if (file.exists()) {
				if (file.delete()) {	return true;	}
				else { return false; }
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	   
	}
}
