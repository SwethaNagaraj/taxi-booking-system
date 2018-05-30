package com.nutonomy.org;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api("book")
@Path("/book")
public class BookTaxiResource {
    
private static final Logger logger = LoggerFactory.getLogger(BookTaxiResource.class);
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation("Confirms Taxi Booking")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Taxi is Booked",
                    response = TaxiDetails.class),
            @ApiResponse(code = 400, message = "Invalid data supplied")})
    public JSONObject bookTaxi(@ApiParam("Source and Destination Info")
    @Valid Source source, @Valid Destination destination){
        logger.info("Entering Class : bookTaxi");
        if(source == null && destination == null) {
            logger.error("Insufficient Information");
        }
        JSONObject jsonObject = new JSONObject();
        BookTaxiService service = getService();
        
        try{
        	List<TaxiDetails> taxiList = getTaxiList();
        	Response response = service.bookTaxiForCustomer(source, destination, taxiList);
        	jsonObject.append("car_id", response.getCarId());
        	jsonObject.append("total_time", response.getTotalTime());
        } catch (IllegalArgumentException e) {
            logger.error("Got exception" + e.getMessage());
        } 
        logger.info("Exiting Class : bookTaxi");
        return jsonObject;
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
    
    private BookTaxiService getService() {
        return new BookTaxiService();
    }

}

