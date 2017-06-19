package com.tww.service;

import com.tww.entity.Notice;

import java.util.List;

/**
 * Created by tww on 2017/5/9.
 */
public interface NoticeService {
    public void save(Notice notice);

    public List<Notice> findAll(Integer userID);

    public void delete(Notice notice);

    public void update(Notice notice);
}
