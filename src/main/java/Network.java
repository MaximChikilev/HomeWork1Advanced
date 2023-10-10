import java.util.HashMap;
import java.util.Map;

public class Network {
    private String networkName;
    private String networkId;
    private NetworkManager networkManager;
    private Map<String, Phone> phones = new HashMap<>();

    public Network(String networkId, String networkName, NetworkManager networkManager) {
        this.networkId = networkId;
        this.networkName = networkName;
        this.networkManager = networkManager;
    }

    public Network() {
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Network{" +
                "networkName='" + networkName + '\'' +
                ", networkId='" + networkId + '\'' +
                '}';
    }

    public boolean isRegister(String phoneNumber) {
        return phones.containsKey(phoneNumber);
    }

    public boolean isRegisterInAnyNetworks(String phoneNumber) {
        return networkManager.isRegisterInAnyNetworks(phoneNumber);
    }

    public void register(Phone phone) {
        if (!isRegister(phone.getPhoneNumber())) phones.put(phone.getPhoneNumber(), phone);
    }

    public void transferIncomingCall(String outgoingPhoneNumber, String incomingPhoneNumber) {
        networkManager.doCall(outgoingPhoneNumber, incomingPhoneNumber);
    }
}
