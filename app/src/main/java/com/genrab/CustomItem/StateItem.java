package com.genrab.CustomItem;

/**
 * Created by intel on 6/13/2017.
 */

public class StateItem {

    public String ipaddress;
    public String browser;

    public StateItem(String ipaddress,String browser,String statedate){
        this.ipaddress=ipaddress;
        this.browser=browser;
        this.statedate=statedate;
    }
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


    public String balancetype;
    public String mBalance;

    public StateItem(String balancetype,String mBalance){
        this.balancetype=balancetype;
        this.mBalance=mBalance;
    }

    public String getBalancetype() {
        return balancetype;
    }

    public void setBalancetype(String balancetype) {
        this.balancetype = balancetype;
    }

    public String getmBalance() {
        return mBalance;
    }

    public void setmBalance(String mBalance) {
        this.mBalance = mBalance;
    }


    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public String getStateTransId() {
        return stateTransId;
    }

    public void setStateTransId(String stateTransId) {
        this.stateTransId = stateTransId;
    }

    public String getStatedate() {
        return statedate;
    }

    public void setStatedate(String statedate) {
        this.statedate = statedate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String credit;
    public String debit;
    public String stateDescription;
    public String stateTransId;
    public String statedate;
    public String balance;

    //Statement data
    public StateItem( String stateDescription , String stateTransId, String statedate, String balance, String credit, String debit) {
        this.stateDescription = stateDescription;
        this.stateTransId = stateTransId;
        this.statedate = statedate;
        this.balance = balance;
        this.credit = credit;
        this.debit = debit;
    }
    //End
}
