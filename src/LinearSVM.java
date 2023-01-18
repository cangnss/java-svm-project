import java.util.Arrays;

import weka.core.Instance;
import weka.core.Instances;

public class LinearSVM {
	// LinearSVM class for training and predicting data using a linear support vector machine algorithm
	public static double[] train(Instances data, int[] labels) {
		// train method for training the data with given labels
		int n = data.numAttributes();
		double[] weights = new double[n];
		Arrays.fill(weights, 0);

		double learningRate = 0.1;
		int maxIterations = 100;

		// Iterate through the instances and update the weights based on the prediction error
		for (int iter = 0; iter < maxIterations; iter++) {
			for (int i = 0; i < data.numInstances(); i++) {
				Instance instance = data.instance(i);
				double prediction = predict(instance, weights);
				double error = labels[i] - prediction;
				for (int j = 0; j < n; j++) {
					weights[j] = weights[j] + learningRate * error * instance.value(j);
				}
			}
		}

		return weights;
	}

	public static int predict(Instance data, double[] weights) {
		// predict method for predicting the label of the given data
		double prediction = 0;
		// Calculate the dot product of the instance's attributes and the weights
		for (int i = 0; i < data.numAttributes(); i++) {
			prediction += data.value(i) * weights[i];
		}
		// Check if the dot product is greater than 0 to predict the label
		return prediction > 0 ? 1 : -1;
	}
}
