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
public class Account {
    
    private String accountnumber ;
    private int pin;
    private double availableBalance;
    private String name;
    public Account(String noc,String an,double ab,int p){
        this.accountnumber=an;
        this.pin=p;
        this.availableBalance=ab;
        this.name=noc;
    }
    public double getBalance(){
       return availableBalance; 
    }
    public String getName(){
        return this.name;
    }
    public void credit(double c){
        this.availableBalance +=c;
    }
    public void debit(double d){
        this.availableBalance -=d;
    }
    public boolean validatePIN(int p){
        if(this.pin==p){
            return true;
        }
        return false;
    }
    public void changePIN(int newP){
        this.pin=newP;
    }
    
}
