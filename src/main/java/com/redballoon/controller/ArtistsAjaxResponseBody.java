package com.redballoon.controller;


import com.redballoon.model.Artist;

import java.util.List;


public class ArtistsAjaxResponseBody {

    String msg;
    String code;
    List<Artist> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Artist> getResult() {
        return result;
    }

    public void setResult(List<Artist> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", result=" + result + "]";
    }
}
