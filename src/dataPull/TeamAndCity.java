package dataPull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bean.CityBean;
import bean.TeamBean;

import java.util.Set;

public class TeamAndCity {

	public List<String> getCityDataFronAPI(List<String> cityArrayString) throws IOException{

		System.out.println("Getting Cities from API");
		String mlbCitiesUrl = "http://misericordiam.markng.co.uk:8000/api/mlb_cities/?format=jsonp";
		String jsonp="";
		String mlbCitiesData="";
		BufferedReader reader = null;
		try {
			URL url = new URL(mlbCitiesUrl);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read); 

			jsonp=buffer.toString();
			mlbCitiesData = jsonp.substring(jsonp.indexOf("(") + 1, jsonp.lastIndexOf(")"));
		} 
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			if (reader != null)
				reader.close();
		}

		JSONParser parser = new JSONParser();


		try {
			//System.out.println("in json parser");
			Object obj = parser.parse(mlbCitiesData);
			//System.out.println(obj.toString());

			JSONArray array=(JSONArray)obj;

			@SuppressWarnings("rawtypes")
			Iterator i = array.iterator();
			CityBean cityBean;

			ArrayList<CityBean> cityArray= new ArrayList<CityBean>();

			//			ArrayList<String> cityArrayString= new ArrayList<String>();



			cityArrayString = new ArrayList<String>();
			while (i.hasNext()) {
				//System.out.println("inside iter");
				cityBean= new CityBean();
				//System.out.println("inside iter22");

				JSONObject slide = (JSONObject) i.next();
				String title = (String)slide.get("name");
				//System.out.println(title);
				cityBean.setCity(title);
				cityArrayString.add(title);

				cityArray.add(cityBean);
				JSONArray venueSet = (JSONArray) slide.get("venue_set");
				@SuppressWarnings({ "unchecked", "unused" })
				Iterator<String> iterator = venueSet.iterator();
				//				while (iterator.hasNext()) {
				//					//System.out.println(iterator.next());
				//				}
			}
			System.out.println("cityArrayString "+cityArrayString);
			return cityArrayString;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getTeamDataFronAPI(List<String> teamArrayString) throws IOException {
		System.out.println("Getting Teams from API");
		String mlbTeamsUrl = "http://misericordiam.markng.co.uk:8000/api/teams/?format=jsonp";
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
			//System.out.println(jsonpTeam);
			mlbTeamsData = jsonpTeam.substring(jsonpTeam.indexOf("(") + 1, jsonpTeam.lastIndexOf(")"));
			//System.out.println(mlbTeamsData);
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
			System.out.println("in json parser Team");
			Object objTeam = parserTeam.parse(mlbTeamsData);
			//System.out.println(objTeam.toString());

			JSONArray arrayTeam=(JSONArray)objTeam;

			@SuppressWarnings("rawtypes")
			Iterator iTeam = arrayTeam.iterator();
			TeamBean teamBean;

			ArrayList<TeamBean> teamArray= new ArrayList<TeamBean>();

			//			ArrayList<String> teamArrayString= new ArrayList<String>();



			teamArrayString = new ArrayList<String>();

			while (iTeam.hasNext()) {
				//System.out.println("inside iter");
				teamBean= new TeamBean();
				//System.out.println("inside iter22");

				JSONObject slideTeam = (JSONObject) iTeam.next();
				String titleTeam = (String)slideTeam.get("name");
				//System.out.println(title);
				teamBean.setTeam(titleTeam);
				teamArrayString.add(titleTeam);

				teamArray.add(teamBean);
				//				JSONArray venueSetTeam = (JSONArray) slideTeam.get("venue_set");
				//				@SuppressWarnings("unchecked")
				//				Iterator<String> iteratorTeam = venueSetTeam.iterator();
				//				while (iteratorTeam.hasNext()) {
				//					System.out.println(iteratorTeam.next());
				//				}
			}
			System.out.println("teamArrayString "+teamArrayString);		
			return teamArrayString;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getTeamDataBasedOnCity(List<String> teamArrayString, String selectedCity) throws IOException {
		System.out.println("Getting Teams Based on Cities");
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
			//	System.out.println(jsonpTeam);
			mlbTeamsData = jsonpTeam.substring(jsonpTeam.indexOf("(") + 1, jsonpTeam.lastIndexOf(")"));
			//		System.out.println(mlbTeamsData);
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
			System.out.println("in json parser Team based on City.");
			Object objTeam = parserTeam.parse(mlbTeamsData);
			//	System.out.println("objTeam"+objTeam.toString());

			JSONArray arrayTeam=(JSONArray)objTeam;

			@SuppressWarnings("rawtypes")
			Iterator iTeam = arrayTeam.iterator();
			@SuppressWarnings("unused")
			TeamBean teamBean;
			@SuppressWarnings("unused")
			ArrayList<TeamBean> teamArray= new ArrayList<TeamBean>();
			Set<String> cityBasedTeamSet= new HashSet<String>();
			System.out.println("selected city "+selectedCity);
			while (iTeam.hasNext()) {
				teamBean= new TeamBean();
				JSONObject slideTeam = (JSONObject) iTeam.next();
				JSONObject j= (JSONObject) slideTeam.get("mlb_city");
				//	System.out.println(j.get("name").toString()+", "+selectedCity);
				if(j.get("name").toString().equals(selectedCity)){
					//System.out.println("1");
					if(slideTeam.get("mlb_team")!=null){
						JSONObject j1= (JSONObject) slideTeam.get("mlb_team");
						if(j1.get("name")!=null)
							//	System.out.println("2");
							cityBasedTeamSet.add(j1.get("name").toString());
						//System.out.println(j1.get("name").toString());
					}
				}
			}
			teamArrayString = new ArrayList<String>(cityBasedTeamSet);
			System.out.println("team based on city "+teamArrayString.toString());
			return teamArrayString;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}