package mainPackage;

import java.io.IOException;
import java.util.List;

import bean.CityBean;
import bean.TeamBean;

import com.opensymphony.xwork2.ActionSupport;

import dataPull.TeamAndCity;

public class TeamDropdown extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public CityBean cityBean;
	public TeamBean teamBean;


	public CityBean getCityBean() {
		return cityBean;
	}


	public void setCityBean(CityBean cityBean) {
		this.cityBean = cityBean;
	}


	public TeamBean getTeamBean() {
		return teamBean;
	}


	public void setTeamBean(TeamBean teamBean) {
		this.teamBean = teamBean;
	}

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
		try{
			System.out.println("In team Drop down");
			//System.out.println("Selected team "+teamBean.getTeam());
			System.out.println("getCity "+cityBean.getCity());
			System.out.println("selectedCity "+cityBean.getSelectedCity());

			@SuppressWarnings("unused")
			String selectedCit=cityBean.getCity();
			TeamAndCity teamAndCity = new TeamAndCity();
			cityArrayString=teamAndCity.getCityDataFronAPI(cityArrayString);
			teamArrayString=teamAndCity.getTeamDataBasedOnCity(teamArrayString,cityBean.getSelectedCity());
			return SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}
