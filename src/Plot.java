import java.awt.Dimension;
import java.awt.EventQueue;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class Plot {
    // Method that plots data from a 2D array
    public static void plotData(double[][] dataArr) {
        // Creating a new XYSeries object and adding data points to it
        XYSeries series = new XYSeries("Data");
        for (double[] point : dataArr) {
            series.add(point[0], point[1]);
        }
        // Creating an XYDataset object using the XYSeries
        XYDataset xyDataset = new XYSeriesCollection(series);
        // Creating a scatter plot using the XYDataset and other parameters
        JFreeChart chart = ChartFactory.createScatterPlot("Data", "X-axis", "Y-axis", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 270));
        JFrame frame = new JFrame("Data Plot");
        // Adding the chart panel to the frame
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
