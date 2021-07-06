package com.example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.UserDao;
import com.example.models.User;


@Controller
public class MainController {
	
	
	@Autowired
	UserDao userDao;

	@GetMapping(value = "/" )
	public String sayHello() {
		return "login";	
	}
	
	@PostMapping(value="/addUser")
	public String addUser(HttpSession session,HttpServletRequest request,User user) {
		User userDetail=new User();
		userDetail.setUsername(request.getParameter("username"));
		userDetail.setPassword(request.getParameter("password"));
		System.out.println("calling"+userDetail);
		
		String details = userDao.addUserDetails(userDetail);
		
		System.out.println(details);
		return "login ";
	}
	
	
	@RequestMapping(value="/fileform")  
    public String showUploadForm() {
		return "fileform";
		
	}
	
	@RequestMapping(value="/uploadimage", method=RequestMethod.POST)
	public String fileupload(@RequestParam("profile") CommonsMultipartFile file, HttpSession session , Model model)  {
		System.out.println("file upload handler");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		// to get the data of file and stored in byte arrays
		byte[] data = file.getBytes();
		
//		we have to save file to the server
		String path = session.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"images"+File.separator+file.getOriginalFilename();
		System.out.println(path);
//		we can write this file data using FileOutputStream
			try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			// you will get original path of upload file C:\Users\DELL\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC\billing.png
			// till get real path
			// C:\Users\DELL\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC\WEB-INF\images\live.png

			System.out.println("file uploaded");  
//			after uploading send file to the server we will use model in method to carry our data
			model.addAttribute("message", "uploaded successfully");
			model.addAttribute("filename",file.getOriginalFilename());
						
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("uploading error");
			model.addAttribute("Error", "Something went wrong");
		}
		
		return "filesuccess";
	}
	
	
}	
	
	
	