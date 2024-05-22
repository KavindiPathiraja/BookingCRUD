package bookingManagement.model;

public class bookings {

	private int bookingId;
	private String originStation;
	private String destinationStation;
	private String noOfPassengers; 
	private String date;
	private String preferedClass;
	private String departTime;
	private String paymentType;
	
	public bookings(int bookingId, String originStation, String destinationStation, String noOfPassengers, String date,
			String preferedClass, String departTime, String paymentType) {
		super();
		this.bookingId = bookingId;
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.noOfPassengers = noOfPassengers;
		this.date = date;
		this.preferedClass = preferedClass;
		this.departTime = departTime;
		this.paymentType = paymentType;
	}

	public bookings(String originStation, String destinationStation, String noOfPassengers, String date,
			String preferedClass, String departTime, String paymentType) {
		super();
		this.originStation = originStation;
		this.destinationStation = destinationStation;
		this.noOfPassengers = noOfPassengers;
		this.date = date;
		this.preferedClass = preferedClass;
		this.departTime = departTime;
		this.paymentType = paymentType;
	}

	public int getBookingId() {
		return bookingId;
	}

	public String getOriginStation() {
		return originStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public String getNoOfPassengers() {
		return noOfPassengers;
	}

	public String getDate() {
		return date;
	}

	public String getPreferedClass() {
		return preferedClass;
	}

	public String getDepartTime() {
		return departTime;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public void setNoOfPassengers(String noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPreferedClass(String preferedClass) {
		this.preferedClass = preferedClass;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	
	
}
	
	
	