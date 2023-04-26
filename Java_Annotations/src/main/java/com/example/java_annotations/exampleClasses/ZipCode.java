package com.example.java_annotations.exampleClasses;


import com.example.java_annotations.ZipCodePattern;

public class ZipCode {

    @ZipCodePattern(regex="[0-9]{2}-[0-9]{3}", message="This value is not correct!")
    private String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipCode='" + zipCode + '\'' +
                '}';
    }
}
