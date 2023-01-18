import java.awt.EventQueue;
import java.util.Random;

import weka.core.Instance;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) {
		// CreateDataset.createDataset();
		// Read the dataset from file and store it in an Instances object
		Instances data = ReadDataset.readDataset();
		LinearSVM ls = new LinearSVM();

		// Create an array to store the labels of the instances
		int[] labels = new int[data.numInstances()];
		// Iterate through the instances and assign labels based on the values of the
		// first two attributes
		for (int i = 0; i < data.numInstances(); i++) {
			if (data.instance(i).value(0) >= 5 && data.instance(i).value(1) >= 4) {
				labels[i] = 1;
				System.out.println(
						"x value: " + data.instance(i).value(0) + " y value: " + data.instance(i).value(1) + " RIPE");
			} else {
				labels[i] = -1;
				System.out.println(
						"x value: " + data.instance(i).value(0) + " y value: " + data.instance(i).value(1) + " UNRIPE");

			}
			// System.out.println("i: " + labels[i]);
		}

		// Train the linear SVM model using the data and labels
		double[] weights = ls.train(data, labels);

		// Copy the data into a 2D array for plotting
		double[][] dataArr = new double[data.numInstances()][2];
		for (int i = 0; i < data.numInstances(); i++) {
			dataArr[i][0] = data.instance(i).value(0);
			dataArr[i][1] = data.instance(i).value(1);
		}

		// Create a test instance and predict its label using the trained model
		Instance testInstance = data.instance(0);
		testInstance.setValue(0, 4);
		testInstance.setValue(1, 5);
		int prediction = ls.predict(testInstance, weights);
		System.out.println("Predicted label: " + prediction);

		// Use the EventQueue to create a new thread for plotting the data
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Plot.plotData(dataArr);
			}
		});

	}

}
