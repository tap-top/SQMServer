package com.tww.service.impl;

import com.tww.dao.NoticeDao;
import com.tww.entity.Notice;
import com.tww.service.NoticeService;

import java.util.List;

/**
 * Created by tww on 2017/5/9.
 */
public class NoticeServiceImpl implements NoticeService {
    private NoticeDao noticeDao;

    public NoticeDao getNoticeDao() {
        return noticeDao;
    }

    public void setNoticeDao(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public void save(Notice notice) {
        this.noticeDao.saveNotice(notice);
    }

    @Override
    public List<Notice> findAll(Integer userID) {
        return this.noticeDao.findAllNotice(userID);
    }

    @Override
    public void delete(Notice notice) {
        this.noticeDao.removeNotice(notice);
    }

    @Override
    public void update(Notice notice) {
        this.noticeDao.updateNotice(notice);
    }
}
