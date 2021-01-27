public class Network implements Comparable<Network> {
    
    public String name;
    public int numofnetwork;

    public Network(){
    }

    public Network(String name, int num){
        this.name = name;
        this.numofnetwork = num;
    }

    @Override
    public int compareTo(Network comparenet) {
        int comparenum = comparenet.numofnetwork;

        return comparenum-this.numofnetwork;
    }
}