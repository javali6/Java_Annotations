package com.example.java_annotations;


import com.example.java_annotations.exampleClasses.ZipCode;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator implements Validator{

    private Field field;
    private ZipCodePattern zipCodePattern;
    private boolean valid;

    @Override
    public void validate(String value) {
        try {
            field = ZipCode.class.getDeclaredField("zipCode");
            zipCodePattern = field.getAnnotation(ZipCodePattern.class);

            Pattern pattern = Pattern.compile(zipCodePattern.regex(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(value);

            valid = matcher.find();


        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String getMessage() {
        return zipCodePattern.message();
    }
}
