package com.synertone.routerannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lance
 * @date 2018/2/22
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface Extra {

    String name() default "";
}
