package com.genrab.CustomItem;

/**
 * Created by intel on 6/13/2017.
 */

public class HistoryItem {
    public String name;
    public String author;

    public HistoryItem(String name,String author){
        this.name=name;
        this.author=author;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }






    public String getTranactionID() {
        return tranactionID;
    }

    public void setTranactionID(String tranactionID) {
        this.tranactionID = tranactionID;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getTranactionamount() {
        return tranactionamount;
    }

    public void setTranactionamount(String tranactionamount) {
        this.tranactionamount = tranactionamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String tranactionID;
    public String mode;
    public String transdate;
    public String accountnumber;
    public String tranactionamount;
    public String status;

    public HistoryItem(String accountnumber, String mode, String transdate, String tranactionID, String tranactionamount, String status) {
        this.tranactionID = tranactionID;
        this.mode = mode;
        this.transdate = transdate;
        this.accountnumber = accountnumber;
        this.tranactionamount = tranactionamount;
        this.status = status;
    }


    public String rateDate;
    public String description;
    public String cycle;
    public String distrub;
    public String investAmount;
    public String generateAmount;


    public HistoryItem(String rateDate, String description, String distrub, String investAmount, String generateAmount) {
        this.rateDate = rateDate;
        this.description = description;
        this.distrub = distrub;
        this.investAmount = investAmount;
        this.generateAmount = generateAmount;
    }

    public String getRateDate() {
        return rateDate;
    }

    public void setRateDate(String rateDate) {
        this.rateDate = rateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getDistrub() {
        return distrub;
    }

    public void setDistrub(String distrub) {
        this.distrub = distrub;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getGenerateAmount() {
        return generateAmount;
    }

    public void setGenerateAmount(String generateAmount) {
        this.generateAmount = generateAmount;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    //Get the  user history here..
    public String userId;
    public String date;
    public String packageName;
    public String amount;


    public HistoryItem(String userId, String date, String amount) {
        this.userId = userId;
        this.date = date;
        this.amount = amount;
    }


}
