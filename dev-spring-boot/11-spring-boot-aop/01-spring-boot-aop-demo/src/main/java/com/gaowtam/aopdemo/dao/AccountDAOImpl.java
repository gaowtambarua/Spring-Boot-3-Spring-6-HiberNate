package com.gaowtam.aopdemo.dao;

import com.gaowtam.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

//    @Override
//    public void addAccount() {
//        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
//    }
/// /////////////////////////////////////////////
//    @Override
//    public void addAccount(Account theAccount,) {
//        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
//    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
