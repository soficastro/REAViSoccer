public class TrainingCenter extends Resource {
    private int numberDorms;

    public TrainingCenter(boolean available, int numberDorms) {
        super(available);
        this.numberDorms = numberDorms;
    }

    public int getNumberDorms() {
        return numberDorms;
    }

    public void setNumberDorms(int numberDorms) {
        this.numberDorms = numberDorms;
    }
}
