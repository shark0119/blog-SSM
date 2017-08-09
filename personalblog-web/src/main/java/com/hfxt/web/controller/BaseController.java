package com.hfxt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hfxt.service.IAnnouncementService;
import com.hfxt.service.IBlogService;
import com.hfxt.service.IBlogcommentService;
import com.hfxt.service.IBlogcontentService;
import com.hfxt.service.IBloglabelService;
import com.hfxt.service.IBloglivenessService;
import com.hfxt.service.IBlognewlivenessService;
import com.hfxt.service.IJedisBlogLivenessService;
import com.hfxt.service.ILabelService;
import com.hfxt.service.IMailService;
import com.hfxt.service.IMessageService;
import com.hfxt.service.INoticeService;
import com.hfxt.service.IRoleService;
import com.hfxt.service.IRolerightService;
import com.hfxt.service.ISectionService;
import com.hfxt.service.ITrightService;
import com.hfxt.service.IUserService;
import com.hfxt.service.IUserlabelService;
/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public abstract class BaseController {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected IAnnouncementService announcementService;
    @Autowired
    protected IBlogService blogService;
    @Autowired
    protected IBlogcommentService blogcommentService;
    @Autowired
    protected IBlogcontentService blogcontentService;
    @Autowired
    protected IBloglabelService bloglabelService;
    @Autowired
    protected IBloglivenessService bloglivenessService;
    @Autowired
    protected IBlognewlivenessService blognewlivenessService;
    @Autowired
    protected ILabelService labelService;
    @Autowired
    protected IMessageService messageService;
    @Autowired
    protected IRoleService roleService;
    @Autowired
    protected IRolerightService rolerightService;
    @Autowired
    protected ISectionService sectionService;
    @Autowired
    protected ITrightService trightService;
    @Autowired
    protected IUserService userService;
    @Autowired
    protected IUserlabelService userlabelService;
    @Autowired
    protected IMailService mailService;
    @Autowired
    protected IJedisBlogLivenessService jedisBlogLivenessService;
    @Autowired
    protected INoticeService noticeService;
}

