package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Address;
import com.tww.entity.Notice;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.NoticeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tww on 2017/5/9.
 */
public class NoticeAction extends ActionSupport{
    private Notice notice;
    private NoticeService noticeService;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public NoticeService getNoticeService() {
        return noticeService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String Add() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String userID = request.getParameter("userID");
        String title = request.getParameter("title");
        String info = request.getParameter("info");

        Notice notice1 = new Notice();
        notice1.setUserId(Integer.parseInt(userID));
        notice1.setTitle(title);
        notice1.setInfo(info);
        notice = notice1;
        this.noticeService.save(notice);
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址添加成功");
        singleObject.setObject(notice);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

    public String FindNotice() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String userID = request.getParameter("userID");

        List<Notice> NoticeList = this.noticeService.findAll(Integer.parseInt(userID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址查找成功");
        singleObject.setObject(NoticeList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Delete() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");

        Notice notice1 = new Notice();
        notice1.setId(Integer.parseInt(id));
        this.noticeService.delete(notice1);
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("删除成功");
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

}
