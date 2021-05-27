/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author hp
 */
public class CashDispenser {
    private static double totalCash;//CASH IN THE ATM SHOULD BE GREATER THAN 50,000 .
    public CashDispenser(double cash){
        this.totalCash=cash;
    }

    CashDispenser() {
        
    }
    public void dispenseCash(double amount){
                int[] notes = new int[]{2000, 500, 200, 100};
		int[] noteCounter = new int[notes.length];
	
		// count notes using Greedy approach
                System.out.println("Currency Count ->");
		for (int i = 0; i < notes.length; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = (int) (amount/notes[i]);
				amount = amount - noteCounter[i] * notes[i];
                                System.out.println(notes[i] + " : "+ noteCounter[i]);
			}
		}
                
    }
    public boolean isCashSuffiecient(double amount){
        if(amount<=50000 && amount<this.totalCash){
            return true;
        }
        return false;
    }
}
