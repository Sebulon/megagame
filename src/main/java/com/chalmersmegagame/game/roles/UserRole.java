package com.chalmersmegagame.game.roles;

/**
 * Enum for what role the user is.
 * This is used for type safety.
 */
public enum UserRole {
    PLAYER("player"),
    CONTROLLER("controller");

    public final String name;

    UserRole(String name) {
        this.name = name;
    }

    public static UserRole findRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name.equals(role.toLowerCase())) {
                return userRole;
            }
        }
        return null;
    }
}
