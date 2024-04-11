package com.blackslate.lombok;

import lombok.val;


public class App 
{
    public static void main( String[] args )
    {
        User user_one = new User();
        user_one.setName("test");
        user_one.setEmail("test@gmail.com");
                
        System.out.println(user.getName());
        
        User user2 = User.builder()
        				.name("Bob")
        				.email("bob@gmail.com")
        				.build();
        
        System.out.println(user2.getName());
        
        ThrowExample obj1 = new ThrowExample();
        obj1.readFromFile();
        
    }
}
