package org.springbootexample.trans.exception;

public class MyException extends RuntimeException {
    public MyException() {
        super();
    }
    public MyException(String runtime) {
        super(runtime);
    }
}
