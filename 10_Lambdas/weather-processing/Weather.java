public class Weather {
	private Integer day;
	private Integer reading;
	private Double temp;
	private Double precipitation;

	public Weather(Integer day, Integer reading, Double temp, Double precipitation) {
		this.day = day;
		this.reading = reading;
		this.temp = temp;
		this.precipitation = precipitation;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getReading() {
		return this.reading;
	}

	public void setReading(Integer reading) {
		this.reading = reading;
	}

	public Double getTemp() {
		return this.temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getPrecipitation() {
		return this.precipitation;
	}

	public void setPrecipitation(Double precipitation) {
		this.precipitation = precipitation;
	}

	public String toString() {
		return this.day + "," + this.reading + "," + this.temp + "," + this.precipitation;
	}
}
