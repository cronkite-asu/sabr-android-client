package mainPackage;
import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dataPull.TeamAndCity;

public class InitialLoad extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<String> cityArrayString;
	private List<String> teamArrayString;


	public List<String> getTeamArrayString() {
		return teamArrayString;
	}


	public void setTeamArrayString(List<String> teamArrayString) {
		this.teamArrayString = teamArrayString;
	}


	public List<String> getCityArrayString() {
		return cityArrayString;
	}


	public void setCityArrayString(List<String> cityArrayString) {
		this.cityArrayString = cityArrayString;
	}


	public String execute() throws IOException{
		TeamAndCity teamAndCity = new TeamAndCity();
		try{
			cityArrayString=teamAndCity.getCityDataFronAPI(cityArrayString);
			teamArrayString=teamAndCity.getTeamDataFronAPI(teamArrayString);
			return SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}
