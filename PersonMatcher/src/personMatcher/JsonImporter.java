package personMatcher;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonImporter implements Importer {

	@Override
	public void read(List<Person> people, String filename) {
        try {
        	
        	JSONParser parser = new JSONParser();
        	JSONArray obj = (JSONArray) parser.parse(new FileReader(filename));
            
            for(int i = 0; i < obj.size(); i++){
	            JSONObject jsonObject = (JSONObject)obj.get(i);
	            
	            Long objectId =  getLong(jsonObject, "ObjectId");
				String stateFileNumber = getString(jsonObject, "StateFileNumber");
				String socialSecurityNum =getString(jsonObject, "SocialSecurityNumber");
				String firstName = getString(jsonObject, "FirstName");
				String middleName = getString(jsonObject, "MiddleName");
				String lastName = getString(jsonObject, "LastName");
				Long birthYear = getLong(jsonObject, "BirthYear");
				Long birthMonth = getLong(jsonObject, "BirthMonth");
				Long birthDay =  getLong(jsonObject, "BirthDay");
				String gender = getString(jsonObject, "Gender");
				String newBornNum = getString(jsonObject, "NewbornScreeningNumber");
				String isMultipleBirth = getString(jsonObject, "IsPartOfMultipleBirth");
				Long birthOrder =  getLong(jsonObject, "BirthOrder");
				String birthCountry = getString(jsonObject, "BirthCounty");
				String motherFirstName = getString(jsonObject, "MotherFirstName");
				String motherMiddleName = getString(jsonObject, "MotherMiddleName");
				String motherLastName = getString(jsonObject, "MotherLasttName");
				String phone1 = getString(jsonObject, "Phone1");
				String phone2 = getString(jsonObject, "Phone2");
				
				Person p = new Person(objectId, stateFileNumber,socialSecurityNum,firstName,middleName,lastName,birthYear, 
						birthMonth,birthDay,gender,newBornNum,isMultipleBirth,birthOrder,birthCountry,motherFirstName, 
						motherMiddleName,motherLastName,phone1,phone2);
				
				people.add(p);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	@Override
	public String getString(Object jsonObject, String tagName) {
		String tag = (String) ((JSONObject) jsonObject).get(tagName);
		if(tag != null)
			return tag;
		else
			return "";
	}

	@Override
	public Long getLong(Object jsonObject, String tagName) {
		Long tag = (Long) ((JSONObject) jsonObject).get(tagName);
		if(tag != null)
			return tag;
		else
			return (long) 0;
	}

}
