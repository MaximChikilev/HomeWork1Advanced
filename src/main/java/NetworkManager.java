import java.util.ArrayList;
import java.util.List;

public class NetworkManager {
    private Network[] networks = new Network[3];
    private List<Phone> phones = new ArrayList<>();

    public NetworkManager() {
        initializeNetworks();
        initializePhones();
        registerPhones();
    }

    private void initializeNetworks(){
        networks[0] = new Network(NetworkName.Kyivstar.getNetworkName());
        networks[1] = new Network(NetworkName.Lifecell.getNetworkName());
        networks[2] = new Network(NetworkName.Vodafon.getNetworkName());
    }
    private void initializePhones(){
        phones.add(new Phone("+38(067) 111-11-11",networks[0]));
        phones.add(new Phone("+38(067) 222-22-22",networks[0]));
        phones.add(new Phone("+38(067) 333-33-33",networks[0]));
        phones.add(new Phone("+38(063) 111-11-11",networks[1]));
        phones.add(new Phone("+38(063) 222-22-22",networks[1]));
        phones.add(new Phone("+38(063) 333-33-33",networks[1]));
        phones.add(new Phone("+38(050) 111-11-11",networks[2]));
        phones.add(new Phone("+38(050) 222-22-22",networks[2]));
        phones.add(new Phone("+38(050) 333-33-33",networks[2]));
    }
    private void registerPhones(){
        int i=1;
        for (Phone element:phones){
            if(i%3!=0)element.register();
            i++;
        }
    }
    public List<Phone> getAllPhones(){
        return phones;
    }
}
