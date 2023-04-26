package com.example.java_annotations;

public interface Validator {

    void validate(String value);
    boolean isValid();
    String getMessage();

}
