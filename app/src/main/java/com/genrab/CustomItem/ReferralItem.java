package com.genrab.CustomItem;

/**
 * Created by intel on 6/13/2017.
 */

public class ReferralItem {

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRefralamount() {
        return refralamount;
    }

    public void setRefralamount(String refralamount) {
        this.refralamount = refralamount;
    }

    public String getRefraldate() {
        return refraldate;
    }

    public void setRefraldate(String refraldate) {
        this.refraldate = refraldate;
    }

    public String getRefralstatus() {
        return refralstatus;
    }

    public void setRefralstatus(String refralstatus) {
        this.refralstatus = refralstatus;
    }

    public String firstname;
    public String lastname;
    public String username;
    public String refralamount;
    public String refraldate;
    public String refralstatus;

    //Referral data
    public ReferralItem( String firstname , String lastname, String username, String refralamount, String refraldate, String refralstatus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.refralamount = refralamount;
        this.refraldate = refraldate;
        this.refralstatus = refralstatus;
    }
    //End
}
