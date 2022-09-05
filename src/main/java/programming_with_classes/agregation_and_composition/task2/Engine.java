package programming_with_classes.agregation_and_composition.task2;

public class Engine {
    private double engineVol;

    public Engine(double engineVol) {
        this.engineVol = engineVol;
    }

    public double getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(double engineVol) {
        this.engineVol = engineVol;
    }

    @Override
    public String toString() {
        return engineVol + " л.";
    }
}
