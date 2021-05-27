/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.util.*;

/**
 *
 * @author hp
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BankDatabase data = new BankDatabase();
        Atmfunctions op = new Atmfunctions();
        int Count=0;
        for(;true;){
            System.out.print("\nWelcome!!\n"+"\tChoose your Operation\n");
            System.out.print("(1) - Existing User \n"+"(2) - New User \n");
            int x = in.nextInt();
            if(x==1){
                
                System.out.println("\n\n\n");
              System.out.print("\tWelcome!!!\n"+"  Log In to Start...\n"+"Enter Your Account Number....");
            String an = in.next();
            System.out.print("\nEnter Your PIN....");
            int pin = in.nextInt();
            System.out.println("\n");
            //System.out.println(operations.Authenticate(an));
            if(data.authenticateUSER(an,pin)){
                
                System.out.println("Welcome!! USER.... "+data.Username(an)+"\n");
                System.out.println("\n Main Menu :-\n\n"+"\t(1) - My Balance \n"+"\t(2) - Withdraw Cash\n"+"\t(3) - Change PIN\n"+"\t(4) - Exit \n");
                int option = in.nextInt();
                if(option==1){
                    
//                    data.PrintDatabase();
                    
                    op.BalanceEnquiry(an);
//                    System.out.println("Your Account Balance is.... "+ba);
                    
                }
                else if(option==2){
                    System.out.print("\tWithdrawal Window!!\n"+"\t Enter Amount for Withdrawal.... ");
                    
                    double cash = in.nextDouble();
                    System.out.println("\n");
                    op.Withdrawal(an,cash);
                    
                    
                    
                }
                else if(option==3){
                    System.out.print("\tChange PIN Window!!\n"+"To Change the PIN.\n"+"\n\nEnter Your Current PIN : ");
                    int p = in.nextInt();
                    System.out.print("\nEnter New PIN.. ");
                    int np = in.nextInt();
                    data.PinChange(an, p, np);
                }
                else
                    continue;
                
            }
            else{
                System.out.print("\n Wrong PIN, NO Data Found!\n\tTry Again!!\n\n");
            }
            
         }
            else if(x==2){
                System.out.print("\tWelcome New User!!\n");
                String ann = "89"+String.valueOf(Count);
                Count++;
                System.out.print("Enter Your Full Name... ");
                in.nextLine();
                String name = in.nextLine();
                System.out.print("\nEnter Your PIN...");
                int pinNew = in.nextInt();
                System.out.print("\nEnter Your Balance...");
                double amm  = in.nextDouble();
                
                data.AddUser(name,ann,amm,pinNew);
                System.out.println("Your Account Number is : "+ann+"\n");
//                data.PrintDatabase();
                System.out.print("\nSuccessfully Created your New Account!!\n\n\n");
                
                
                
            }
            
            
        }
        
        
    }
    
}
