package com.nutonomy.org;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api("reset")
@Path("/reset")
public class ResetTaxiStatus {
	private static final Logger logger = LoggerFactory.getLogger(ResetTaxiStatus.class);
    
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiOperation("Reset the status of the Taxi available irrespective of booking status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All taxis are available", response = ResetTaxiStatus.class),
            @ApiResponse(code = 400, message = "Invalid data")})
    public List<TaxiDetails> resetTaxiStatus(){
    	logger.info("Entering Class : resetTaxiStatus");
    	List<TaxiDetails> taxiList = getTaxiList();
    	for(TaxiDetails taxi: taxiList){
    		Destination destination = new Destination();
    		destination.setxCordinate(0);
    		destination.setyCordinate(0);
    		
    		taxi.setCustomerName("");
    		taxi.setDrop(destination);
    		taxi.setTaxiStatus("available");
    		taxi.setTotalTime(0);
    	}
    	logger.info("Exiting Class : resetTaxiStatus");
    	return taxiList;
    }
    
    private List<TaxiDetails> getTaxiList(){
    	List<TaxiDetails> taxiList = new ArrayList<TaxiDetails>();
    	CurrentLocation location1 = new CurrentLocation();
		location1.setxCordinate(5);
		location1.setyCordinate(1);
		
		TaxiDetails taxi1 = new TaxiDetails();
		taxi1.setTaxiName("swetha");
		taxi1.setTaxiId(1);
		taxi1.setTaxiStatus("available");
		taxi1.setCurrentLocation(location1);
		
		CurrentLocation location2 = new CurrentLocation();
		location2.setxCordinate(1);
		location2.setyCordinate(0);
		
		TaxiDetails taxi2 = new TaxiDetails();
		taxi2.setTaxiName("lucky");
		taxi2.setTaxiId(2);
		taxi2.setTaxiStatus("available");
		taxi2.setCurrentLocation(location2);
		
		CurrentLocation location3 = new CurrentLocation();
		location3.setxCordinate(8);
		location3.setyCordinate(8);
		
		TaxiDetails taxi3 = new TaxiDetails();
		taxi3.setTaxiName("avika");
		taxi3.setTaxiId(3);
		taxi3.setTaxiStatus("booked");
		taxi3.setCurrentLocation(location3);
		
		taxiList.add(taxi1);
		taxiList.add(taxi2);
		taxiList.add(taxi3);
		
		return taxiList;
    }
}
