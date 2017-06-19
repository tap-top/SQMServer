package com.tww.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tww.entity.Address;
import com.tww.entity.Comment;
import com.tww.entity.Seller;
import com.tww.json.JackJsonUtils;
import com.tww.json.ResponseUtils;
import com.tww.json.SingleObject;
import com.tww.json.StatusCode;
import com.tww.service.CommentService;
import com.tww.service.SellerService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tww on 2017/5/27.
 */
public class CommentAction extends ActionSupport {
    private Comment comment;
    private CommentService commentService;
    private SellerService sellerService;

    public SellerService getSellerService() {
        return sellerService;
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String Add() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String str = request.getParameter("data");
        Comment comment1 = JackJsonUtils.fromJson(str,Comment.class);
        this.commentService.save(comment1);
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("评论添加成功");
        singleObject.setObject(comment1);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));


        List<Comment> commentList=this.commentService.FindCommentBySellerID(comment1.getSellerId());
        //添加json数据集
        float allstar=0;
        for(int i = 0; i<commentList.size();i++){
            allstar+=commentList.get(i).getSellerStar();
        }
        allstar = allstar/commentList.size();

        Seller seller = this.sellerService.findSellerById(comment1.getSellerId());
        seller.setStars(allstar+"");
        this.sellerService.update(seller);
        return SUCCESS;
    }
    public String FindCommentBySellerID() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String sellerID = request.getParameter("sellerID");
        List<Comment> commentList=this.commentService.FindCommentBySellerID(Integer.parseInt(sellerID));
        //添加json数据集
        float allstar=0;
        for(int i = 0; i<commentList.size();i++){
            allstar+=commentList.get(i).getSellerStar();
        }
        allstar = allstar/commentList.size();
        System.out.println(allstar);

        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg(allstar+"");
        singleObject.setObject(commentList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
    public String FindCommentByUserID() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String userID = request.getParameter("userID");
        List<Comment> commentList=this.commentService.FindCommentBuUserID(Integer.parseInt(userID));
        //添加json数据集
        SingleObject singleObject = new SingleObject();
        singleObject.setCode(StatusCode.CODE_SUCCESS);
        singleObject.setMsg("评论添加成功");
        singleObject.setObject(commentList);
        System.out.println(JackJsonUtils.toJson(singleObject));
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
        return SUCCESS;
    }
}
