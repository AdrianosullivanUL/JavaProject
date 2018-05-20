/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise05.pkg7;

/**
 * [Class Title Here]
 * @author Adrian O'Sullivan
 * Student ID 16230124
 * Last Modified [dd/mm/yyyy]
 */
public class     GeneralTestHarness {

    public static void main(String args[]) {
        GeneralTestHarness generalTestHarness = new GeneralTestHarness();
        generalTestHarness.ExecuteTests();
    }

    private void ExecuteTests()  {
        // Test the Application Exception handler
        System.out.println("");
        try {
            throw new ApplicationException("I am a test");
        }
        catch (ApplicationException ex)
        {
            if (ex.getMessage() == "I am a test")
                System.out.println("Pass: Application Exception Hadler test");
        }

    }
}
   
