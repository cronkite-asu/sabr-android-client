package dataPull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bean.TeamBean;
import bean.VenueBean;

public class ListOfVenues {
	public VenueBean venueBean;
	public ArrayList<VenueBean> getVenuesWithTeam(String venueType, String cityType,
			String teamType) throws IOException {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<VenueBean> alVenue=new ArrayList();
		System.out.println("Getting Venues based on team and city both");
		String mlbTeamsUrl = "http://misericordiam.markng.co.uk:8000/api/venues/?format=jsonp";
		String jsonpTeam="";
		String mlbTeamsData="";
		BufferedReader readerTeam = null;
		try {
			URL urlTeam = new URL(mlbTeamsUrl);
			readerTeam = new BufferedReader(new InputStreamReader(urlTeam.openStream()));
			StringBuffer bufferTeam = new StringBuffer();
			int readTeam;
			char[] charsTeam = new char[1024];
			while ((readTeam = readerTeam.read(charsTeam)) != -1)
				bufferTeam.append(charsTeam, 0, readTeam); 
			jsonpTeam=bufferTeam.toString();
			mlbTeamsData = jsonpTeam.substring(jsonpTeam.indexOf("(") + 1, jsonpTeam.lastIndexOf(")"));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			if (readerTeam != null)
				readerTeam.close();
		}
		JSONParser parserTeam = new JSONParser();
		try {
			System.out.println("in json parser  getting venue based on City and team.");
			Object objTeam = parserTeam.parse(mlbTeamsData);
			JSONArray arrayTeam=(JSONArray)objTeam;
			@SuppressWarnings("rawtypes")
			Iterator iTeam = arrayTeam.iterator();
			@SuppressWarnings("unused")
			TeamBean teamBean;
			@SuppressWarnings("unused")
			ArrayList<TeamBean> teamArray= new ArrayList<TeamBean>();
			System.out.println("selected city "+cityType);
			while (iTeam.hasNext()) {
				teamBean= new TeamBean();
				JSONObject slideTeam = (JSONObject) iTeam.next();
				JSONObject j= (JSONObject) slideTeam.get("mlb_city");
				if(j.get("name").toString().equals(cityType)){
					if(slideTeam.get("mlb_team")!=null){
						JSONObject j1= (JSONObject) slideTeam.get("mlb_team");
						if(j1.get("name").toString().equals(teamType)){
							if(slideTeam.get("type")!=null){
								JSONObject j2= (JSONObject) slideTeam.get("type");
								if(j2.get("name").toString().equals(venueType)){
									String venueName = (String)slideTeam.get("name");
									String venueUrl = (String)slideTeam.get("url");
									venueBean = new VenueBean();
									venueBean.setUrl((String)slideTeam.get("url"));
									venueBean.setName((String)slideTeam.get("name"));
									venueBean.setAddress((String)slideTeam.get("address"));
									venueBean.setPhone((String)slideTeam.get("phone"));
									venueBean.setPlace((String)slideTeam.get("place"));
									venueBean.setDescription((String)slideTeam.get("description"));
									venueBean.setShort_description((String)slideTeam.get("short_description"));
									venueBean.setFoursquare_id((String)slideTeam.get("foursquare_id"));
									venueBean.setType(venueType);
									venueBean.setMlb_city(cityType);
									venueBean.setMlb_team(teamType);
									venueBean.setWeb((String)slideTeam.get("web"));
									venueBean.setImage((String)slideTeam.get("image"));
									venueBean.setTags((String)slideTeam.get("tags"));
									venueBean.setSlug((String)slideTeam.get("slug"));
									alVenue.add(venueBean);
									System.out.println("Venue Name "+venueName);
									System.out.println("Venue URL "+venueUrl);
								}
							}
						}
					}
				}
			}
			return alVenue;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}



	public VenueBean getVenueByURL(String selectedUrl, String venueType, String cityType,
			String teamType) throws IOException {

		//	@SuppressWarnings({ "unchecked", "rawtypes" })
		//	ArrayList<VenueBean> alVenueSingle=new ArrayList();

		System.out.println("Getting Venues based on URL");
		String mlbTeamsUrl = selectedUrl+"?format=jsonp";
		String jsonpTeam="";
		String mlbTeamsData="";
		BufferedReader readerTeam = null;
		try {
			URL urlTeam = new URL(mlbTeamsUrl);
			readerTeam = new BufferedReader(new InputStreamReader(urlTeam.openStream()));
			StringBuffer bufferTeam = new StringBuffer();
			int readTeam;
			char[] charsTeam = new char[1024];
			while ((readTeam = readerTeam.read(charsTeam)) != -1)
				bufferTeam.append(charsTeam, 0, readTeam); 
			jsonpTeam=bufferTeam.toString();
			mlbTeamsData = jsonpTeam.substring(jsonpTeam.indexOf("(") + 1, jsonpTeam.lastIndexOf(")"));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			if (readerTeam != null)
				readerTeam.close();
		}
		JSONParser parserTeam = new JSONParser();
		try {
			System.out.println("in json parser  getting venue based URL");
			System.out.println(mlbTeamsData);
			Object objTeam = parserTeam.parse(mlbTeamsData);
			JSONObject jsonObject = (JSONObject) objTeam;

			String venueName = (String) jsonObject.get("name");
			System.out.println(venueName);
			venueBean = new VenueBean();
			venueBean.setUrl((String)jsonObject.get("url"));
			venueBean.setName((String)jsonObject.get("name"));
			venueBean.setAddress((String)jsonObject.get("address"));
			venueBean.setPhone((String)jsonObject.get("phone"));
			venueBean.setPlace((String)jsonObject.get("place"));
			venueBean.setDescription((String)jsonObject.get("description"));
			venueBean.setShort_description((String)jsonObject.get("short_description"));
			venueBean.setFoursquare_id((String)jsonObject.get("foursquare_id"));
			venueBean.setType(venueType);
			venueBean.setMlb_city(cityType);
			venueBean.setMlb_team(teamType);
			venueBean.setWeb((String)jsonObject.get("web"));
			venueBean.setImage((String)jsonObject.get("image"));
			venueBean.setTags((String)jsonObject.get("tags"));
			venueBean.setSlug((String)jsonObject.get("slug"));
			System.out.println("Venue Name "+venueName);
			return venueBean;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}



	public ArrayList<VenueBean> getVenuesWithoutTeam(String venueType,
			String cityType) throws IOException {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<VenueBean> alVenue=new ArrayList();
		System.out.println("Getting Venues based on team and city both");
		String mlbTeamsUrl = "http://misericordiam.markng.co.uk:8000/api/venues/?format=jsonp";
		String jsonpTeam="";
		String mlbTeamsData="";
		BufferedReader readerTeam = null;
		try {
			URL urlTeam = new URL(mlbTeamsUrl);
			readerTeam = new BufferedReader(new InputStreamReader(urlTeam.openStream()));
			StringBuffer bufferTeam = new StringBuffer();
			int readTeam;
			char[] charsTeam = new char[1024];
			while ((readTeam = readerTeam.read(charsTeam)) != -1)
				bufferTeam.append(charsTeam, 0, readTeam); 
			jsonpTeam=bufferTeam.toString();
			mlbTeamsData = jsonpTeam.substring(jsonpTeam.indexOf("(") + 1, jsonpTeam.lastIndexOf(")"));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			if (readerTeam != null)
				readerTeam.close();
		}
		JSONParser parserTeam = new JSONParser();
		try {
			System.out.println("in json parser  getting venue based on City and team.");
			Object objTeam = parserTeam.parse(mlbTeamsData);
			JSONArray arrayTeam=(JSONArray)objTeam;
			@SuppressWarnings("rawtypes")
			Iterator iTeam = arrayTeam.iterator();
			@SuppressWarnings("unused")
			TeamBean teamBean;
			@SuppressWarnings("unused")
			ArrayList<TeamBean> teamArray= new ArrayList<TeamBean>();
			System.out.println("selected city "+cityType);
			while (iTeam.hasNext()) {
				teamBean= new TeamBean();
				JSONObject slideTeam = (JSONObject) iTeam.next();
				JSONObject j= (JSONObject) slideTeam.get("mlb_city");
				if(j.get("name").toString().equals(cityType)){
					if(slideTeam.get("mlb_team")!=null){
						//						JSONObject j1= (JSONObject) slideTeam.get("mlb_team");
						//						if(j1.get("name").toString().equals(teamType)){
						if(slideTeam.get("type")!=null){
							JSONObject j2= (JSONObject) slideTeam.get("type");
							if(j2.get("name").toString().equals(venueType)){
								String venueName = (String)slideTeam.get("name");
								String venueUrl = (String)slideTeam.get("url");
								venueBean = new VenueBean();
								venueBean.setUrl((String)slideTeam.get("url"));
								venueBean.setName((String)slideTeam.get("name"));
								venueBean.setAddress((String)slideTeam.get("address"));
								venueBean.setPhone((String)slideTeam.get("phone"));
								venueBean.setPlace((String)slideTeam.get("place"));
								venueBean.setDescription((String)slideTeam.get("description"));
								venueBean.setShort_description((String)slideTeam.get("short_description"));
								venueBean.setFoursquare_id((String)slideTeam.get("foursquare_id"));
								venueBean.setType(venueType);
								venueBean.setMlb_city(cityType);
								JSONObject j1= (JSONObject) slideTeam.get("mlb_team");
								venueBean.setMlb_team(j1.get("name").toString());
								venueBean.setWeb((String)slideTeam.get("web"));
								venueBean.setImage((String)slideTeam.get("image"));
								venueBean.setTags((String)slideTeam.get("tags"));
								venueBean.setSlug((String)slideTeam.get("slug"));
								alVenue.add(venueBean);
								System.out.println("Venue Name "+venueName);
								System.out.println("Venue URL "+venueUrl);
							}
						}
					}
				}
			}
			return alVenue;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
}
