/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, 蒋朋, china, qd. sd
**                          All Rights Reserved
**
**                           By(#######)
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/

package com.example.jp.greendao_demo.db;


import com.example.jp.UserDao;

/**
 * 文 件 名: DbUtil
 * 说   明:  获取表 Helper 的工具类
 * 创 建 人: 蒋朋
 * 创建日期: 16-7-19 10:44
 * 邮   箱: jp19891017@gmail.com
 * 博   客: http://jp1017.github.io
 * 修改时间：
 * 修改备注：
 */
public class DbUtil {
    private static UserHelper sHelper;


    private static UserDao getUserDao() {
        return DbCore.getDaoSession().getUserDao();
    }

    public static UserHelper getPersonService() {
        if (sHelper == null) {
            sHelper = new UserHelper(getUserDao());
        }
        return sHelper;
    }
}
