package com.tengen;

import com.mongodb.Mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * Created by herberthm on 8/20/2014.
 */
public class BaseTest {
    protected Datastore ds;

    public BaseTest() throws UnknownHostException {
        ds = new Morphia().createDatastore(new Mongo("localhost",27017),"github");
    }
}
