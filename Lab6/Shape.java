package Lab6;

public abstract class Shape {
    protected Integer l;

    public Shape(Integer l) {
        this.l = 1;
    }

    public abstract Double area();
    public abstract Integer perimeter();

    public void desen() {
        System.out.println("Area of shape" + area());
        System.out.println("Perimeter shape" + perimeter());
    }

    public static void afisareaCeva() {
        System.out.println("Ceva");
    }

    public abstract void methodExample();
}
