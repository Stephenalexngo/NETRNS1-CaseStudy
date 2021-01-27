public class IpAddress {
    String[] octets;
    private String ipaddress;
    private String pref[];

    public IpAddress(){
    }

    public IpAddress(String ipadd){
        this.pref = ipadd.split("\\/");
        this.octets = pref[0].split("\\.");
        octets[3] = octets[3].replaceFirst("./$", "replacement");
        this.ipaddress = ipadd;
    }

    public String getIP(){
        String[] temp;

        temp = ipaddress.split("\\/");
        return temp[0];
    }
}