package ClassTasks.GeometricFigures;

public class Prostokat implements Figura {
    private double bokA;
    private double bokB;

    public Prostokat() {
        this.bokA = 1.0;
        this.bokB = 2.0;
    }

    public Prostokat(double bokA, double bokB) {
        this.bokA = bokA;
        this.bokB = bokB;
    }

    @Override
    public double pole() {
        return bokA * bokB;
    }

    @Override
    public double obwod() {
        return 2 * (bokA + bokB);
    }
}