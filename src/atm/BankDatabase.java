/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.HashMap;

/**
 *
 * @author hp
 */
public class BankDatabase {
    private static HashMap<String, Account> Server = new HashMap<String, Account>();
//    public BankDatabase(String an,double ab,int pin){
//        Account x=new Account(an,ab,pin);
//        Server.put(an, x);
//        
//    }
    

    BankDatabase(){
        Server.put("880", new Account("Siddharth Singh","880",15000,2412));
        Server.put("881", new Account("Kushagra Sharma","881",12000,1441));
        Server.put("882", new Account("Devansh Mishra","882",9870,7897));
        Server.put("883", new Account("Ankur Marawi","883",14200,5789));
        Server.put("884", new Account("S. Singh","884",9999,1478));
    }
    public void AddUser(String name,String an,double aB,int pin){
        Server.put(an, new Account(name,an,aB,pin));
    }
    public boolean authenticateUSER(String an,int p){
        if(Server.containsKey(an) && Server.get(an).validatePIN(p)){
            return true;
        }
        else{
            return false;
        }
    }
    public double getAvailableBalance(String an){

        
        Account a = Server.get(an);
        
        double bal= a.getBalance();
        
        return bal;
    }
    public void credit(String an,double ca){
        Account a=Server.get(an);
        a.credit(ca);
    }
    public void debit(String an,double da){
        Account a=Server.get(an);
        a.debit(da);
    }
    public void PrintDatabase(){
        for (String i : Server.keySet()) {
            System.out.println("Account Number: " + i + " Balance: " + Server.get(i).getBalance());
}
    }
    public void PinChange(String an,int p,int np){
        Account a = Server.get(an);
        if(a.validatePIN(p)){
            a.changePIN(np);
            System.out.println("\nChanged PIN Successfully!");
        }
        else{
            System.out.println("\nWrong PIN!");
        }
        
    }
    public String Username(String an){
        
        return Server.get(an).getName();
    }
    
    
}
