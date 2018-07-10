package com.ljw.spring.mybits.controller.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	@RequestMapping("/load")
	public String openLoadView(){
		System.out.println("load1111111111111111");
		return "file/uploadFile";
	}
	
	
	
	@RequestMapping("/upload")
	public String uploadFile(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, ModelMap model){
		
		
		System.out.println("load222222"+1111111);
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		try {
			file.transferTo(targetFile);
			model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileInputStream is = new FileInputStream(targetFile);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			StringBuilder sb = new StringBuilder();
			String buffer =br.readLine();
			while(buffer!=null){
				sb.append(buffer);
				buffer =br.readLine();
			}
			System.out.println(sb.toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "file/result";
		
	}
	
}
