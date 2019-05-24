import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class Statistics {

	private double[] xArray;
	private double[] yArray;
	
public Statistics(double[] x, double[] y) {
	setxArray(x);
	setyArray(y);
}
	
public Statistics() {
	// TODO Auto-generated constructor stub
}

public String statdata()
{
	DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

	double[] values = new double[] {65, 51 , 16, 11 , 6519, 191 ,0 , 98, 19854, 1, 32};
	for (double v : values) {
	    descriptiveStatistics.addValue(v);
	}
	 
	double mean = descriptiveStatistics.getMean();
	double median = descriptiveStatistics.getPercentile(50);
	double standardDeviation = descriptiveStatistics.getStandardDeviation();
	return "Median:" + median + " Mean:" + mean + " Standard Deviation:" + standardDeviation;
}
public String Regressiondatapoint()
{
	SimpleRegression dataregression = new SimpleRegression();
	dataregression.addData(1, 1);
	dataregression.addData(5, 5);
	dataregression.addData(8, 8);
	double intercept = dataregression.getIntercept();
	double slope = dataregression.getSlope();
	double slopestde = dataregression.getSlopeStdErr();
	return "The equation for the line is: " + "y = " + slope + "x" + intercept + ". The Slope Standard Error is " + slopestde;
	
}

public String Regressionarray()
{
	SimpleRegression dataregression = new SimpleRegression();
	double[][] data = { { 1, 3 }, {2, 5 }, {3, 7 }, {4, 14 }, {5, 11 }};
	dataregression.addData(data);
	double intercept = dataregression.getIntercept();
	double slope = dataregression.getSlope();
	double slopestde = dataregression.getSlopeStdErr();
	return "The equation for the line is: " + "y = " + slope + "x" + intercept + ". The Slope Standard Error is " + slopestde;
	
}

public double correlation(double[] xArray, double[] yArray) {
	/**
	 * Computes the Pearson's product-moment correlation coefficient between two arrays.
	 *
	 * <p>Throws MathIllegalArgumentException if the arrays do not have the same length
	 * or their common length is less than 2.  Returns {@code NaN} if either of the arrays
	 * has zero variance (if one of the arrays does not contain at least two distinct
	 * values).
	 *
	 * xArray first data array
	 * yArray second data array
	 * Returns Pearson's correlation coefficient for the two arrays
	 * DimensionMismatchException if the arrays lengths do not match
	 * MathIllegalArgumentException if there is insufficient data
	 */
  SimpleRegression dataregression = new SimpleRegression();
  if (xArray.length != yArray.length) {
    throw new DimensionMismatchException(xArray.length, yArray.length);
  } else if (xArray.length < 2) {
    throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION,
                        xArray.length, 2);
  } else {
    for(int i=0; i<xArray.length; i++) {
      dataregression.addData(xArray[i], yArray[i]);
    }
    return dataregression.getR();
  }
}

public void Onettest()
{
	double alpha = 0.5;
	double[] observedvalues ={1, 2, 3};
	double mean = 2.5;
	SummaryStatistics sampleStats = new SummaryStatistics();
	for (int i = 0; i < observedvalues.length; i++) {
	    sampleStats.addValue(observedvalues[i]);
	}
	System.out.println("P Value: " + TestUtils.t(mean, observedvalues));
	TestUtils.tTest(mean, observedvalues, alpha);
	
}

public double[] getxArray() {
	return xArray;
}

public void setxArray(double[] xArray) {
	this.xArray = xArray;
}

public double[] getyArray() {
	return yArray;
}

public void setyArray(double[] yArray) {
	this.yArray = yArray;
}


}


