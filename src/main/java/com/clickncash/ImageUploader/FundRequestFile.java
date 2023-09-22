package com.clickncash.ImageUploader;

import java.nio.file.*;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FundRequestFile {
	public final String UPLOAD_FILE = "C:\\Users\\admin\\angular\\ClicknCash\\src\\assets\\images\\fundrequest\\paymentProof";

	public String uploadFile(MultipartFile multipartFile, String username) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss.SSS");
		Date date = new Date();
		String format = formatter.format(date);
		String filename = format + "_"+username+ multipartFile.getOriginalFilename();
		String mimeType = multipartFile.getContentType();
		// mimeType should now be something like "image/png"

		if (mimeType.substring(0, 5).equalsIgnoreCase("image") && ((multipartFile.getSize() / (1024 * 1024)) <= 1)
				&& (multipartFile.getSize() != 0)) {
			try {
//				   userRepository.updateUserProfile(filename, email, username, id);
				Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_FILE + "\\" + filename),
						StandardCopyOption.REPLACE_EXISTING);
				return filename;
			} catch (Exception e) {
				e.printStackTrace();
				return "no";
			}
		}
		return "no";
	}

	public int checkFileStatus(MultipartFile file) {
		try {
			String mimeType = file.getContentType();
			if (mimeType.substring(0, 5).equalsIgnoreCase("image") && ((file.getSize() / (1024 * 1024)) <= 1)
					&& (file.getSize() != 0)) {
				return 1;
			}else { return 0; }
		} catch (Exception e) {
			return 5;
		}
	}
}
