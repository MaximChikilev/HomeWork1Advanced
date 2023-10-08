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

    public void outgoingCall(Phone incomingCallNumber) {
        if (this.isRegister()) {
            if (incomingCallNumber.isRegister()) {
                if(this!=incomingCallNumber){
                incomingCallNumber.incomingCall(this);
                } else System.out.println("You can't call to own number" +incomingCallNumber.getPhoneNumber());
            } else
                System.out.println("The number(" + incomingCallNumber.getPhoneNumber() + ") you want to call is not registered");
        } else System.out.println("The number(" + this.getPhoneNumber() + ") you want to call from is not registered");
    }

    public void incomingCall(Phone outgoingPhoneNumber) {
        System.out.println("Phone number : " + this.phoneNumber + " received incoming call from number : " + outgoingPhoneNumber.getPhoneNumber());
    }

    public void register() {
        network.register(this);
    }

    public boolean isRegister() {
        return network.isRegister(this);
    }
}
