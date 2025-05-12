package ClassTasks.GeometricFigures;

public class Kwadrat implements Figura {
    private double bok;

    public Kwadrat() {
        this.bok = 1.0;
    }

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    @Override
    public double pole() {
        return bok * bok;
    }

    @Override
    public double obwod() {
        return 4 * bok;
    }
}