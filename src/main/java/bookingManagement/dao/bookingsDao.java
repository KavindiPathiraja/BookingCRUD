package bookingManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookingManagement.model.bookings;

public class bookingsDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "webpal123";
	
	private static final String INSERT_BOOKINGS_SQL = "INSERT INTO bookings" + "  (originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_BOOKING_BY_ID = "select bookingId, originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType from bookings where bookingId =?";
	private static final String SELECT_ALL_BOOKINGS = "select * from bookings";
	private static final String DELETE_BOOKINGS_SQL = "delete from bookings where bookingId = ?;";
	private static final String UPDATE_BOOKINGS_SQL = "update bookings set originStation = ?, destinationStation = ?,noOfPassengers = ?,date = ?,preferedClass = ?,departTime = ?,paymentType = ? where bookingId = ?;";


	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	//insert
	public void insertBookings(bookings booking) throws SQLException {
		System.out.println(INSERT_BOOKINGS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKINGS_SQL)) {
			preparedStatement.setString(1, booking.getOriginStation());
			preparedStatement.setString(2, booking.getDestinationStation());
			preparedStatement.setString(3, booking.getNoOfPassengers());
			preparedStatement.setString(4, booking.getDate());
			preparedStatement.setString(5, booking.getPreferedClass());
			preparedStatement.setString(6, booking.getDepartTime());
			preparedStatement.setString(7, booking.getPaymentType());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//update
	public boolean updateBookings(bookings booking) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
			statement.setString(1, booking.getOriginStation());
			statement.setString(2, booking.getDestinationStation());
			statement.setString(3, booking.getNoOfPassengers());
			statement.setString(4, booking.getDate());
			statement.setString(5, booking.getPreferedClass());
			statement.setString(6, booking.getDepartTime());
			statement.setString(7, booking.getPaymentType());
			statement.setInt(8, booking.getBookingId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	//select by id
	public bookings selectBooking(int bookingId) {
		bookings booking = null;
		
		try (Connection connection = getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
			preparedStatement.setInt(1, bookingId);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String originStation = rs.getString("originStation");
				String destinationStation = rs.getString("destinationStation");
				String noOfPassengers = rs.getString("noOfPassengers");
				String date = rs.getString("date");
				String preferedClass = rs.getString("preferedClass");
				String departTime = rs.getString("departTime");
				String paymentType = rs.getString("paymentType");
				booking = new bookings(bookingId, originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}
	
	//select all
	public List<bookings> selectAllBookings() {
		
		List<bookings> bookings = new ArrayList<>();
		
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int bookingId = rs.getInt("bookingId");
				String originStation = rs.getString("originStation");
				String destinationStation = rs.getString("destinationStation");
				String noOfPassengers = rs.getString("noOfPassengers");
				String date = rs.getString("date");
				String preferedClass = rs.getString("preferedClass");
				String departTime = rs.getString("departTime");
				String paymentType = rs.getString("paymentType");
				
				bookings.add(new bookings(bookingId, originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType));
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		return bookings;
	}
	
	//delete
	public boolean deleteBooking(int bookingId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
			statement.setInt(1, bookingId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
}
