package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DaoGen {
    public static void main(String args[]) throws Exception {
        //创建了一个用于添加实体（Entity）的模式（Schema）对象。
        Schema schema = new Schema(1, "com.example.jp");
        schema.enableKeepSectionsByDefault();//加入自己的一些信息，下次生成的时候不消失
        //一个实体（类）就关联到数据库中的一张表，此处表名为User（类名）
        Entity userBean = schema.addEntity("User");

        //添加字段
        userBean.addIdProperty();
        userBean.addStringProperty("number");
        userBean.addStringProperty("password");

        //生成DAO
        new DaoGenerator().generateAll(schema, "app/src/main/java-gen");
    }
}
