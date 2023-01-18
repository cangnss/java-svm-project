
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateDataset {
	public static void createDataset() {
		// Set the number of data points
		int numDataPoints = 2000;

		// Create a Random object for generating random data
		Random rand = new Random();

		try {
			// Create a FileWriter object for writing to the ARFF file
			FileWriter fileWriter = new FileWriter("2D_dataset.arff");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Write the ARFF file header
			bufferedWriter.write("@relation 2D_dataset");
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("@attribute x numeric");
			bufferedWriter.newLine();
			bufferedWriter.write("@attribute y numeric");
			bufferedWriter.newLine();
			// bufferedWriter.write("@attribute class {0,1}");
			// bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("@data");
			bufferedWriter.newLine();

			// Generate and write the data points
			for (int i = 0; i < numDataPoints; i++) {
				// Generate random values for x and y between 0 and 10
				double x = Math.round((rand.nextDouble() * 10 + 3) * 100.0) / 100.0;
				double y = Math.round((rand.nextDouble() * 10 + 3) * 100.0) / 100.0;

				bufferedWriter.write(x + "," + y);
				bufferedWriter.newLine();
			}

			// Close the BufferedWriter
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
