package ClassTasks;

public class Samochod {
    private int vMax;
    private double paliwoWZbiorniku;
    private double zuzycieNa100km;

    public Samochod() {
        this.vMax = 180;
        this.paliwoWZbiorniku = 50.0;
        this.zuzycieNa100km = 8.5;
    }

    public Samochod(int vMax, double paliwoWZbiorniku, double zuzycieNa100km) {
        this.vMax = vMax;
        this.paliwoWZbiorniku = paliwoWZbiorniku;
        this.zuzycieNa100km = zuzycieNa100km;
    }

    public int getVMax() {
        return vMax;
    }

    public void setVMax(int vMax) {
        this.vMax = vMax;
    }

    public double getPaliwoWZbiorniku() {
        return paliwoWZbiorniku;
    }

    public void setPaliwoWZbiorniku(double paliwoWZbiorniku) {
        this.paliwoWZbiorniku = paliwoWZbiorniku;
    }

    public double getZuzycieNa100km() {
        return zuzycieNa100km;
    }

    public void setZuzycieNa100km(double zuzycieNa100km) {
        this.zuzycieNa100km = zuzycieNa100km;
    }

    public double zasieg() {
        return (paliwoWZbiorniku * 100) / zuzycieNa100km;
    }

    public double czasDojazdu(double dystans) {
        double sredniaPredkosc = 0.75 * vMax;
        return dystans / sredniaPredkosc; // czas w godzinach
    }

    public void zatankuj(double ilePaliwaZatankowano) {
        paliwoWZbiorniku += ilePaliwaZatankowano;
    }

    public void trasa(double liczbaKilometrow) {
        double zuzytePaliwo = (liczbaKilometrow * zuzycieNa100km) / 100;
        paliwoWZbiorniku -= zuzytePaliwo;
    }
}