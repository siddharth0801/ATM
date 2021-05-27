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
public class Atmfunctions {
    BankDatabase BankServer=new BankDatabase();
    
    Atmfunctions(){
        
    }
    
    public void BalanceEnquiry(String an){

        System.out.println("\nMy Balance!! ");
        
        double bal = BankServer.getAvailableBalance(an);
        System.out.println("\nYour Balance is .... "+bal+"\n\n");
        
    }
    public void Withdrawal(String an,double amount){
        CashDispenser cd=new CashDispenser(10000);
//        BankDatabase BankServer=new BankDatabase();
        boolean yesorno =cd.isCashSuffiecient(amount);
        if(yesorno){
           if(BankServer.getAvailableBalance(an)>amount){
               BankServer.debit(an, amount);
               cd.dispenseCash(amount);
           }
           else{
               System.out.println("In Sufficient Balance in your Account");
           }
        }
        else{
            System.out.println("Can't Withdraw Cash\n  Please Try again!!!");
        }
    }
    
    
    
}
