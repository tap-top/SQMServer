package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Orderinfo;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.OrderService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tww on 2017/5/7.
 */
public class OrderAction extends ActionSupport {
    private Orderinfo orderinfo;
    private OrderService orderService;

    public Orderinfo getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(Orderinfo orderinfo) {
        this.orderinfo = orderinfo;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String Add() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("data");
        Orderinfo orderinfo = JackJsonUtils.fromJson(str,Orderinfo.class);
        this.orderService.save(orderinfo);
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("订单添加成功");
        singleObject.setObject(orderinfo);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Update() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");
        String state = request.getParameter("state");
        String assessed = request.getParameter("comment");

        Orderinfo orderList = this.orderService.findByID(Integer.parseInt(id));
        orderList.setState(state);
        orderList.setAssessed(assessed);
        this.orderService.update(orderList);
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("订单更新成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Delete() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");
        Orderinfo order1 = new Orderinfo();
        order1.setId(Integer.parseInt(id));
        this.orderService.delete(order1);

        String userID = request.getParameter("userID");
        List<Orderinfo> orderList = this.orderService.findAll(Integer.parseInt(userID));

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("订单更新成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

    public String FindOrderByUserID() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String userID = request.getParameter("userID");

        List<Orderinfo> orderList = this.orderService.findAll(Integer.parseInt(userID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("订单查找成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindOrderBySellerID() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String sellerID = request.getParameter("sellerID");

        List<Orderinfo> orderList = this.orderService.findAllOrderBySellerID(Integer.parseInt(sellerID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("订单查找成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindOrderByID() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String OrderID = request.getParameter("OrderID");

        Orderinfo orderList = this.orderService.findByID(Integer.parseInt(OrderID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("订单查找成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindOrderByIsAssessed() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String userID = request.getParameter("userID");
        List<Orderinfo>  orderList = this.orderService.findOrderByIsAssessed(Integer.parseInt(userID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("待评论订单成功");
        singleObject.setObject(orderList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
}
