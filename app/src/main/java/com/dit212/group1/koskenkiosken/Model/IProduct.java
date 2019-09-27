package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcelable;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: simple product abstraction. Outside actors should not have access to methods they don't use.
 */
public interface IProduct extends Parcelable {
    String getName();
    int getPrice();
    Product getObject();
    String getDescription();
}
