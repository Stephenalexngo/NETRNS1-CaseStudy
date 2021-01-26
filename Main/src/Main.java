import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String description = "";

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    // https://en.wikipedia.org/wiki/Reserved_IP_addresses :D
    public static boolean SpecialIpAddress(int first, int second, int third, int fourth){
        if(first == 0){
            description = "Current network only valid as source address. Address Block = 0.0.0.0/8";
            return true;
        }
        else if(first == 100 && second >= 64 && second <= 127){
            description = "Shared address space for communications between a service provider and its subscribers when using a carrier-grade NAT. Address Block = 100.64.0.0/10";
            return true;
        }   
        else if(first == 127){
            description = "Used for loopback addresses to the local host. Address Block = 127.0.0.0/8";
            return true;
        }
        else if(first == 169 && second == 254){
            description = "Used for link-local addresses between two hosts on a single link when no IP address is otherwise specified, such as would have normally been retrieved from a DHCP server. Address Block = 169.254.0.0/16";
            return true;
        }
        else if(first == 192 && second == 0 && third == 0){
            description = "IETF Protocol Assignments. Address Block = 192.0.0.0/24";
            return true;
        }
        else if(first == 192 && second == 0 && third == 2){
            description = "Assigned as TEST-NET-1, documentation and examples. Address Block = 192.0.2.0/24";
            return true;
        }
        else if(first == 192 && second == 88 && third == 99){
            description = "Reserved. Formerly used for IPv6 to IPv4 relay. Address Block = 192.88.99.0/24";
            return true;
        }
        else if(first == 198 && (second == 18 || second == 19)){
            description = "Used for benchmark testing of inter-network communications between two separate subnets. Address Block = 198.18.0.0/15";
            return true;
        }
        else if(first == 198 && second == 51 && third == 100){
            description = "Assigned as TEST-NET-2, documentation and examples. Address Block = 198.51.100.0/24";
            return true;
        }
        else if(first == 203 && second == 0 && third == 113){
            description = " Assigned as TEST-NET-3, documentation and examples. Address Block = 203.0.113.0/24";
            return true;
        }
        else if(first >= 224 && first <= 239){
            description = "In use for IP multicast. (Former Class D network). Address Block = 224.0.0.0/4";
            return true;
        }
        else if(first == 255 && first == second && second == third && third == fourth){
            description = "Reserved for future use. (Former Class E network). Address Block = 240.0.0.0/4";
            return true;
        }
        else if(first >= 240 && first <= 255){
            description = "Reserved for the limited broadcast destination address. Address Block = 255.255.255.255/32";
            return true;
        }

        return false;
    }

    public static void SubnetCalculator(){
        System.out.print("Input IP Address: ");
        String ip_add = input.next();
        System.out.print("Input number of networks: ");
        int num_network = input.nextInt();
        
        for(int x=0; x<num_network; x++){
            System.out.print("Input the name of network " + (x+1) + ": ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Input the number of IP Addresses needed: ");
            int num_ip = input.nextInt();
        }
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

        if((first < 0 || first > 255) || (second < 0 && second > 255) || (third < 0 && third > 255) || (fourth < 0 && fourth > 255)){
            System.out.println("Error: Invalid IP Address.");
        }
        else if(SpecialIpAddress(first, second, third, fourth)){
            System.out.println("The IP Address " + ip_add + " is a Special Purpose Address. " + description);
        }
        else if(first >= 0 && first <= 127){
            System.out.println("The IP Address " + ip_add + " is a Class A Address, whose network address is " + first + ".0.0.0/8");
        }
        else if(first >= 128 && first <= 191){
            System.out.println("The IP Address " + ip_add + " is a Class B Address, whose network address is " + first + "." + second + ".0.0/16");
        }
        else if(first >= 192 && first <= 223){
            System.out.println("The IP Address " + ip_add + " is a Class C Address, whose network address is " + first + "." + second + "." + third + ".0/24");
        }

        System.out.print("0 - Go To Menu, 1 - Input Address Type Again: ");
        int terminate = input.nextInt();
        if(terminate == 0){
            clearScreen();
            MainMenu();
        }
        else{
            clearScreen();
            AddressClass();
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
