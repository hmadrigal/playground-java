package com.tengen;

import com.tengen.odm.GithubUser;
import com.tengen.odm.Organization;
import com.tengen.odm.Repository;
import org.junit.Test;


import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by herberthm on 8/20/2014.
 */
public class ObjectDocumentMapperTest extends BaseTest{
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private GithubUser evanchooly;
    private Date date;

    public ObjectDocumentMapperTest() throws ParseException, UnknownHostException {
        super();
        this.date = this.sdf.parse("6-15-1987");
    }

    @Test
    public void basicUser() {
        evanchooly = new GithubUser("evanchooly");
        evanchooly.fullName = "Justin Lee";
        evanchooly.memberSince = date;
        evanchooly.following = 1000;

        ds.save(evanchooly);
    }

    @Test
    public void repositories() {
        Organization org = new Organization("mongodb");
        ds.save(org);

        Repository morphia1 = new Repository(org,"morphia");
        //Repository morphia2 = new Repository(evanchooly,"morphia");
    }

}
