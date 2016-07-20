package com.example.jp.greendao_demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jp.User;
import com.example.jp.UserDao;
import com.example.jp.greendao_demo.db.DbUtil;
import com.example.jp.greendao_demo.db.UserHelper;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserHelper userHelper;

    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userHelper = DbUtil.getPersonService();

        /****** 数据库的增删改查测试开始 *******/

        userInsert();       //增
        userDelete();       //删
        userUpdate();       //改
        userQuery();        //查

        /****** 数据库的增删改查测试结束 *******/



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void userQuery() {
        List<User> users = userHelper.queryBuilder().where(UserDao.Properties.Number.eq("3")).list();
        List<User> users1 = userHelper.query("where NUMBER=?", "5");
        List<User> users2 = userHelper.queryAll();

        for (User u : users) {
            KLog.w("query: " + u.getPassword());
        }

        for (User u : users1) {
            KLog.d("query1: " + u.getPassword());
        }

        for (User u : users2) {
            KLog.i("query2: " + u.getPassword());
        }
    }

    private void userUpdate() {
        User user = new User();
        user.setNumber("77");
        user.setPassword("##**77**##");
        userHelper.save(user);
        user.setPassword("******77******");
        userHelper.update(user);        //更新单个

        User user1 = new User();
        user1.setNumber("77");
        user1.setPassword("##**77**##");
        userHelper.save(user1);
        user1.setPassword("******77******");
        userHelper.update(user, user1);     //更新多个
    }

    private void userDelete() {
        User user = new User();
        user.setNumber("666");
        user.setPassword("666666");
        userHelper.save(user);
        userHelper.delete(user);
    }

    private void userInsert() {
        userHelper.deleteAll();//清空

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setNumber(i + "");
            user.setPassword("#####" + i + "*****");
            users.add(user);
        }
        userHelper.save(users);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
