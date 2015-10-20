package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoGen {
    public static void main(String args[]) throws Exception {
        //创建了一个用于添加实体（Entity）的模式（Schema）对象。
        Schema schema = new Schema(1, "com.example.jp");

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
