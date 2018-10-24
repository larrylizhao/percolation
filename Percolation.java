/* *****************************************************************************
 *  Name: Percolation
 *  Date: 2018/10/23
 *  Description: This is a percolation class that simulate the percolation system
 **************************************************************************** */

public class Percolation {

    private int[] id;
    private int dimension;

    private int map2Dto1D(int x, int y) {
        return dimension * x + y;
    }

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.dimension = n;
        this.id = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int flattened = map2Dto1D(i, j);
                id[flattened] = flattened;
            }
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            id[row][col].open();
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return id[row][col].isOpen();
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {

    }


    // number of open sites
    public int numberOfOpenSites() {
        int openSites = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
