import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherProcessor {
	private ArrayList<Weather> readings;

	public WeatherProcessor() {
		this.readings = new ArrayList<Weather>();
	}

	public ArrayList<Weather> getReadings() {
		return this.readings;
	}

	public void addReading(Weather w) {
		this.readings.add(w);
	}

	public ArrayList<Weather> loadReadings(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				Weather w = new Weather(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
				this.readings.add(w);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return this.readings;
	}

	public ArrayList<Weather> filter(WeatherFilter criterion) {
		ArrayList<Weather> filterList = new ArrayList<Weather>();
		for (Weather w : this.readings) {
			if (criterion.check(w)) {
				filterList.add(w);
			}
		}
		return filterList;
	}
}
