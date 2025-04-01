package com.web.tech.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component("imageHelper") //@Bean(name="imageHelper")
public class ImageHelper {
   public static final String rootPath="C:\\Users\\LENOVO\\Online-Job-Portal\\Online-Job-Portal\\src\\main\\resources\\static\\profileimg";
   
   public boolean isSaveImage(MultipartFile image) {
	   try {
		  InputStream input=image.getInputStream();
		  byte b[]=new byte[input.available()];
		  input.read(b);
		  FileOutputStream fout=new FileOutputStream(rootPath+"\\"+image.getOriginalFilename());
		  fout.write(b);
		  fout.close();
		  return true;  
	   }
	   catch(Exception ex) {
		   return false;
	   }
   }
}
