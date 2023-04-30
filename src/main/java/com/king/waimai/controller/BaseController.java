package com.king.waimai.controller;

import javax.servlet.http.HttpSession;

/**
 * 表示基类
 */
public class BaseController {

    /**
     * 操作成功的状态码
     */
    public static final  int OK =200;


    /**
     * 获取session 对象中的uid
     *
     * @param session session 对象
     * @return 当前登录的用户uid 的值
     */
    protected final Long getIdFromSession(HttpSession session) {
        return Long.valueOf(session.getAttribute("id").toString());
    }

//    protected final String getIdFromSessions(HttpSession session) {
//        return session.getAttribute("id").toString();
//    }
    /**
     * 获取当前登录用户的username
     *
     * @param session session 对象
     * @return 当前登录用户的用户名
     */
    protected final String getUserById(HttpSession session) {
        return session.getAttribute("userId").toString();
    }


}
