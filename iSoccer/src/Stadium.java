public class Stadium extends Resource {
    private int capacity, numberToilets, numberSnacks;

    public Stadium(boolean available, int capacity, int numberToilets, int numberSnacks) {
        super(available);
        this.capacity = capacity;
        this.numberToilets = numberToilets;
        this.numberSnacks = numberSnacks;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberToilets() {
        return numberToilets;
    }

    public void setNumberToilets(int numberToilets) {
        this.numberToilets = numberToilets;
    }

    public int getNumberSnacks() {
        return numberSnacks;
    }

    public void setNumberSnacks(int numberSnacks) {
        this.numberSnacks = numberSnacks;
    }

    @Override
    public String toString() {
        return "Capacity: " + capacity + "; Number of cafeterias: " + numberSnacks + "; Number of toilets: " + numberToilets +"\n";

    }
}
