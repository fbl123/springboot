package com.guns.demo.model;

import java.util.Date;

public class Lender {


    private Long id;
    private String userName;
    private String Password;
    private String mobile;
    private String otp;

    private Integer status=0;  //0 未激活  1激活
    private Integer type;  // 1. Borrower 2. Lender
    private Date createTime;

}
