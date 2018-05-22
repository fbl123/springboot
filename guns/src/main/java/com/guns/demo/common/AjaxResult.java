package com.guns.demo.common;

/**
 *
 * Ajax请求返回值
 *
 *
 */
public class AjaxResult {

    public static final String STATUS_OK="ok";

    public static final String STRING_ERROR="error";


    private String status; //ok|error 状态 成功|失败
    private String message; //失败时返回的错误消息
    private Object date; //成功时返回的数据

    public AjaxResult(String status,Object date){
        this.status=status;
        this.date=date;

    }
    public AjaxResult(String status,Object date ,String message){
        this.status=status;
        this.message=message;
        this.date=date;
    }


    public static AjaxResult ok(Object date){

        return new AjaxResult(AjaxResult.STATUS_OK,date);
    }
    public static AjaxResult error(String message){
        return new AjaxResult(AjaxResult.STRING_ERROR,null,message);

    }
    public static AjaxResult error(String message,Object date){
        return new AjaxResult(AjaxResult.STRING_ERROR,date,message);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
