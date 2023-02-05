package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            throw e;
        }
    }}
/*
* Explanation:

The main method calls the riskyMethod which can throw various types of exceptions.

The first catch block handles IOException, and it wraps it with IllegalArgumentException and throws it.

The second catch block handles FileNotFoundException, and it wraps it with IllegalArgumentException and throws it.

The third catch block handles ArithmeticException and NumberFormatException, it just prints the error message to System.err but doesn't throw any exception.

The fourth catch block is the catch-all block, it just throws the exception as it is.
* */
