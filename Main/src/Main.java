import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String description = "";
    static String addblock = "";

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static boolean SpecialIpAddress(int first, int second, int third, int fourth){
        if(first == 0){

        }
        else if(first == 100 && second >= 64 && second <= 127){

        }   
        else if(first == 127){

        }
        else if(first == 169 && second == 254){

        }
        else if()


        return false;
    }

    public static void SubnetCalculator(){
        
    }

    public static void AddressClass(){
        System.out.print("Input IP Address: ");
        String ip_add = input.next();
        String[] new_add = ip_add.split("\\."); 

        int first = Integer.parseInt(new_add[0]); 
        int second = Integer.parseInt(new_add[1]); 
        int third = Integer.parseInt(new_add[2]);
        int fourth = Integer.parseInt(new_add[3]);

        description = "";
        addblock = "";

        if(first < 0 && first > 255 && second < 0 && second > 255 && third < 0 && third > 255 && fourth < 0 && fourth > 255){
            System.out.println("Error: Invalid IP Address.");
        }
        else if(SpecialIpAddress(first, second, third, fourth)){

        }

        System.out.print("0 - Go To Menu, 1 - Input Address Type Again: ");
        int terminate = input.nextInt();
        if(terminate == 0){
            clearScreen();
            MainMenu();
        }
        else{
            clearScreen();
            AddressType();
        }
    }

    public static void AddressType(){
        System.out.print("Input IP Address: ");
        String ip_add = input.next();
        String[] new_add = ip_add.split("/");
        String[] address = new_add[0].split("\\."); 

        int second = Integer.parseInt(address[1]); 
        int third = Integer.parseInt(address[2]);
        int fourth = Integer.parseInt(address[3]);
        int fifth = Integer.parseInt(new_add[1]);

        int newfifth = 0;

        if(fifth >= 8 && fifth <= 15){
            newfifth = (int) Math. pow(2,(16 - fifth));

            if(fourth != 255){
                if(fourth % newfifth == 0){
                    System.out.println("The IP Address " + ip_add + " is a Network Address");
                }
                else if(fourth % (newfifth-1) == 0){
                    System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
                }
                else{
                    System.out.println("The IP Address " + ip_add + " is a Host Address");
                }
            }
            else if(third != 255){
                if(third % newfifth == 0){
                    System.out.println("The IP Address " + ip_add + " is a Network Address");
                }
                else if(third % (newfifth-1) == 0){
                    System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
                }
                else{
                    System.out.println("The IP Address " + ip_add + " is a Host Address");
                }
            }
            else{
                if(second % newfifth == 0){
                    System.out.println("The IP Address " + ip_add + " is a Network Address");
                }
                else if(second % (newfifth-1) == 0){
                    System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
                }
                else{
                    System.out.println("The IP Address " + ip_add + " is a Host Address");
                }
            }
        }
        else if(fifth >= 16 && fifth <= 23){
            newfifth = (int) Math. pow(2,(24 - fifth));

            if(fourth != 255){
                if(fourth % newfifth == 0){
                    System.out.println("The IP Address " + ip_add + " is a Network Address");
                }
                else if(fourth % (newfifth-1) == 0){
                    System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
                }
                else{
                    System.out.println("The IP Address " + ip_add + " is a Host Address");
                }
            }
            else{
                if(third % newfifth == 0){
                    System.out.println("The IP Address " + ip_add + " is a Network Address");
                }
                else if(third % (newfifth-1) == 0){
                    System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
                }
                else{
                    System.out.println("The IP Address " + ip_add + " is a Host Address");
                }
            }
        }
        else{
            newfifth = (int) Math. pow(2,(32 - fifth));

            if(fourth % newfifth == 0){
                System.out.println("The IP Address " + ip_add + " is a Network Address");
            }
            else if(fourth % (newfifth-1) == 0){
                System.out.println("The IP Address " + ip_add + " is a Broadcast Address");
            }
            else{
                System.out.println("The IP Address " + ip_add + " is a Host Address");
            }
        }

        System.out.print("0 - Go To Menu, 1 - Input Address Type Again: ");
        int terminate = input.nextInt();
        if(terminate == 0){
            clearScreen();
            MainMenu();
        }
        else{
            clearScreen();
            AddressType();
        }
    }

    public static void MainMenu(){

        System.out.println("Hello there Network Admin!");
        System.out.println("In order to help you, please select any of the following options:");

        System.out.println("[1] Subnet Calculator");
        System.out.println("[2] Check Address Class");
        System.out.println("[3] Check Address Type");
        System.out.println("[4] Exit");
        
        System.out.print("Input: ");
        int choice = input.nextInt();
         
        clearScreen();
        switch(choice) {
            case 1:
                SubnetCalculator();
                break;
            case 2:
                AddressClass();
                break;
            case 3:
                AddressType();
                break;
            case 4:
                System.out.println("Good Luck Network Admin!");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        MainMenu();
    }
}
