package com.nutonomy.org;

import java.util.List;

import org.json.JSONObject;

public class BookTaxiApplication {

	public static void main(String[] args) {
		Source source = new Source();
		Destination destination = new Destination();
		
		source.setxCordinate(5);
		source.setyCordinate(5);
		
		destination.setxCordinate(8);
		destination.setyCordinate(8);
		
		BookTaxiResource resource = new BookTaxiResource();
		JSONObject response  = resource.bookTaxi(source, destination);
		System.out.println(response);
		
		ResetTaxiStatus reset = new ResetTaxiStatus();
		List<TaxiDetails> list = reset.resetTaxiStatus();
		
		for (TaxiDetails taxiDetails : list) {
			System.out.println(taxiDetails.getTaxiId());
			System.out.println(taxiDetails.getTaxiStatus());
		}
	}
}
