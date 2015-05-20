package samsao.daggerdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * @author Lukasz Piliszczuk <lukasz.pili@gmail.com>
 */
@Scope
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DaggerScope {

    public Class<?> value();
}
