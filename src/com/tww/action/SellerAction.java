package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Seller;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.SellerService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tww on 2017/5/15.
 */
public class SellerAction extends ActionSupport {
    private Seller seller;
    private SellerService sellerService;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public SellerService getSellerService() {
        return sellerService;
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;

    }

    public String Add() throws  Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String str = request.getParameter("data");
        Seller seller1 = JackJsonUtils.fromJson(str,Seller.class);
        this.sellerService.save(seller1);

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("注册成功");
        singleObject.setObject(seller1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Update() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("data");
        Seller seller1 = JackJsonUtils.fromJson(str,Seller.class);
        this.sellerService.update(seller1);

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("注册成功");
        singleObject.setObject(seller1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

    public String FindAll() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        List<Seller> seller1=this.sellerService.findAll();

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("查找成功");
        singleObject.setObject(seller1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindSellerById() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String sellerId = request.getParameter("sellerId");
        Seller seller1=this.sellerService.findSellerById(Integer.parseInt(sellerId));

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("查找成功");
        singleObject.setObject(seller1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

    public String Login() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String sellerName = request.getParameter("sellerName");
        String sellerPassword = request.getParameter("sellerPassword");
        Seller seller1 = new Seller();
        seller1.setSellerName(sellerName);
        seller1.setSellerPassword(sellerPassword);
        Seller u = this.sellerService.loginSeller(seller1);
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
}
