package com.blackslate.jackson;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException
    {	
    	test_serialize_person();
    	System.out.println();
    	
    	test_deserialize_person();
    	System.out.println();
    	
    	test_serialize_user();
    	System.out.println();
    	
    	test_employee_map();
    	System.out.println();
    	
    	test_user_record();
    	System.out.println();
    	
    	test_getter_setter();
    	System.out.println();
    }
    
    public static void test_serialize_person() throws JsonProcessingException {
    	
    	// Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a Person object
        Person person = new Person();
        person.setName("Jane Smith");
        person.setPassword("password");
        person.setBirthDate(Date.from(Instant.now()));
        person.setAge(28);
        

        // Convert Person object to JSON
        String json = objectMapper.writeValueAsString(person);
        System.out.println("JSON: " + json);
    	
    }
    
    public static void test_deserialize_person() throws JsonMappingException, JsonProcessingException {
    	
    	  // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON to Java
        String json = "{\"full_name\":\"Jane Smith\",\"age\":28, \"birthDate\":\"2024-04-25T10:04\"}";
        Person person = objectMapper.readValue(json, Person.class);

        // Print Java object
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Date: " + person.getBirthDate());
    }
    
    
	public static void test_serialize_user() throws JsonProcessingException {
		
		String cert = "{\"course\":\"Spring Boot Advanced\",\"score\":76, \"completedDate\":\"2024-04-25 10:04\"}";
    	
    	// Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a User object
        User user = new User();
        user.setId("1");
        user.setName("Jai");
        user.setLastName("Gates");
        user.setEmail("jai@exmaple.com");
        user.setAge(25);
        user.setCertificate(cert);

        // Convert Person object to JSON
        String json = objectMapper.writeValueAsString(user);
        System.out.println("JSON: " + json);
    	
    }
	
	public static void test_employee_map() throws JsonProcessingException {
		
		Map<String, String> employeePropMap = new HashMap<>();
		employeePropMap.put("Name",    "Jai");
		employeePropMap.put("Country", "India");
		
		EmployeeNameMap nameMap = new EmployeeNameMap("MyOrg", employeePropMap);

        // Convert Person object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String json = objectMapper.writeValueAsString(nameMap);
        System.out.println("JSON: " + json);
    	
    }
	
	public static void test_user_record() throws JsonProcessingException {
		
		UserRecord val = new UserRecord("1", "Jai", "jai.gates@example.com");
		System.out.println("val: " + val.toString());

        // Convert Person object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String json = objectMapper.writeValueAsString(val);
        System.out.println("JSON: " + json);
        
        UserRecord val2 = objectMapper.readValue(json, UserRecord.class);
        System.out.println("val: " + val2.toString());    	
    }
	
	public static void test_getter_setter() throws JsonProcessingException {
		
		Employee emp = new Employee();
		emp.setName("Jai");
		emp.setDateOfBirth("1980-01-01");

        // Convert Person object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(emp);
        System.out.println("JSON: " + json);
        
        Employee emp2 = objectMapper.readValue(json, Employee.class);
        System.out.println("val: " + emp2.toString());    	
    }
    
}
