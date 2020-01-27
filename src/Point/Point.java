package Point;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Point {

    static int[][] dp = null;

    static Set<Point> set = new HashSet<Point>();

    public Point() {

    }


    public static void main(String[] args) {
        allPoint(0, 0, 10);
        allPointN(0, 0, 10);

    }

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void allPoint(int x, int y, int r) {
        if (isValid(x, y, r)) return;
        allPoint(x + 1, y, r);
        allPoint(x, y + 1, r);
    }

    private static boolean isValid(int x, int y, int r) {
        if ((x > r || y > r) && (x != 0 || y != 0)) {
            return true;
        }
        if ((x < 0 && x >= r) || (y < 0 && y >= r)) {
            return true;
        }

        double xy = Math.pow(x, 2) + Math.pow(y, 2);
        double rr = Math.pow(r, 2);

        if (xy > rr) {
            return true;
        }

        if (0 > xy) {
            return true;
        }
        if (xy == rr) {
            Point point = new Point(x, y);
            if (set.contains(point)) {
                return true;
            }
            set.add(point);
            System.out.println(point);
        }
        return false;
    }

    public static void allPointN(int x, int y, int r) {
        if (isValid(x, y, r)) return;
        allPointN(x - 1, y, r);
        allPointN(x, y - 1, r);


    }


}
