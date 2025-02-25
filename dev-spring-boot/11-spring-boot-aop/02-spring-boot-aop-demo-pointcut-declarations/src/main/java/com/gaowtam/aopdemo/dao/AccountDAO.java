package com.gaowtam.aopdemo.dao;

import com.gaowtam.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

//    void addAccount();

//    void addAccount(Account theAccount);

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    // add a new method : findAccount
    List<Account> findAccount();

    List<Account> findAccount(boolean tripWire);
}
