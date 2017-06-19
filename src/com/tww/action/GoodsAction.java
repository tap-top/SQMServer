package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Goods;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.GoodsService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by tww on 2017/5/22.
 */
public class GoodsAction extends ActionSupport {
    private Goods goods;
    private GoodsService goodsService;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String Add() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String str = request.getParameter("data");
        Goods goods1 = JackJsonUtils.fromJson(str,Goods.class);
        this.goodsService.save(goods1);
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址添加成功");
        singleObject.setObject(goods1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Delete() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String goodsId = request.getParameter("goodsId");
        Goods goods1 = new Goods();
        goods1.setId(Integer.parseInt(goodsId));
        this.goodsService.delete(goods1);
        String sellerID = request.getParameter("sellerId");
        List<Goods> goodsList = this.goodsService.findAll(Integer.parseInt(sellerID));
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("地址添加成功");
        singleObject.setObject(goodsList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String Update() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String str = request.getParameter("data");
        Goods goods1 = JackJsonUtils.fromJson(str,Goods.class);
        this.goodsService.update(goods1);
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_ERROR);
        singleObject.setMsg("地址添加成功");
        singleObject.setObject(goods1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindAll() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String sellerID = request.getParameter("sellerID");

        List<Goods> goodsList = this.goodsService.findAll(Integer.parseInt(sellerID));
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("商品查找成功");
        singleObject.setObject(goodsList);

        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String ZanUpdate() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String goodsID = request.getParameter("goodsID");
        String zan = request.getParameter("zan");

        Goods goods1 = this.goodsService.findById(Integer.parseInt(goodsID));
        int praise = goods1.getPraise();
        praise = praise + Integer.parseInt(zan);
        if(praise>0){
            praise=0;
        }
        goods1.setPraise(praise);
        this.goodsService.update(goods1);

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("商品查找成功");
        singleObject.setObject(goods1);

        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String SelledUpdate() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String goodsID = request.getParameter("goodsID");
        String salelength = request.getParameter("sale");

        Goods goods1 = this.goodsService.findById(Integer.parseInt(goodsID));
        String sale = goods1.getSale();
        int sale1 = Integer.parseInt(sale);
        sale1 = sale1 + Integer.parseInt(salelength);
        goods1.setSale(sale1+"");
        this.goodsService.update(goods1);

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("商品查找成功");
        singleObject.setObject(goods1);

        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
}
