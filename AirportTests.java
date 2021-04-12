// --== CS400 File Header Information ==--
// Name: Brendan Boyle
// Email: bwboyle@wisc.edu
// Team: DD
// Role: Data Wrangler
// TA: Dan
// Lecturer: Gary
// Notes to Grader: N/A

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class AirportTests {

	/**
	 * Tests getter method for both longitude and latitude
	 */
    @Test
    public void testAirportGetLongitudeLatitude() {

    	try {

            FileReader fr = new FileReader(new File("airports.csv"));

    		List<Airport> airports = new AirportReader().readDataSet(fr); 
        	
    		Airport a = airports.get(0);

			// Tests the getter methods
            assertEquals(61.17432028, a.getLatitude());
            assertEquals(-149.9961856, a.getLongitude());
            
    	} catch (Exception e) {
    		fail("Error reading data"); // If data fails to load, test fails
    	}
        
        
    }

	/**
	 * Tests the getAirports() method
	 */
    @Test
    public void testAirportGetAirports() {
    	
    	try {
            FileReader fr = new FileReader(new File("airports.csv"));

    		List<Airport> airports = new AirportReader().readDataSet(fr); 

			// No connecting Airports
			assertEquals(true, airports.get(0).getAirports().isEmpty());

			// One connecting Airport
			assertEquals(1, airports.get(4).getAirports().size());

			// Multiple connecting Airports
			assertEquals(49, airports.get(1).getAirports().size());
            
    	} catch (Exception e) {
    		fail("Error reading data"); // If data fails to load, test fails
    	}

        
    } 
	
	/**
	 * Tests the findDistance() method
	 */
    @Test
    public void testAirportFindDistance() {
    	
    	try {
            FileReader fr = new FileReader(new File("airports.csv"));

    		List<Airport> airports = new AirportReader().readDataSet(fr); 
    		
    		Airport a = airports.get(0);
        	
    		// Distance to same airport should be 0
    		assertEquals(0, a.findDistance(a));

    		// Distance to other airport
    		assertEquals(3410, a.findDistance(airports.get(1)));
            
    	} catch (Exception e) {
    		fail("Error reading data"); // If data fails to load, test fails
    	}

        
    }
}
