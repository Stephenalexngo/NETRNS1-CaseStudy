import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String description = "";

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static int log2(int n){ 
        int result = (int) Math.ceil(Math.log(n) / Math.log(2));
        return result; 
    } 

    public static String calcSubnet(int prefix){
        String result = "";
        String[] octets = new String[4];
        int counter = prefix;

        for(int x = 0; x < 4; x++){
            octets[x] = "";
            for(int y = 0; y < 8; y++){
                if(counter == 0){
                    octets[x] += '0';
                }else{
                    octets[x] += '1';
                    counter--;
                }
            }
            int decimal = Integer.parseInt(octets[x], 2);
            octets[x] = Integer.toString(decimal) + ".";
        }

        octets[3] = octets[3].replace(".", "");

        for(int x = 0; x < 4; x++){
            result += octets[x];
        }
        
        return result;
    }

    public static String calcNetwork(String ipaddress, int CIDR){
        String[] tempIP;
        int num;
        String numBinary;
        String finalIP;
        String [] tempFinal;
        String tempPlus = "";

        tempIP = ipaddress.split("\\.");
        num = (int) Math.pow(2, 32 - CIDR);
        numBinary = Integer.toBinaryString(num);

        for(int x = 0; x < 4; x++){
            tempIP[x] = Integer.toBinaryString(Integer.parseInt(tempIP[x]));
            while(tempIP[x].length() != 8){
                tempIP[x] = 0 + tempIP[x];
            }
            tempPlus += tempIP[x];
        }

        finalIP = addBinary(tempPlus, numBinary);
        finalIP = insertString(finalIP, ".", 7);
        finalIP = insertString(finalIP, ".", 16);
        finalIP = insertString(finalIP, ".", 25);

        tempFinal = finalIP.split("\\.");
        finalIP = "";

        for(int x = 0; x < 4; x++){
            tempFinal[x] = Integer.toString(Integer.parseInt(tempFinal[x], 2));
            finalIP += tempFinal[x] + ".";
        }

        
        finalIP = finalIP.replaceFirst(".$","");

        return finalIP;

    }

    public static String addBinary(String first, String second){  
        String result = "";  
        int temp = 0;          
        int x = first.length() - 1; 
        int y = second.length() - 1; 

        while (x >= 0 || y >= 0 || temp == 1){ 
            temp += ((x >= 0)? first.charAt(x) - '0': 0); 
            temp += ((y >= 0)? second.charAt(y) - '0': 0); 

            result = (char)(temp % 2 + '0') + result; 
            temp /= 2;
            x--; 
            y--; 
        } 
          
        return result; 
    } 

    public static String insertString(String mainstring, String extendedstring, int counter){ 
        String newstring = new String(); 
  
        for (int i = 0; i < mainstring.length(); i++) { 
            newstring += mainstring.charAt(i); 
            if(i == counter)
                newstring += extendedstring; 
        }
        return newstring; 
    }
    
    public static String calcFirst(String ipaddress){
        String[] octets = ipaddress.split("\\.");
        String tempPlus = "";
        String result;
        String[] tempFinal;

        for(int x = 0; x < 4; x++){
            octets[x] = Integer.toBinaryString(Integer.parseInt(octets[x]));    
            while(octets[x].length() != 8){
                octets[x] = 0 + octets[x];
            }
            tempPlus += octets[x];        
        }
        
        result = addBinary(tempPlus, "1");
        result = insertString(result, ".", 7);
        result = insertString(result, ".", 16);
        result = insertString(result, ".", 25);
        tempFinal = result.split("\\.");
        result = "";

        for(int x = 0; x < 4; x++){
            tempFinal[x] = Integer.toString(Integer.parseInt(tempFinal[x], 2));
            result += tempFinal[x] + ".";
        }
        result = result.replaceFirst(".$","");

        return result;
    }

    public static String calcLast(String ipaddress, int CIDR){
        String[] tempIP;
        int num;
        String numBinary;
        String finalIP;
        String [] tempFinal;
        String tempPlus = "";

        tempIP = ipaddress.split("\\.");

        num = (int) Math.pow(2, 32 - CIDR);
        numBinary = Integer.toBinaryString(num - 2);

        for(int x = 0; x < 4; x++){
            tempIP[x] = Integer.toBinaryString(Integer.parseInt(tempIP[x]));
            while(tempIP[x].length() != 8){
                tempIP[x] = 0 + tempIP[x];
            }
            tempPlus += tempIP[x];
        }

        finalIP = addBinary(tempPlus, numBinary);
        finalIP = insertString(finalIP, ".", 7);
        finalIP = insertString(finalIP, ".", 16);
        finalIP = insertString(finalIP, ".", 25);
        tempFinal = finalIP.split("\\.");
        finalIP = "";

        for(int x = 0; x < 4; x++){
            tempFinal[x] = Integer.toString(Integer.parseInt(tempFinal[x], 2));
            finalIP += tempFinal[x] + ".";
        }
        finalIP = finalIP.replaceFirst(".$","");

        return finalIP;
    }

    public static String calcBroad(String ipaddress, int CIDR){
        String[] tempIP;
        int num;
        String numBinary;
        String finalIP;
        String [] tempFinal;
        String tempPlus = "";

        tempIP = ipaddress.split("\\.");

        num = (int) Math.pow(2, 32 - CIDR);
        numBinary = Integer.toBinaryString(num - 1);

        for(int x = 0; x < 4; x++){
            tempIP[x] = Integer.toBinaryString(Integer.parseInt(tempIP[x]));
            while(tempIP[x].length() != 8){
                tempIP[x] = 0 + tempIP[x];
            }
            tempPlus += tempIP[x];
        }

        finalIP = addBinary(tempPlus, numBinary);
        finalIP = insertString(finalIP, ".", 7);
        finalIP = insertString(finalIP, ".", 16);
        finalIP = insertString(finalIP, ".", 25);
        tempFinal = finalIP.split("\\.");
        finalIP = "";

        for(int x = 0; x < 4; x++){
            tempFinal[x] = Integer.toString(Integer.parseInt(tempFinal[x], 2));
            finalIP += tempFinal[x] + ".";
        }
        finalIP = finalIP.replaceFirst(".$","");

        return finalIP;
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
        IpAddress ipAddress;
        ArrayList<Network> arrnetwork = new ArrayList<Network>();
        int numofnet = 0;
        int counter = 0;

        System.out.print("Input IP Address: ");
        ipAddress = new IpAddress(input.next());
        System.out.print("Input number of networks: ");
        numofnet = input.nextInt();
        
        while(counter != numofnet){
            System.out.print("Input the name of network " + (counter+1) + ": ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Input the number of IP Addresses needed: ");
            int num_ip = input.nextInt();
            arrnetwork.add(new Network(name, num_ip));

            counter++;
        }

        counter = 0;

        Collections.sort(arrnetwork);

        System.out.println("Network Information");
        System.out.println("ID\tNetwork Name\tNetwork Address\tSubnet Mask\t Prefix Length");

        String networkAdd = ipAddress.getIP();
        
        while(counter != numofnet){
            String subnetMask = "";
            String pref = "";
            int CIDR = 32 - log2(arrnetwork.get(counter).numofnetwork + 2);

            subnetMask = calcSubnet(CIDR);
            pref = "/" + Integer.toString(CIDR);

            System.out.println((counter+1) + "\t" + arrnetwork.get(counter).name + "\t" + networkAdd + "\t" + subnetMask + "\t" + pref);

            networkAdd = calcNetwork(networkAdd, CIDR);
            counter++;
        }

        counter = 0;

        System.out.println("\n");
        System.out.println("Address Information");
        System.out.println("ID\tFirst Usable Addr\tLast Usable Addr\tBroadcast Address\tUsable IPs  Free IPs");

        networkAdd = ipAddress.getIP();

        while(counter != numofnet){
            int CIDR = 32 - log2(arrnetwork.get(counter).numofnetwork + 2);
            String firstUsable = calcFirst(networkAdd);
            String lastUsable = calcLast(networkAdd, CIDR);
            String broadCast = calcBroad(networkAdd, CIDR);

            System.out.println((counter+1) + "\t" + firstUsable + "\t\t" + lastUsable + "\t\t" + broadCast);

            networkAdd = calcNetwork(networkAdd, CIDR);
            counter++;
        }

        System.out.print("0 - Go To Menu, 1 - Input Address Type Again: ");
        int terminate = input.nextInt();
        if(terminate == 0){
            clearScreen();
            MainMenu();
        }
        else{
            clearScreen();
            SubnetCalculator();
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
