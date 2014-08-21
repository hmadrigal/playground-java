package com.tengen.odm;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by herberthm on 8/20/2014.
 */
@Entity("repos")
public class Repository {
    @Id
    public String name;
    @Reference
    public Organization organization;
    @Reference
    public GithubUser owner;
    //public Settings settings = new Settings();

    public Repository(){
    }

    public Repository(final Organization organization, final String name){
        this.organization= organization;
        this.name = organization.name + "/" + name;
    }
}
