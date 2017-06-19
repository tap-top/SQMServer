package com.tww.dao;

import com.tww.entity.Notice;

import java.util.List;

/**
 * Created by tww on 2017/5/9.
 */
public interface NoticeDao {
    public void saveNotice(Notice notice);

    public List<Notice> findAllNotice(Integer userID);

    public void removeNotice(Notice notice);

    public void updateNotice(Notice notice);
}
