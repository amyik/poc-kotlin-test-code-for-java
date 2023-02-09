package com.albert.testdouble;

public class PrivateHolder {

    private String privateStringField = "Not Stubbed";

    private String getPrivateStringField() {
        return privateStringField;
    }

    public String callPrivateMethod() {
        return getPrivateStringField();
    }

    private String myPrivateMethod(String str) {
        return "hi";
    }

}
