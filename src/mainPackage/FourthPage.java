package mainPackage;


import java.util.ArrayList;
import java.util.List;

import bean.CityBean;
import bean.TeamBean;
import bean.VenueBean;

import com.opensymphony.xwork2.ActionSupport;

import dataPull.ListOfVenues;

public class FourthPage extends ActionSupport {

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
	ArrayList<VenueBean> alVenueSingle=new ArrayList();
	

	public ArrayList<VenueBean> getAlVenue() {
		return alVenueSingle;
	}


	public void setAlVenue(ArrayList<VenueBean> alVenue) {
		this.alVenueSingle = alVenue;
	}


	public String execute(){
		try{
			System.out.println("city Type: "+cityBean.getSelectedCity());
			System.out.println("123");
			System.out.println("Venue Type: "+venueBean.getVenueType());
			System.out.println("Team type: "+teamBean.getTeam());
			System.out.println("Venue URL: "+cityBean.getSelectedUrl());
			ListOfVenues venues= new ListOfVenues();

			venueBean=venues.getVenueByURL(cityBean.getSelectedUrl() ,venueBean.getVenueType(),cityBean.getSelectedCity(),teamBean.getTeam());
			String geolocation=venueBean.getPlace();
			System.out.println(geolocation);
			String newGeo=geolocation.substring(geolocation.indexOf("(") + 1, geolocation.lastIndexOf(")"));
			System.out.println("\""+newGeo+"\"");
			String[] geo= new String[2];
			geo= newGeo.split(" ");
			//System.out.println("lat:"+geo[0]);
			venueBean.setLatitude(geo[0]);
			//System.out.println("lon:"+geo[1]);
			venueBean.setLongitude(geo[1]);
			cityBean.setSecondPageHeader(venueBean.getName());
			System.out.println("sph: "+cityBean.getSecondPageHeader());
			System.out.println("Geolocation: "+venueBean.getPlace());
		
			
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}