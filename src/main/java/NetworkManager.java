import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkManager {
    private Map<String, Network> networks = new HashMap<>();
    private List<Phone> phones = new ArrayList<>();

    private static NetworkManager networkManager = new NetworkManager();

    public static NetworkManager getInstance() {
        return networkManager;
    }

    private NetworkManager() {

    }

    public void initialize() {
        initializeNetworks();
        initializePhones();
        registerPhones();
    }

    private void initializeNetworks() {
        Network kyivstarNetwork = new Network(NetworkName.Kyivstar.getNetworkId(), NetworkName.Kyivstar.getNetworkName(), networkManager);
        Network lifcellNetwork = new Network(NetworkName.Lifecell.getNetworkId(), NetworkName.Lifecell.getNetworkName(), networkManager);
        Network vodafonNetwork = new Network(NetworkName.Vodafon.getNetworkId(), NetworkName.Vodafon.getNetworkName(), networkManager);
        networks.put(kyivstarNetwork.getNetworkId(), kyivstarNetwork);
        networks.put(lifcellNetwork.getNetworkId(), lifcellNetwork);
        networks.put(vodafonNetwork.getNetworkId(), vodafonNetwork);
    }

    private void initializePhones() {
        phones.add(new Phone("+38(067) 111-11-11", networks.get(getNetworkIdFromPhoneNumber("+38(067) 111-11-11"))));
        phones.add(new Phone("+38(067) 222-22-22", networks.get(getNetworkIdFromPhoneNumber("+38(067) 222-22-22"))));
        phones.add(new Phone("+38(067) 333-33-33", networks.get(getNetworkIdFromPhoneNumber("+38(067) 333-33-33"))));
        phones.add(new Phone("+38(063) 111-11-11", networks.get(getNetworkIdFromPhoneNumber("+38(063) 111-11-11"))));
        phones.add(new Phone("+38(063) 222-22-22", networks.get(getNetworkIdFromPhoneNumber("+38(063) 222-22-22"))));
        phones.add(new Phone("+38(063) 333-33-33", networks.get(getNetworkIdFromPhoneNumber("+38(063) 333-33-33"))));
        phones.add(new Phone("+38(050) 111-11-11", networks.get(getNetworkIdFromPhoneNumber("+38(050) 111-11-11"))));
        phones.add(new Phone("+38(050) 222-22-22", networks.get(getNetworkIdFromPhoneNumber("+38(050) 222-22-22"))));
        phones.add(new Phone("+38(050) 333-33-33", networks.get(getNetworkIdFromPhoneNumber("+38(050) 333-33-33"))));
    }

    private void registerPhones() {
        int i = 1;
        for (Phone element : phones) {
            if (i % 3 != 0) element.register();
            i++;
        }
    }

    public List<Phone> getAllPhones() {
        return phones;
    }

    public String getNetworkIdFromPhoneNumber(String phoneNumber) {
        return phoneNumber.substring(3, 8);
    }

    public boolean isRegisterInAnyNetworks(String phoneNumber) {
        String networkId = getNetworkIdFromPhoneNumber(phoneNumber);
        boolean isRegister = false;
        if (networks.containsKey(networkId)) {
            isRegister = networks.get(networkId).isRegister(phoneNumber);
        }
        return isRegister;
    }

    public void doCall(String outgoingPhoneNumber, String incomingPhoneNumber) {
        String networkId = getNetworkIdFromPhoneNumber(incomingPhoneNumber);
        networks.get(networkId).getPhones().get(incomingPhoneNumber).incomingCall(outgoingPhoneNumber);
    }
}
