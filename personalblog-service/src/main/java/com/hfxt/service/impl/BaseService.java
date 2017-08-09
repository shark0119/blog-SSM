package com.hfxt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hfxt.dao.IAnnouncementDao;
import com.hfxt.dao.IBlogDao;
import com.hfxt.dao.IBlogcommentDao;
import com.hfxt.dao.IBlogcontentDao;
import com.hfxt.dao.IBloglabelDao;
import com.hfxt.dao.IBloglivenessDao;
import com.hfxt.dao.IBlognewlivenessDao;
import com.hfxt.dao.ILabelDao;
import com.hfxt.dao.IMessageDao;
import com.hfxt.dao.IRoleDao;
import com.hfxt.dao.IRolerightDao;
import com.hfxt.dao.ISectionDao;
import com.hfxt.dao.ITrightDao;
import com.hfxt.dao.IUserDao;
import com.hfxt.dao.IUserlabelDao;
import com.hfxt.jedis.dao.impl.RedisBlogLivenessDao;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public abstract class BaseService {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected IAnnouncementDao announcementDao;
    @Autowired
    protected IBlogDao blogDao;
    @Autowired
    protected IBlogcommentDao blogcommentDao;
    @Autowired
    protected IBlogcontentDao blogcontentDao;
    @Autowired
    protected IBloglabelDao bloglabelDao;
    @Autowired
    protected IBloglivenessDao bloglivenessDao;
    @Autowired
    protected IBlognewlivenessDao blognewlivenessDao;
    @Autowired
    protected ILabelDao labelDao;
    @Autowired
    protected IMessageDao messageDao;
    @Autowired
    protected IRoleDao roleDao;
    @Autowired
    protected IRolerightDao rolerightDao;
    @Autowired
    protected ISectionDao sectionDao;
    @Autowired
    protected ITrightDao trightDao;
    @Autowired
    protected IUserDao userDao;
    @Autowired
    protected IUserlabelDao userlabelDao;
  
}

