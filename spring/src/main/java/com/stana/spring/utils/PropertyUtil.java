package com.stana.spring.utils;

import com.stana.spring.constant.Status.*;

public class PropertyUtil{
    private PropertyID propertyID;

    public PropertyUtil(PropertyID propertyID) {
        this.propertyID = propertyID;
    }
    public String getContextNameByID(){
        String parentPath = "properties/";
        switch(propertyID) {
            case CORRECT:
                return parentPath + "BeanCorrect.xml";
            case ERROR:
                return parentPath + "BeanTest1.xml";
            case DEFAULT:
                return "ApplicationContext.xml";
        }
        return null;
    }
}
