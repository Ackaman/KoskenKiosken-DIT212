package com.dit212.group1.koskenkiosken.Model;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: simple user abstraction. Outside actors should not have access to methods they don't use.
 */
public interface IUser {

    String getUserName();
    int getCredits();
}
