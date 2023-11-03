class LinearEquation {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    private String cord1;

    private String cord2;
    private double yInter;

    private double slope;

    private double denom;
    private double numer;

    private String slopeDefiner = "normal";

    public LinearEquation(String cord1, String cord2) {
        this.cord1 = cord1;
        this.cord2 = cord2;

        String temp1 = cord1.substring(1, cord1.indexOf(','));
        String temp2 = cord1.substring(cord1.indexOf(',') + 1, cord1.indexOf(')'));

        String temp3 = cord2.substring(1, cord2.indexOf(','));
        String temp4 = cord2.substring(cord2.indexOf(',') + 1, cord2.indexOf(')'));

        x1 = (int) ((Integer.parseInt(temp1) * 100) + 0.5) / 100.0;
        y1 = (int) ((Integer.parseInt(temp1) * 100) + 0.5) / 100.0;
        x2 = (int) ((Integer.parseInt(temp1) * 100) + 0.5) / 100.0;
        y2 = (int) ((Integer.parseInt(temp1) * 100) + 0.5) / 100.0;

        denom = (x2 - x1);
        numer = (y2 - y1);
    }

    public double getSlope() {
        slope = (double) (y2 - y1) / (x2 - x1);
        return slope;
    }

    public double getYInter() {
        yInter = y1 - slope * x1;
        return yInter;
    }

    public double distanceBetween() {
        double aSquared = denom * denom;
        double bSquared = numer * numer;
        double csquared = aSquared + bSquared;
        return (int) ((Math.sqrt(csquared) * 100) + 0.5) / 100.0;
    }

    public String getM() {
        return numer + "/" + denom;
    }

    public String theEquation(double x) {
        if (x1 != x2 && y1 != y2){
            double y = slope * x + yInter;
            return "(" + x + "," + y + ")";
        }
        else if (x1 == x2 && y1 != y2){
            return "(-inf, -inf) all real values";
        }
        else if (x1 != x2 && y1 == y2){
            return "" + y1 + "";
        }
        else{
            return "only one point given, no line found.";
        }

    }
    public String lineInfo() {
        if (x1 != x2 && y1 != y2){
            return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"
                    + "The equation of the line between these points is: y = " + getM() + "x + " + getYInter() + "\n"
                    + "The slope of this line is: " + getSlope() + "\n"
                    + "The y-intercept of this line is: " + getYInter() + "\n"
                    + "The distance between these points is " + distanceBetween();
        }
        else{

            if (x1 != x2 && y1 == y2){
                return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"
                        + "The equation of the line between these points is: y = " + y2 + "\n"
                        + "The slope of this line is: 0 a horizontal line has no slope \n"
                        + "The y-intercept of this line is: " + getYInter() + "\n"
                        + "The distance between these points is " + distanceBetween();
            }
            if (x1 == x2 && y1 != y2){
                return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"
                        + "The equation of the line between these points is: y = " + x2 + "\n"
                        + "The slope of this line is: " + getSlope() + "\n"
                        + "The y-intercept of this line is: A vertical line has no y-intercept \n"
                        + "The distance between these points is " + distanceBetween();
            }
            if (x1 == x2 && y1 == y2){
                return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"
                        + "the points are the same thus there is no slope or y intercept";
            }
            else{
                return "null";
            }
        }
    }
}
