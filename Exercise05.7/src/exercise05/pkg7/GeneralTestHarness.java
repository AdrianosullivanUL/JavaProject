/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

/**
 * General test harness for the application
 *
 * @author Mary Cronin 0510661,  Adrian O'Sullivan 16230124
 */
public class GeneralTestHarness {

    /**
     * Entry point for the general test harness execution
     *
     * @param args command lie arguments not used
     */
    public static void main(String args[]) {
        GeneralTestHarness generalTestHarness = new GeneralTestHarness();
        generalTestHarness.ExecuteTests();
    }

    /**
     * Execute the tests required
     */
    private void ExecuteTests() {
        // Test the Application Exception handler
        System.out.println("");
        try {
            throw new ApplicationException("I am a test");
        } catch (ApplicationException ex) {
            if (ex.getMessage() == "I am a test") {
                System.out.println("Pass: Application Exception Hadler test");
            }
        }

    }
}
