package mainPackage;


import java.util.ArrayList;
import java.util.List;

import bean.CityBean;
import bean.TeamBean;
import bean.VenueBean;

import com.opensymphony.xwork2.ActionSupport;

import dataPull.ListOfVenues;

public class ThirdPage extends ActionSupport {

	private static final long serialVersionUID = 1L;


	public VenueBean venueBean;
	public CityBean cityBean;
	public TeamBean teamBean;

	private List<String> venueArrayString;
	//	private List<Object> venueArrayString1;

	public List<String> getVenueArrayString() {
		return venueArrayString;
	}


	public void setVenueArrayString(List<String> venueArrayString) {
		this.venueArrayString = venueArrayString;
	}


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


	public VenueBean getVenueBean() {
		return venueBean;
	}


	public void setVenueBean(VenueBean venueBean) {
		this.venueBean = venueBean;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<VenueBean> alVenue=new ArrayList();


	public ArrayList<VenueBean> getAlVenue() {
		return alVenue;
	}


	public void setAlVenue(ArrayList<VenueBean> alVenue) {
		this.alVenue = alVenue;
	}


	public String execute(){
		try{
			System.out.println("city Type: "+cityBean.getSelectedCity());
			System.out.println("Venue Type: "+venueBean.getVenueType());
			System.out.println("Team type: "+teamBean.getTeam());
			if(teamBean.getTeam().length()<=0){
				String s=cityBean.getSelectedCity()+"  |  "+ venueBean.getVenueType();
				cityBean.setSecondPageHeader(s);
			}
			else{
				String s=cityBean.getSelectedCity()+"  |  "+teamBean.getTeam()+"  |  "+ venueBean.getVenueType();
				cityBean.setSecondPageHeader(s);
			}
			ListOfVenues venues= new ListOfVenues();
			if(teamBean.getTeam().length()>0){
				alVenue=venues.getVenuesWithTeam(venueBean.getVenueType(), cityBean.getSelectedCity(), teamBean.getTeam());
			}
			else{
				alVenue=venues.getVenuesWithoutTeam(venueBean.getVenueType(), cityBean.getSelectedCity());

			}
			//System.out.println(venueArrayString);

			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}