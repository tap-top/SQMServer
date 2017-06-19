package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Address;
import com.tww.entity.User;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.AddressService;
import com.tww.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tww on 2017/5/4.
 */
public class AddressAction extends ActionSupport {
    private Address address;
    private AddressService addressService;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String Add() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

//        String userID = request.getParameter("userID");
//        String name = request.getParameter("name");
//        String phone = request.getParameter("phone");
//        String tag = request.getParameter("tag");
//        String color = request.getParameter("color");
//        String addressname = request.getParameter("address");
//
//        Address address1 = new Address();
//        address1.setUserId(Integer.parseInt(userID));
//        address1.setName(name);
//        address1.setPhone(phone);
//        address1.setTag(tag);
//        address1.setColor(color);
//        address1.setAddress(addressname);
//        address=address1;

//        address.setUserId(Integer.parseInt(userID));
//        address.setName(name);
//        address.setPhone(phone);
//        address.setTag(tag);
//        address.setColor(color);
//        address.setAddress(addressname);

        String str = request.getParameter("data");
        Address address1 = JackJsonUtils.fromJson(str,Address.class);
        this.addressService.save(address1);
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址添加成功");
        singleObject.setObject(address);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;

    }

    public String FindAddress() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String userID = request.getParameter("userID");

        List<Address> AddressList = this.addressService.findAll(Integer.parseInt(userID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址查找成功");
        singleObject.setObject(AddressList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;

    }
    public String Delete() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");

        Address address1 = new Address();
        address1.setId(Integer.parseInt(id));
        this.addressService.delete(address1);
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("删除成功");
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String UpdateInfo() throws Exception{
        //String a = "{\"userID\":1,\"name\":\"tww\",\"phone\":\"18756037729\",\"tag\":\"先生\",\"color\":\"#81c2ff\",\"address\":\"安徽大学\"}";
//        List<Address> AddressList = this.addressService.findAll(1);
//        String s = JackJsonUtils.toJson(AddressList.get(0));
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("data");
        Address address1 = JackJsonUtils.fromJson(str,Address.class);

        this.addressService.update(address1);
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("更新成功");
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }

}
