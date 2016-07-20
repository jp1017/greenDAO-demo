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

package com.example.jp.greendao_demo;

import android.app.Application;

import com.example.jp.greendao_demo.db.DbCore;

/**
 * 文 件 名: DAOApplication
 * 说   明:
 * 创 建 人: 蒋朋
 * 创建日期: 16-7-19 12:43
 * 邮   箱: jp19891017@gmail.com
 * 博   客: http://jp1017.github.io
 * 修改时间：
 * 修改备注：
 */
public class DAOApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DbCore.init(this);
        DbCore.enableQueryBuilderLog();
    }
}
