package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: none.
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {

    /**
     * The name of the account that authenticated.
     */
    private String displayName;
    //... other data fields that may be accessible to the UI

    /**
     * Create an object of this class that takes the name of the user.
     *
     * @param displayName The name of the account that authenticated.
     */
    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gives you the name of the account that logged in.
     *
     * @return A String
     */
    String getDisplayName() {
        return displayName;
    }
}
