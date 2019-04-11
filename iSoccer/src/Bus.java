public class Bus extends Resource {
    private String license;

    public Bus(boolean available, String license) {
        super(available);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
