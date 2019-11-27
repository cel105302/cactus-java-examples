package com.cactus.demo.cactusspringboot.unsubmit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnsubmitEnumeration {
    boolean isCheck() default false;

    String tokenName() default "token";

}
