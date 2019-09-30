package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * representation of a user.
 */
class User implements IAccount , Parcelable {

    private String userName;
    private int credits;

    /**
     * constructor
     * @param userName the name to set of the constructed user.
     * @param credits the number of credits to give the contructed user.
     */
    User(String userName, int credits) {
        this.userName = userName;
        this.credits = credits;
    }

    protected User(Parcel in) {
        userName = in.readString();
        credits = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /**
     * get the name of a given user.
     * @return the name of a given user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get the number of credits left for a given user.
     * @return the number of credits left for a given user.
     */

    public int getCredits() {
        return credits;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeInt(credits);
    }
}
