public enum NetworkName {
    Kyivstar("(067)", "Kyivstar"),
    Lifecell("(063)", "Lifecell"),
    Vodafon("(050)", "Vodafon");

    private final String networkName;
    private final String networkId;

    NetworkName(String networkId, String networkName) {
        this.networkName = networkName;
        this.networkId = networkId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public String getNetworkId() {
        return networkId;
    }
}
