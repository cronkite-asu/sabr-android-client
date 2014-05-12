package mainPackage;

import bean.CityBean;
import bean.TeamBean;
import bean.VenueBean;

import com.opensymphony.xwork2.ActionSupport;

public class SecondPage extends ActionSupport {

	private static final long serialVersionUID = 1L;


	public CityBean cityBean;
	public TeamBean teamBean;
	public VenueBean venueBean;

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


	@SuppressWarnings("unused")
	public String execute(){
		try{
			try{
//				System.out.println("myLat:"+venueBean.getMyLat());
//				System.out.println("myLong:"+venueBean.getMyLong());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("Selected team "+teamBean.getTeam());
			System.out.println("Selected city "+cityBean.getSelectedCity());
			if(teamBean.getTeam().length()<=0){
				String s=cityBean.getSelectedCity();
				cityBean.setSecondPageHeader(s);
			}
			else{
				String s=cityBean.getSelectedCity()+"  |  "+teamBean.getTeam();
				cityBean.setSecondPageHeader(s);
			}
			String selectedCity=cityBean.getSelectedCity();
			return SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
}
