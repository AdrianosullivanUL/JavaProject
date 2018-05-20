/*
Formal Specification
---------------------------------
1 Task Formulation
Implement an exception handler for the application

2 Specification
   Input: message describing the error, Output: N/A

3 Problem Solving
Use a customised constructor to extend the java exception class and handle 
the events thrown by the applicaiton

4 Top Down Construction
Receive the message thrown and pass this to the Exception class message


5 Bottom-Up Verification
Pass a message to the constructor, result is message stored

6 Coding
Language is Java 

Variable Types
  Message String

7 Testing
See GeneralTestHarness class for test cases

 */
package exercise05.pkg7;

/**
 * Class to support exceptions for this application
 *
 * @author Adrian O'Sullivan Student ID 16230124 
 */
public class ApplicationException extends Exception {

    public ApplicationException(String message) {
        super(message);
    }
}

