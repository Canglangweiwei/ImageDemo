package com.loveplusplus.demo.bean;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class BaseBean {

    private int result;
    private String message;
    private ArrayList<MessageBean> imgs;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<MessageBean> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<MessageBean> imgs) {
        this.imgs = imgs;
    }

    public BaseBean() {
        super();
    }
}
