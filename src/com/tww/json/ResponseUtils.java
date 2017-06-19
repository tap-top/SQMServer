package com.tww.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse帮助类
 */
public class ResponseUtils {
	
	/**
	 * 发送文本。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	public static void renderJson(HttpServletResponse response, String text) {
		// System.out.print(text);
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	/**
	 * 发送内容。使用UTF-8编码。
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		//浏览器跨域问题
		response.setHeader("Access-Control-Allow-Origin","*");
		try {
			PrintWriter out = response.getWriter();
			out.write(text);
			out.flush();
			out.close();
		} catch (IOException e) {
		}
	}
	
	
	/**
	 * @Title: outputJson
	 * @Description: TODO(页面异步回调返回Json)
	 */
	public static void outputJson(HttpServletResponse response, Object obj) {
		String s = JsonWriter.toJson(obj, false);
		response.setContentType("text/plain;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		//浏览器跨域问题
		response.setHeader("Access-Control-Allow-Origin","*");

		try {
//			response.getWriter().print(s);
			PrintWriter out = response.getWriter();
			out.write(s);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
