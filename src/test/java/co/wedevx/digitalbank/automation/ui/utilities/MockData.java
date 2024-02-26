package co.wedevx.digitalbank.automation.ui.utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.*;

public class MockData {

    Faker faker = new Faker();
    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
            new RandomService());

    public Map<String, String> generateRandomNameAndEmail() {
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        //String email = fakeValuesService.bothify(name +"####@gmail.com");example of generating random email
        int RandomInt = new Random().nextInt(4);
        String email = name + RandomInt + "@gmail.com";
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("email", email);
        return data;
    }

    public String generateRandomSSN() {
        //String ssn = String.format("%09d", new Random().nextInt(10000000000));
//        OR
        String ssn = faker.idNumber().ssnValid();
        return ssn;
    }

    public static void main(String[] args) {
        MockData mockData = new MockData();
        Map<String, String> mockDataMap = mockData.generateRandomNameAndEmail();
Map<String, String>mockPasswords = mockData.generateRandomPasswordAndConfirm();
System.out.println(mockDataMap.get("name"));
System.out.println(mockDataMap.get("email"));
//        System.out.println(mockData.generateRandomSSN());
//        System.out.println(mockData.generateRandomTitle());
//        System.out.println(mockData.generateRandomLastName());
//        System.out.println(mockData.generateRandomGender());
//        System.out.println(mockData.generateRandomDOB());

        System.out.println(mockPasswords.get("password"));
        System.out.println(mockPasswords.get("confirmation"));


//        System.out.println(mockData.generateRandomStreetAddress());
//        System.out.println(mockData.generateRandomCity());
//        System.out.println(mockData.generateRandomState());
//        System.out.println(mockData.generateRandomZipCode());
//        System.out.println(mockData.generateRandomCountryCode());
//        System.out.println(mockData.generateRandomCellPhone());
    }

    public String generateRandomTitle() {
        String newTitle = faker.options().option("Mrs.", "Mr.", "Ms.");
        return newTitle;
    }

    public String generateRandomLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String generateRandomGender() {
        String newGender = faker.options().option("M", "F");
        return newGender;
    }
    public String generateRandomDOB(){
        Date dOB = faker.date().birthday();
        // Format the Date object into the desired output format
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
        String outputDateString = outputFormat.format(dOB);

        return outputDateString;
    }
    public Map<String, String> generateRandomPasswordAndConfirm(){
        String newPassword = faker.internet().password(8,16,true,true,true);
        String confirmation = newPassword;
        Map<String, String>passwordAndConfirmation = new HashMap<>();
        passwordAndConfirmation.put("password", newPassword+"A!@12");
        passwordAndConfirmation.put("confirmation", confirmation+"A!@12");
        return passwordAndConfirmation;
    }

    public String generateRandomStreetAddress(){
        String newAddress = faker.address().streetAddress();
        return newAddress;
    }
    public String generateRandomCity(){
        String newCity = faker.address().city();
        return newCity;
    }
    public String generateRandomState(){
        String newState = faker.address().stateAbbr();
        return newState;
    }
    public String generateRandomZipCode(){
        String newZipCode = faker.address().zipCode();
        return newZipCode;
    }
    public String generateRandomCountryCode(){
        String newCountryCode = faker.address().countryCode();
        return newCountryCode;
    }
    public String generateRandomCellPhone(){
        String newCellPhone = fakeValuesService.bothify("(###) ###-####");

        return newCellPhone;
    }
}
