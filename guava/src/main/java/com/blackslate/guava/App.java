package com.blackslate.guava;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        testCollection();
        testJoiner();
        testFunction();
        testMultimap();
        //testPreconditions();
        testBimap();
    }
    
    public static void testCollection() {
        ImmutableList<String> names = ImmutableList.of("Alice", "Bob", "Charlie");

        // Create an immutable list
        System.out.println("Immutable list: " + names);

        // Get the first element of a list or a default value
        String firstElement = Iterables.getFirst(names, "Default");
        System.out.println("First element: " + firstElement);

        // Filter elements based on a predicate
        Iterable<String> filteredNames = Iterables.filter(names, name -> name.startsWith("A"));
        System.out.println("Filtered names: " + ImmutableList.copyOf(filteredNames));
    }
    
    public static void testPreconditions() {
        int age = -1;

        // Check a precondition, throw IllegalArgumentException if not met
        Preconditions.checkArgument(age >= 0, "Age must be non-negative");

        // Check a state, throw IllegalStateException if not met
        Preconditions.checkState(age < 120, "Age must be less than 120");

        // Check if a reference is not null, throw NullPointerException if null
        String name = null;
        Preconditions.checkNotNull(name, "Name cannot be null");
    }
    
    public static void testJoiner() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        String joinedFruits = Joiner.on(", ").join(fruits);

        System.out.println("Joined fruits: " + joinedFruits);
    }
    
    public static void testFunction() {
        Function<String, String> addPrefix = s -> "Prefix-" + s;
        Function<String, String> addSuffix = s -> s + "-Suffix";

        Function<String, String> composedFunction = Functions.compose(addPrefix, addSuffix);
        String result = composedFunction.apply("Data");

        System.out.println("Result after composition: " + result);
    }
    
    
    public static void testMultimap() {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Banana");
        myMultimap.put("Fruits", "Orange");

        System.out.println("Fruits: " + myMultimap.get("Fruits"));
    }
    
    
    public static void testBimap() {
        BiMap<String, String> biMap = HashBiMap.create();

        biMap.put("Fruits", "Apple");
        biMap.put("Fruits", "Banana");
        biMap.put("Fruits1","Apple");

        System.out.println("Fruits: " + biMap.get("Fruits"));
        System.out.println("Fruits: " + biMap.get("Fruits1"));
        
        //Inverse the Map. 
        BiMap<String, String> biMapInverse = biMap.inverse();
        
        System.out.println("Fruits: " + biMapInverse.get("Apple"));
        System.out.println("Fruits: " + biMapInverse.get("Banana"));
    }
    
}
