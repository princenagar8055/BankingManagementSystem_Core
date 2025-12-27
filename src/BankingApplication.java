import java.util.Scanner;

public class BankingApplication { // in a package there will only one public class.
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount("prince","1234");
        bank1.showMenu();
    }
}

class BankAccount{
    // variable decalaration
    int balance;

    int lastTransaction;

    String customerName;
    String customerId;

    BankAccount(String cname,String cid){ //constructor called everytime we create object.
        customerName = cname;
        customerId = cid;
    }

    //methods

    // deposite -> NRT
    void deposit(int amount) {

        if (amount >0){ // here we use the negative pattern
            balance = balance + amount;
            lastTransaction=amount;
        }else {
            System.out.println("INVALID DEPOSIT AMOUNT");
        }
    }

    // withdraw -> NRT
    void withdraw(int amount){
        if(amount >0 && amount<=balance){ // we need to check whether we have enough balance or not!!
            balance = balance - amount;
            lastTransaction= -amount;
        }else {
            System.out.println("INVALID DEPOSIT AMOUNT");
        }
    }

    // lastTransaction->
     void getPreviousTransaction(){
        if(lastTransaction>0){
            System.out.println("AMOUNT DEPOSITED :"+lastTransaction);
        }
        else if (lastTransaction<0){
            System.out.println("AMOUNT WITHDRAWN :"+Math.abs(lastTransaction));// Math.abs is a method that covnert the negative value to the positive value
        }
        else {
            System.out.println("NO TRANSACTION IS OCCURED RECENTLY !! ");
        }
     }

    // check balance ->RT
     void checkBalance(){
        System.out.println("YOUR BALANCE IS : "+ balance);
    }


    // menu (from where to call)
    void showMenu(){
        char option='\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME "+customerName);
        System.out.println("YOUR ID is : "+customerId);


        //we need to repeatedly replay this without manually re-running this.
        do{
            System.out.println("==================================");
            System.out.println("ENTER THE OPTION");
            System.out.println("==================================");
            System.out.println("A. CHECK BALANCE");
            System.out.println("B. DEPOSIT");
            System.out.println("C. WITHDRAW");
            System.out.println("D. LAST TRANSACTION");
            System.out.println("E. EXIT");
            System.out.println("HERE:- ");

            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);

            switch (option){

                case 'A':
                    checkBalance();
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("ENTER THE AMOUNT TO DEPOSIT");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("ENTER THE AMOUNT TO WITHDRAW");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    getPreviousTransaction();
                    System.out.println();
                    break;

                case 'E' :
                    System.out.println("THANKING YOU FOR USING OUR SERVICES !!! ");
                    break;

                default:
                    System.out.println(" INVALID OPTION , CHOOSE THE RIGHT ONE !! ");
                    break;

            }
        }
        while (option !='E');
        sc.close();
    }

}


// functionality code ki dusri class me he , use main public class se call krne ke lie,
// phle us class ka object banaenge fr obj. refernce se required method call karenge
