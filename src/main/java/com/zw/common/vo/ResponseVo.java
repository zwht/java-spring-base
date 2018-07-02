package com.zw.common.vo;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created by zhaowei on 2017/6/29.
 */
public class ResponseVo<D> {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Integer code;
    private D data;
    private String message;
    private List messageObj;

    public ResponseVo success() {
        meta(200, OK);
        return this;
    }

    public ResponseVo success(D data) {
        meta(200, OK);
        this.data = data;
        return this;
    }

    public ResponseVo failure(Integer code) {
        meta(code, ERROR);
        return this;
    }

    public ResponseVo failure(Integer code, String message) {
        meta(code, message);
        return this;
    }
    public ResponseVo failure(Integer code, List messageObj) {
        meta(code,"验证错误");
        this.messageObj=messageObj;
        return this;
    }

    public ResponseVo validation(Set<ConstraintViolation> constraintViolations){
        List<Map> list = new ArrayList<Map>();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            Map<String,String> violatorList=new HashMap<String, String>();
            violatorList.put("key",constraintViolation.getPropertyPath().toString());
            violatorList.put("msg",constraintViolation.getMessage());
            list.add(violatorList);
        }
        return this.failure(401,list);
    }

    public void meta(Integer code, String message) {
        this.message = message;
        this.code=code;
    }

    public D getData() {
        return this.data;
    }
    public String getMessage() {
        return this.message;
    }
    public Integer getCode() {
        return this.code;
    }
    public List getMessageObj() {
        return this.messageObj;
    }

}
