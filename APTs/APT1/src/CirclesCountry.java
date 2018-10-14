public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
        // Need to find number of circles surrounding (x1, y1) and (x2, y2)
        // How to find out if a point is inside a circle?
        // Find distance of point from center of circle, then check to see if this distance > radius;
        // If yes, point outside of circle >> move on to next circle
        // finally, check to make sure that (x1, y1) and (x2, y2) aren't inside the same circle
        int numCircle = 0;
        for (int k = 0; k < x.length; k++) {
            double length1 = Math.sqrt((Math.pow(x[k] - x1, 2)) + (Math.pow(y[k] - y1, 2)));
            double length2 = Math.sqrt((Math.pow(x[k] - x2, 2)) + (Math.pow(y[k] - y2, 2)));
            if (r[k] > length1 && r[k] < length2) {
                numCircle++;
            }
            else if (r[k] > length2 && r[k] < length1) {
                numCircle++;
            }
        }
        return numCircle;
    }
}
