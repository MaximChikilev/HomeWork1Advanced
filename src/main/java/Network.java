import java.util.ArrayList;
import java.util.List;

public class Network {
    private String networkName;
    private List<Phone> phones = new ArrayList<>();

    public Network(String networkName) {
        this.networkName = networkName;
    }

    public Network() {
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
    public List<Phone> getPhones(){
        return phones;
    }
}
