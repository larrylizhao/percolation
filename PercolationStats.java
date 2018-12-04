/* *****************************************************************************
 *  Name: PercolationStats
 *  Date: 2018/11/27
 *  Description: Monte Carlo simulation. To estimate the percolation threshold.
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double FACTOR = 1.96;
    private final int dimension;
    private final int repeat;
    private final double mean;
    private final double stddev;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException();
        }
        this.dimension = n;
        this.repeat = t;
        int totalGrid = n * n;
        Percolation perc = new Percolation(n);

        double[] percoRates = new double[repeat];
        for (int i = 0; i < repeat; i++) {
            int opened = 0;
            while (!perc.percolates()) {
                int x = chooseX();
                int y = chooseY();
                if (!perc.isOpen(x, y)) {
                    perc.open(x, y);
                    opened++;
                }
            }
            percoRates[i] = (double) opened / totalGrid;
        }
        this.mean = StdStats.mean(percoRates);
        this.stddev = repeat == 1 ? Double.NaN : StdStats.stddev(percoRates);
    }

    private int chooseX() {
        return StdRandom.uniform(1, dimension + 1);
    }

    private int chooseY() {
        return StdRandom.uniform(1, dimension + 1);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - FACTOR * stddev / Math.sqrt(repeat);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + FACTOR * stddev / Math.sqrt(repeat);
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percoStats = new PercolationStats(n, t);
        StdOut.printf("mean                    = %f\n", percoStats.mean());
        StdOut.printf("stddev                  = %f\n", percoStats.stddev());
        StdOut.printf("95%% confidence interval = [%f, %f]", percoStats.confidenceLo(),
                      percoStats.confidenceHi());

    }
}
