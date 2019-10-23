package com.dit212.group1.koskenkiosken.Model.Authentication.data.model;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 *
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    /**
     * An unique identifier of the user.
     */
    private String userId;

    /**
     * The user's name that is displayed in the app.
     */
    private String displayName;

    /**
     * The constructor for logged in users.
     *
     * @param userId The user's unique identifier
     * @param displayName The user's name that is displayed in the app
     */
    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    /**
     * Gives the logged in user's unique number.
     *
     * @return The user's unique identifier
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gives the logged in user's name for displaying
     *
     * @return The user's display name.
     */
    public String getDisplayName() {
        return displayName;
    }
}
