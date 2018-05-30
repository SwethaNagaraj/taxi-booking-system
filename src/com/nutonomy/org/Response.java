package com.nutonomy.org;

/*
 * POJO containing Response to be sent
 */

public class Response {
	private int carId;
	private int totalTime;

	public Response() {
		carId = 1;
		totalTime = 0;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

}
