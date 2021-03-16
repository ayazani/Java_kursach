package Lab4;

//Реализовать класс треугольник.
//Методы для создания объектов. Вычисления площади, вычисления периметра, вычесления точки персечения меридиан.
//Описать свойства для получения состояния объекта
public class Lab4 {
    private int ax = 0;
    private int ay = 0;
    private int bx = 0;
    private int by = 0;
    private int cx = 0;
    private int cy = 0;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void work() {
        Point a = new Point();
        a.setPoints(ax, ay);
        Point b = new Point();
        b.setX(bx);
        b.setY(by);
        Point c = new Point(cx,cy);
        Triangle triangle = new Triangle(a,b,c);
        info = triangle.TriangleState();

    }
}