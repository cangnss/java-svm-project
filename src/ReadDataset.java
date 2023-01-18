import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class ReadDataset {
	public static Instances readDataset() {
		try {
			// Create a new ArffLoader object for loading the ARFF file
			ArffLoader loader = new ArffLoader();
			loader.setFile(new File("2D_dataset.arff"));

			// Load the dataset
			Instances data = loader.getDataSet();

			// Set the last attribute as the class attribute
			data.setClassIndex(data.numAttributes() - 1);

			// Print the dataset
			// System.out.println(data);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
