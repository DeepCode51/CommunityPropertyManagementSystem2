package com.so.demosboot.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.so.demosboot.common.config.BaseInfoConfig;

public class FileUploadAndDowload {
	
	@Autowired
	private static BaseInfoConfig baseInfoConfig;
	
	private final static String fileBaseUrl = "H:/project";
	
	private final static String fileUrl = "/upload/2019sharegoods";
	
	/**
	 * 单文件上传到服务路径
	 * @param file
	 * @param request
	 * @return
	 */
	public static String upload(MultipartFile file,HttpServletRequest request){
		String url = "";
		String path =request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
			url = "/upload/"+fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
		
		
	}
	
	/**
	 * 文件上传方法
	 * @param file 上传的文件
	 * @param model 模块文件名
	 * @return
	 */
	public static String upload(MultipartFile file,String model){
		if (!file.isEmpty()) {
			String basePath = fileBaseUrl+fileUrl;
			String fileName = IdGenUtil.getUUID()+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String date = DateUtils.getDate();
			File dest = new File(basePath + "/"+model+"/"+date+"/" + fileName);
			if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
				dest.getParentFile().mkdirs();
			}
			try {
				file.transferTo(dest); //保存文件
				return fileUrl + "/"+model+"/"+date+"/" + fileName;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 文件下载
	 * @param url 文件url
	 * @param request
	 * @param response
	 * @return
	 */
	public static String downLoad(String url, HttpServletRequest request,HttpServletResponse response){
		String backuppath = fileBaseUrl + url;
		response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+backuppath);
        //读取文件  
        try {
			InputStream in = new FileInputStream(backuppath);  
			OutputStream out = response.getOutputStream();  
			//写文件  
			int b;  
			while((b=in.read())!= -1)  
			{  
			    out.write(b);  
			}           
			in.close();  
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
