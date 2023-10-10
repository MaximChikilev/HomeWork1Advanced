public class Phone {
    private String phoneNumber;
    private Network network;

    public Phone(String phoneNumber, Network network) {
        this.phoneNumber = phoneNumber;
        this.network = network;
    }

    public Phone() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", network=" + network +
                '}';
    }

    public void outgoingCall(String incomingCallNumber) {
        if (this.isRegister(this.getPhoneNumber())) {
            if (this.isRegister(incomingCallNumber)) {
                if (this.getPhoneNumber() != incomingCallNumber) {
                    network.transferIncomingCall(this.getPhoneNumber(), incomingCallNumber);
                } else System.out.println("You can't call to own number" + incomingCallNumber);
            } else
                System.out.println("The number(" + incomingCallNumber + ") you want to call is not registered");
        } else System.out.println("The number(" + this.getPhoneNumber() + ") you want to call from is not registered");
    }

    public void incomingCall(String outgoingPhoneNumber) {
        System.out.println("Phone number : " + this.phoneNumber + " received incoming call from number : " + outgoingPhoneNumber);
    }

    public void register() {
        network.register(this);
    }

    public boolean isRegister(String phoneNumber) {
        return network.isRegisterInAnyNetworks(phoneNumber);
    }
}
