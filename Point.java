/* *****************************************************************************
 *  Name: Point
 *  Date: 2018/10/23
 *  Description: Point class represent point in percolation system
 **************************************************************************** */

public class Point {

    private int x;
    private int y;
    private int root = 0;
    private boolean isOpen = false;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Point root() {

    }

    public void union(Point x, Point y) {

    }

    public static void main(String[] args) {

    }
}