package com.example.a1.rxjavademo.p;

import com.example.a1.rxjavademo.Bean;
import com.example.a1.rxjavademo.m.DataModle;
import com.example.a1.rxjavademo.m.ModleInterface;
import com.example.a1.rxjavademo.v.MyView;

public class MvpPresenter implements ModleInterface {

    MyView myView;
    DataModle dataModle = new DataModle(this);

    public MvpPresenter(MyView myView) {
        this.myView = myView;
    }
    public  void handler(){
        dataModle.getData();
       // dataModle.getStringData();
    }

    @Override
    public void loadSuccess(Bean bean) {
        myView.showList(bean);
    }

//    @Override
//    public void loadString(String string) {
//        myView.showString(string);
//    }

    public void setItemClick(int position){
        myView.showMessage(position);
    }
}
