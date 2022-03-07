package com.chalmersmegagame.game.users.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Data class of a user.
 * The users are saved in a h2 database.
 */
@Entity
@Data
public class User {

    @Id
    @Column
    private String id;

    @Column
    @NotNull(message="{NotNull.User.role}")
    private String role;

}
