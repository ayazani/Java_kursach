package Lab4;

public class Triangle {
    private final Point[] points = new Point[3];
    private double ab, ac, bc;

    Triangle(){
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i + i*i,i*3*i);
        }
        CalculatingTheSidesOfATriangle();
    }

    Triangle(Point a, Point b, Point c){
        points[0] = a;
        points[1] = b;
        points[2] = c;
        CalculatingTheSidesOfATriangle();
    }

    public Point[] getCoordinates(){
        return points;
    }

    private void CalculatingTheSidesOfATriangle(){
        ab = Math.sqrt(Math.pow(points[1].getX() - points[0].getX(), 2) + Math.pow(points[1].getY() - points[0].getY(), 2));
        ac = Math.sqrt(Math.pow(points[2].getX() - points[0].getX(), 2) + Math.pow(points[2].getY() - points[0].getY(), 2));
        bc = Math.sqrt(Math.pow(points[2].getX() - points[1].getX(), 2) + Math.pow(points[2].getY() - points[1].getY(), 2));
    }

    public double Perimeter(){
        return ab + ac + bc;
    }

    public double Area(){
        double halfPerimeter = this.Perimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - ab) * (halfPerimeter - ac) * (halfPerimeter - bc));
    }

    public Point MedianIntersectionPoint(){
        double x = (points[0].getX() + points[1].getX() + points[2].getX()) / 3;
        double y = (points[0].getY() + points[1].getY() + points[2].getY()) / 3;
        Point medianIntersectionPoint = new Point(x,y);
        return medianIntersectionPoint;
    }

    public String TriangleState(){
        String text = "";
        text += "Perimeter of a triangle = " + Perimeter() + "\n";
        text += "Area of a triangle = " + Area() + "\n";
        Point medianIntersectionPoint = MedianIntersectionPoint();
        text += "Coordinates of the median intersection point: x = " + medianIntersectionPoint.getX() +
                "; y = " + medianIntersectionPoint.getY() + "\n";

        if (Perimeter() == 0.0 || Area() == 0.0)
            text = "Triangle cannot be created!";
        return text;
    }
}