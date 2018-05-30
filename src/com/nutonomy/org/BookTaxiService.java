package com.nutonomy.org;

import java.util.List;

/*
 * Service implementation to allocate Taxi to the customer 
 */

public class BookTaxiService {

	public Response bookTaxiForCustomer(Source source, Destination destination,
			List<TaxiDetails> taxiList) {
		Response response = new Response();
		int carId =0;
		int totalTime = 0;
		
		int destX = destination.getxCordinate();
		int destY = destination.getyCordinate();
		
		int sourceX = source.getxCordinate(); 
		int sourceY = source.getyCordinate() ;
		int souceDestinationDistance = Math.abs(destX -sourceX ) 
				+ Math.abs(destY - sourceY);
		

		for(TaxiDetails taxi : taxiList){
			int taxiX = taxi.getCurrentLocation().getxCordinate(); 
			int taxiY = taxi.getCurrentLocation().getyCordinate();
			
			if(taxi.getTaxiStatus() == "available"){
				int taxiToSourceDistance = Math.abs(sourceX -taxiX ) 
						+ Math.abs(sourceY-taxiY);
				
				int overAllTotalTime = souceDestinationDistance + taxiToSourceDistance;
						
				if(overAllTotalTime < totalTime || totalTime == 0){
					totalTime = overAllTotalTime;
					carId = taxi.getTaxiId();
				}else if(overAllTotalTime == totalTime){
					if(taxi.getTaxiId() < carId){
						carId = taxi.getTaxiId();
						totalTime = overAllTotalTime;
					}
				}
			}else{
				if(destX == taxiX && destY == taxiY){
					taxi.setTaxiStatus("available");
					taxi.setCustomerName("");
				}
			}
		}
		for (TaxiDetails taxiDetails : taxiList) {
			if(taxiDetails.getTaxiId() == carId){
				taxiDetails.setTaxiStatus("booked");
				taxiDetails.setPickup(source);
				taxiDetails.setCustomerName("customer 1");
				taxiDetails.setDrop(destination);
				taxiDetails.setTotalTime(totalTime);
				response.setCarId(carId);
				response.setTotalTime(totalTime);
			}
		}
		return response;
	}
}
