package com.jackiewang.spring.selfEditor;

import java.beans.PropertyEditorSupport;

public class PersonPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = text.split(",");
        if(parts.length==2){
            String name= parts[0];
            int age = Integer.parseInt(parts[1]);
            Person person = new Person(name,age);
            setValue(person);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
