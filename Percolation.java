/* *****************************************************************************
 *  Name: Percolation
 *  Date: 2018/10/23
 *  Description: This is a percolation class that simulate the percolation system
 **************************************************************************** */

public class Percolation {

    private int[][] id;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        id = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = i + j;
            }
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {

    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {

    }


    // number of open sites
    public int numberOfOpenSites() {

    }

    // does the system percolate?
    public boolean percolates() {

    }

    public static void main(String[] args) {

    }
}
