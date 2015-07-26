package com.example.sqlitebroser;
public class Contact {    
    public String name = "";
    public String email = "";
    public String mobileNo = "";
    public String getName() {
           return name;
    }
    public void setName(String name) {
           this.name = name;
    }
    public String getEmail() {
           return email;
    }
    public void setEmail(String email) {
           this.email = email;
    }
    public String getMobileNo() {
           return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
           this.mobileNo = mobileNo;
    }
     // constructor
    public Contact (String name,String email,String mobileNo){
           this.email = email;
           this.mobileNo = mobileNo;
           this.name = name;
    }  
    public Contact (){
          
    }
}