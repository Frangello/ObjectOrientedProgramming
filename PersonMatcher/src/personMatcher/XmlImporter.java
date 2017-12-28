package personMatcher;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XmlImporter implements Importer {

	@Override
	public void read(List<Person> people, String filename) {
		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Person");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					Long objectId = getLong(eElement, "ObjectId");
					String stateFileNumber = getString(eElement,"StateFileNumber");
					String socialSecurityNum =getString(eElement,"SocialSecurityNumber");
					String firstName =getString(eElement,"FirstName");
					String middleName =getString(eElement,"MiddleName");
					String lastName =getString(eElement,"LastName");
					Long birthYear = getLong(eElement, "BirthYear");
					Long birthMonth = getLong(eElement, "BirthMonth");
					Long birthDay = getLong(eElement, "BirthDay");
					String gender =getString(eElement,"Gender");
					String newBornNum =getString(eElement,"NewbornScreeningNumber");
					String isMultipleBirth =getString(eElement,"IsPartOfMultipleBirth");
					Long birthOrder = getLong(eElement, "BirthOrder");
					String birthCountry =getString(eElement,"BirthCounty");
					String motherFirstName =getString(eElement,"MotherFirstName");
					String motherMiddleName =getString(eElement,"MotherMiddleName");
					String motherLastName =getString(eElement,"MotherLasttName");
					String phone1 =getString(eElement,"Phone1");
					String phone2 =getString(eElement,"Phone2");
					
					Person p = new Person(objectId, stateFileNumber,socialSecurityNum,firstName,middleName,lastName,birthYear, 
							birthMonth,birthDay,gender,newBornNum,isMultipleBirth,birthOrder,birthCountry,motherFirstName, 
							motherMiddleName,motherLastName,phone1,phone2);
					
					people.add(p);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getString(Object eElement, String tagName) {
		String tag = ((Element) eElement).getElementsByTagName(tagName).item(0).getTextContent();
		if(tag != null)
			return tag;
		else
			return "";
	}

	@Override
	public Long getLong(Object eElement, String tagName) {
		Long tag = Long.parseLong(((Element) eElement).getElementsByTagName(tagName).item(0).getTextContent());
		if(tag != null)
			return tag;
		else
			//TODO: Why is it unnecessary? 
			return (long) 0;
	}

}
