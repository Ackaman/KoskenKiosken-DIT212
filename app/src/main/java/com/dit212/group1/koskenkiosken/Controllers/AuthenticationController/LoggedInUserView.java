package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 *
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
