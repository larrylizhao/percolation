/* *****************************************************************************
 *  Name: Percolation
 *  Date: 2018/10/23
 *  Description: This is a percolation class that simulate the percolation system
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] openPoint;
    private final int dimension;
    private final int head;
    private final int tail;
    private int openSites;
    private WeightedQuickUnionUF percoSystem;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.dimension = n;
        this.head = n * n;
        this.tail = n * n + 1;
        this.openSites = 0;
        openPoint = new boolean[n * n];
        percoSystem = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 0; i < openPoint.length; i++) {
            openPoint[i] = false;
        }
    }

    // Map two dimension site to 1 dimension int, return -1 if out of bound
    // This also benefit bound check when calculating other sites next to current site
    private int map2Dto1D(int x, int y) {
        try {
            checkBounds(x, y);
        }
        catch (IllegalArgumentException e) {
            // Bypass checked exception and return -1 to indicate boundaries
            return -1;
        }
        return dimension * (x - 1) + y - 1;
    }

    // check if given index out of bound
    private void checkBounds(int x, int y) {
        if (x < 1 || y < 1 || x > dimension || y > dimension) {
            throw new IllegalArgumentException();
        }
    }

    // The site to the left of the given site
    private int left(int row, int col) {
        return map2Dto1D(row, col - 1);
    }

    // The site to the right of the given site
    private int right(int row, int col) {
        return map2Dto1D(row, col + 1);
    }

    // The site to the top of the given site
    private int top(int row, int col) {
        return map2Dto1D(row - 1, col);
    }

    // The site to the bottom of the given site
    private int bottom(int row, int col) {
        return map2Dto1D(row + 1, col);
    }

    // Use mapped dimension to check if site open
    private boolean isSiteOpen(int site) {
        return site >= 0 && site < openPoint.length && openPoint[site];
    }

    private void markOpen(int site) {
        openPoint[site] = true;
        openSites++;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int site = map2Dto1D(row, col);
            markOpen(site);
            if (isSiteOpen(left(row, col))) {
                percoSystem.union(site, left(row, col));
            }
            if (isSiteOpen(right(row, col))) {
                percoSystem.union(site, right(row, col));
            }
            if (isSiteOpen(top(row, col))) {
                percoSystem.union(site, top(row, col));
            }
            if (isSiteOpen(bottom(row, col))) {
                percoSystem.union(site, bottom(row, col));
            }
            // The open site in first row connect with head automatically
            if (row == 1) {
                percoSystem.union(site, head);
            }
            // The open site in last row connect with tail automatically
            if (row == dimension) {
                percoSystem.union(site, tail);
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = map2Dto1D(row, col);
        return openPoint[index];
    }


    // is site (row, col) full (connect to top row)?
    public boolean isFull(int row, int col) {
        return percoSystem.connected(head, map2Dto1D(row, col));
    }


    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percoSystem.connected(head, tail);
    }

    public static void main(String[] args) {

    }
}
