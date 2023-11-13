package Lab6;

public class Triangle extends Shape {
    public Triangle(Integer l) {
        super(l);
    }
    @Override
    public Double area() {
        return (Math.sqrt(3)/4) * l * l; }

    @Override
    public Integer perimeter() { return l * 3; }

    @Override
    public void methodExample() {

    }
}
