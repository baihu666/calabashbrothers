package com.company.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @author rjw
 * @category 上传照片类
 *
 */
public class UploadImag{
	/**
	 * @category 上传照片方法
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	protected static String headUpload(ServletConfig config, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String site = null;
		String path = null;
		//1、创建SmartUpload对象
		SmartUpload su = new SmartUpload();
		//2、对su进行初始化
		su.initialize(config, request, response);
		//3、设置上传文件的大小
		su.setMaxFileSize(1024*1024*10);
		//4、设置允许上传文件的类型
		su.setAllowedFilesList("jpg,png");
		try {
			System.out.println(11);
			//5、文件上传
			su.upload();
			//6、得到文件对象
			 
			File file = su.getFiles().getFile(0);
			//7、得到文件上传后的位置
			String[] strs = getSite(request, file);
			site = strs[0];
			//8、文件保存
			file.saveAs(site);
			//9、返回图像的映射地址位置
			path = strs[1];
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	/**
	 * 得到文件路径
	 * @param file
	 * 文件
	 * @return 文件路径
	 */
	private static String[] getSite( HttpServletRequest request,File file){
		String ext = file.getFileExt();
		String fileName = new SimpleDateFormat("yyyyMMDDHHmmssSSS").format(new Date())+"."+ext;
		String name = "E:/img/"+fileName;//这块E:/img/路径是在tomcat中设置好的
		String path = "/img/"+fileName;//这个在Tomcat中已经设置好懒
		String[] strs = {name,path};
		return strs;
	}
}
