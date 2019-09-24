package com.dit212.group1.koskenkiosken.Model;

/**
 * Author: created by thowsen, 2019-09-23
 * Description: simplified persistant storage solution. used for looser coupling between model and storage implementation.
 */
public interface IDatabase {
    void readProducts();
    void writeProducts();
}
