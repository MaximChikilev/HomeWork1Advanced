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


    public boolean isRegister(Phone phone) {
        return phones.contains(phone);
    }

    public void register(Phone phone) {
        if (!isRegister(phone)) phones.add(phone);
    }
}
