package com.tengen.odm;

import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by herberthm on 8/20/2014.
 */
@Entity(value = "users", noClassnameStored = true)
@Indexes({
        @Index(value = "userName, -followers", name = "popular"),
        // Removes documents after their time has expired. Applies only to Date fields
        @Index(value = "lastActive", name = "idle", expireAfterSeconds = 1000000000)
})
public class GithubUser {
    @Id
    public String userName;
    public String fullName;
    @Property("since")
    public Date memberSince;
    public Date lastActive;
    @Reference(lazy = true)
    public List<Repository> repositories = new ArrayList<Repository>();
    public int followers = 0;
    public int following = 0;

    public GithubUser()
    {
    }

    public GithubUser(final String userName)
    {
        this.userName = userName;
    }
}
