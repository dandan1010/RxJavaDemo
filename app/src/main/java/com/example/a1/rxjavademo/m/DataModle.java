package com.example.a1.rxjavademo.m;

import com.example.a1.rxjavademo.Bean;
import com.example.a1.rxjavademo.DataUrl;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModle  {
    String url = "http://www.qubaobei.com/ios/cf/";
    ModleInterface modleInterface;

    public DataModle(ModleInterface modleInterface) {
        this.modleInterface = modleInterface;
    }
    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        DataUrl dataUrl = retrofit.create(DataUrl.class);
        dataUrl.observable(url+"dish_list.php?stage_id=1&limit=20&page=1")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                modleInterface.loadSuccess(bean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

//    public void getStringData(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        DataUrl dataUrl = retrofit.create(DataUrl.class);
//        dataUrl.getString(url+"dish_list.php?stage_id=1&limit=20&page=1")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String string) {
//                        modleInterface.loadString(string);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
