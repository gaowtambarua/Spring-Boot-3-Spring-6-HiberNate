package com.gaowtam.aopdemo.dao;

import com.gaowtam.aopdemo.Account;

public interface AccountDAO {

//    void addAccount();

//    void addAccount(Account theAccount);

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();
}
