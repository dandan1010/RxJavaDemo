package com.example.a1.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a1.rxjavademo.p.MvpPresenter;
import com.example.a1.rxjavademo.v.MyView;

import java.util.ArrayList;

public abstract class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MyView {

    ListView listView;
    MvpPresenter mvpPresenter;
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        mvpPresenter = new MvpPresenter(this);
        mvpPresenter.handler();
    }

    @Override
    public void showList(Bean bean) {

        for (int i = 0;i<bean.getData().size();i++){
            list.add(bean.getData().get(i).getTitle());
        }
        Log.v("ZDZD","标题长度"+list.size());
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

    @Override
    public void showMessage(int  position) {

    }

//    @Override
//    public void showString(String string) {
//        Log.v("ZDZD","请求的字符串类型"+string);
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mvpPresenter.setItemClick(position);
    }
}
