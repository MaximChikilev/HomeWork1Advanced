public enum NetworkName {
    Kyivstar("Kyivstar"),
    Lifecell("Lifecell"),
    Vodafon("Vodafon");

    private final String networkName;

    NetworkName(String networkName) {
        this.networkName = networkName;
    }
    public String getNetworkName(){
        return networkName;
    }
}
