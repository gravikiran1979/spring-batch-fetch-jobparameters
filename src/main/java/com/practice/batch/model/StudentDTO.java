package com.practice.batch.model;

public class StudentDTO {
  
    private String emailAddress;
    private String name;
    private String purchasedPackage;
    private String studingIn;
    private String schoolName;

    public StudentDTO() {}
  
    public String getEmailAddress() {
        return emailAddress;
    }
  
    public String getName() {
        return name;
    }
  
    public String getPurchasedPackage() {
        return purchasedPackage;
    }
  
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public void setPurchasedPackage(String purchasedPackage) {
        this.purchasedPackage = purchasedPackage;
    }

    public String getStudingIn() {
        return studingIn;
    }

    public void setStudingIn(String studingIn) {
        this.studingIn = studingIn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override public String toString() {
        return "StudentDTO{" + "emailAddress='" + emailAddress + '\'' + ", name='" + name + '\''
                + ", purchasedPackage='" + purchasedPackage + '\'' + ", studingIn='" + studingIn + '\''
                + ", schoolName='" + schoolName + '\'' + '}';
    }
}