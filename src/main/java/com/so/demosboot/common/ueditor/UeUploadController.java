package com.so.demosboot.common.ueditor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by DEMOCXY on 2018-01-09.
 */
@RestController
@RequestMapping(value = "/ueUploadController")
public class UeUploadController {

	private String baseUrl ="H:/project";// 拿到配置文件配置的路径

	/**
	 * 获取json字符串 代替jsp文件配置
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ueditor")
    public String ueditor(HttpServletRequest request) {

        return PublicMsg.UEDITOR_CONFIG;
    }
	
	/**
	 * 跳转到测试案例页面
	 * @param items
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index")
	public String ue( Model model) {
		return "index";
	}
	
	/**
	 * 自定义文件上传方法
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload")
	public Map<String, Object> upPic(@RequestParam(value = "upfile", required = false) MultipartFile pic,
			String type,HttpServletRequest request, HttpServletResponse response) throws IOException {
		String saveUrl = "/upload/2019sharegoods";//文件保存路径前缀 必须包含upload
		if (type!=null && type !="") {
			if (type.startsWith("image")) {
				saveUrl += "/image/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
			}else if (type.startsWith("video")) {
				saveUrl += "/video/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
			}else{
				saveUrl += "/file/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
			}
		} else {
			saveUrl += "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
		}
		JSONObject json = new JSONObject();
		try {
			String fileName = pic.getOriginalFilename();
			String oldName = fileName;
			String fileType = fileName.substring(fileName.indexOf(".") + 1);
			// 生成随机字符串名，防止出现中文乱码的情况
			fileName = getRandomString(15) + "." + fileType;
			File dest = new File(baseUrl + saveUrl + "/" + fileName);
			if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
				dest.getParentFile().mkdirs();
			}
			pic.transferTo(dest); // 保存文件
			//按照相应的json数据格式返回结果
			json.put("state", "SUCCESS");
			json.put("title", oldName);
			json.put("url", saveUrl + fileName);// 图片访问 相对路径
			json.put("original", pic.getName());
		} catch (Exception e) {
			json.put("state", "ERROR");
			e.printStackTrace();
		}
		//System.out.println(json.toString());
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	/**
	 * @Title: getRandomString
	 * @Description: 随机生成字符串
	 * @param @param
	 *            length 字符串长度
	 * @return String
	 * @date createTime：2018年4月9日下午1:45:52
	 */
	public static String getRandomString(int length) {
		// 产生随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 循环length次
		for (int i = 0; i < length; i++) {
			// 产生0-2个随机数，既与a-z，A-Z，0-9三种可能
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			// 如果number产生的是数字0；
			case 0:
				// 产生A-Z的ASCII码
				result = Math.round(Math.random() * 25 + 65);
				// 将ASCII码转换成字符
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				// 产生a-z的ASCII码
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				// 产生0-9的数字
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}
		}
		return sb.toString();
	}

	
}
