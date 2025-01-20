package com.jackiewang.reflection;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent
public @interface MyConfiguration {
    @AliasFor(
            annotation = MyComponent.class
    )
    String value() default "configuration";
}
