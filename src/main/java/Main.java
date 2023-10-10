import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NetworkManager networkManager = NetworkManager.getInstance();
        networkManager.initialize();
        List<Phone> outgoingPhonelList = networkManager.getAllPhones();
        List<Phone> incomingPhoneList = networkManager.getAllPhones();
        for (Phone outgoingPhoneNumber : outgoingPhonelList) {
            for (Phone incomingPhoneNumber : incomingPhoneList) {
                outgoingPhoneNumber.outgoingCall(incomingPhoneNumber.getPhoneNumber());
            }
        }

    }

}
