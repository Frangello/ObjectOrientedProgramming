package personMatcher;

public class Person {
	private Long objectId;
	private String stateFileNumber;
	private String socialSecurityNum;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long birthYear;
	private Long birthMonth;
	private Long birthDay;
	private String gender;
	private String newBornNum;
	private String isMultipleBirth;
	private Long birthOrder;
	private String birthCountry;
	private String motherFirstName;
	private String motherMiddleName;
	private String motherLastName;
	private String phone1;
	private String phone2;
	
	public Person(Long objId, String stateNum, String SSN, String fName, String mName,
			String lName, Long bYear, Long bMonth, Long bDay, String gen, String newNum,
			String isMultBirth, Long bOrder, String bCountry, String mFName,String mMName,
			String mLName, String pho1, String pho2){
		this.objectId = objId;
		this.stateFileNumber = stateNum;
		this.socialSecurityNum = SSN;
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
		this.birthYear = bYear;
		this.birthMonth = bMonth;
		this.birthDay = bDay;
		this.gender = gen;
		this.newBornNum = newNum;
		this.isMultipleBirth = isMultBirth;
		this.birthOrder = bOrder;
		this.birthCountry = bCountry;
		this.motherFirstName = mFName;
		this.motherMiddleName = mMName;
		this.motherLastName = mLName;
		this.phone1 = pho1;
		this.phone2 = pho2;
	}

	public Long getObjectId() {
		return objectId;
	}

	public String getStateFileNumber() {
		return stateFileNumber;
	}

	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getBirthYear() {
		return birthYear;
	}

	public Long getBirthMonth() {
		return birthMonth;
	}

	public Long getBirthDay() {
		return birthDay;
	}

	public String getGender() {
		return gender;
	}

	public String getNewBornNum() {
		return newBornNum;
	}

	public String getIsMultipleBirth() {
		return isMultipleBirth;
	}

	public Long getBirthOrder() {
		return birthOrder;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public String getMotherMiddleName() {
		return motherMiddleName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

}
