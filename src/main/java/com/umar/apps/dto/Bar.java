package com.umar.apps.dto;

import java.io.Serializable;

public class Bar implements Serializable {

    @Override
    public String toString() {
        return Bar.class.getCanonicalName();
    }
}
