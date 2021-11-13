package com.umar.apps.dto;

import java.io.Serializable;

public class Foo implements Serializable {

    @Override
    public String toString() {
        return Foo.class.getCanonicalName();
    }
}
