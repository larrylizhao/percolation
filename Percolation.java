/* *****************************************************************************
 *  Name: Percolation
 *  Date: 2018/10/23
 *  Description: This is a percolation class that simulate the percolation system
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] openPoint;
    private int dimension;
    private WeightedQuickUnionUF percoSystem;

    private int map2Dto1D(int x, int y) {
        return dimension * x + y;
    }

    private void checkBounds(int x, int y) {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            throw new IndexOutOfBoundsException();
        }
    }

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.dimension = n;
        openPoint = new boolean[n * n + 2];
        percoSystem = new WeightedQuickUnionUF(n * n);
        for (int i = 0; i < openPoint.length; i++) {
            openPoint[i] = false;
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            openPoint[map2Dto1D(row, col)] = true;
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBounds(row, col);
        int index = map2Dto1D(row, col);
        return openPoint[index];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {

    }


    // number of open sites
    public int numberOfOpenSites() {
        int openSites = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (isOpen(i, j)) {
                    openSites++;
                }
            }
        }
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {

    }

    public static void main(String[] args) {

    }
}
