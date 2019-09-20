package com.wwj.yllintegral.utility;

import lombok.Data;

import static com.wwj.yllintegral.utility.Constants.*;

@Data
public class Result<T> {
    private String msg ;
    private int status;
    private T data;

    public static Result success(Object object){
        Result<Object> resoult = new Result<>();
        resoult.setMsg(SUCCESS_MSG);
        resoult.setStatus(SUCCESS_STATUS);

        resoult.setData(object);
        return resoult;
    }

    public static Result error(){
        Result<Object> resoult = new Result<>();
        resoult.setMsg(ERROR_MSG);
        resoult.setStatus(ERROR_STATUS);
        return resoult;
    }
}
