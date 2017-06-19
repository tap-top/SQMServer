package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.User;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends ActionSupport {
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String Login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		User user1 = new User();
		user1.setUsername(username);
		user1.setUserpassword(userpassword);
		user = user1;
		User u = this.userService.loginUser(user);
		SingleObject singleObject = new SingleObject();
		if(u!=null){
			singleObject.setObject(u);
			singleObject.setCode(StatusCode.CODE_SUCCESS);
			singleObject.setMsg("访问成功");
		}else{
			singleObject.setCode(StatusCode.CODE_ERROR);
			singleObject.setMsg("登录error");
		}
		System.out.println(JackJsonUtils.toJson(singleObject));
		ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
		return SUCCESS;
	}
	public String FindByID() throws  Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String userID = request.getParameter("userID");
		User user1 = this.userService.findById(Integer.parseInt(userID));
		SingleObject singleObject = new SingleObject();
		singleObject.setCode(StatusCode.CODE_SUCCESS);
		singleObject.setMsg("修改成功");
		singleObject.setObject(user1);
		System.out.println(JackJsonUtils.toJson(singleObject));
		ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
		return SUCCESS;
	}
	public String Add() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String phoneNum = request.getParameter("phoneNum");
		if(username.equals("") || userpassword.equals("")){
			SingleObject singleObject = new SingleObject();
			singleObject.setCode(StatusCode.CODE_ERROR);
			singleObject.setMsg("帐户名和密码不能为空");
			System.out.println(JackJsonUtils.toJson(singleObject));
			ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
			return SUCCESS;
		}
		else {
			User user1 = new User();
			user1.setUsername(username);
			user1.setUserpassword(userpassword);
			user1.setPhonenum(phoneNum);
			user = user1;
			this.userService.save(user);
			SingleObject singleObject = new SingleObject();
			singleObject.setCode(StatusCode.CODE_SUCCESS);
			singleObject.setMsg("注册成功");
			singleObject.setObject(user);
			System.out.println(JackJsonUtils.toJson(singleObject));
			ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
			return SUCCESS;
		}

	}

	public String UpdateInfo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String userpassword = request.getParameter("password");
		String phoneNum = request.getParameter("phoneNum");
		String headImg = request.getParameter("headImg");

		User user1 = new User();
		user1.setUserid(Integer.parseInt(userID));
		user1.setUsername(username);
		user1.setUserpassword(userpassword);
		user1.setPhonenum(phoneNum);
		user1.setHeadimg(headImg);
		user = user1;
		this.userService.update(user);
		SingleObject singleObject = new SingleObject();
		singleObject.setCode(StatusCode.CODE_SUCCESS);
		singleObject.setMsg("修改成功");
		System.out.println(JackJsonUtils.toJson(singleObject));
		ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
		return SUCCESS;
	}
}