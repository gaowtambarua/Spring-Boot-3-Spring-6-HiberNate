package com.gaowtam.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements  MembershipDAO{

    //    @Override
//    public void addAccount() {
//        System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
//    }

//    @Override
//    public void addSillyMember() {
//        System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
//    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return  true;
    }
}
