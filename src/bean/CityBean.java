package bean;

public class CityBean {
	private String city;
	private String selectedCity;
	private String secondPageHeader;
	private String selectedUrl;


	public String getSelectedUrl() {
		return selectedUrl;
	}

	public void setSelectedUrl(String selectedUrl) {
		this.selectedUrl = selectedUrl;
	}

	public String getSecondPageHeader() {
		return secondPageHeader;
	}

	public void setSecondPageHeader(String secondPageHeader) {
		this.secondPageHeader = secondPageHeader;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
