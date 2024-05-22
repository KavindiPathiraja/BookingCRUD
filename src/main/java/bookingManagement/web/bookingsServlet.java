package bookingManagement.web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookingManagement.dao.bookingsDao;
import bookingManagement.model.bookings;

@WebServlet("/bookingsServlet")
public class bookingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private bookingsDao bookingsDAO;
   
    public bookingsServlet() {
        this.bookingsDAO = new bookingsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBookings(request, response);
                    break;
                case "/delete":
                    deleteBooking(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBookings(request, response);
                    break;
                default:
                    listBookings(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("booking-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertBookings(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String originStation = request.getParameter("originStation");
        String destinationStation = request.getParameter("destinationStation");
        String noOfPassengers = request.getParameter("noOfPassengers");
        String date = request.getParameter("date");
        String preferedClass = request.getParameter("preferedClass");
        String departTime = request.getParameter("departTime");
        String paymentType = request.getParameter("paymentType");

        bookings newBooking = new bookings(originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType);
        bookingsDAO.insertBookings(newBooking);
        response.sendRedirect("list");
    }
    
    private void deleteBooking(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        bookingsDAO.deleteBooking(bookingId);
        response.sendRedirect("list");
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        bookings existingBooking = bookingsDAO.selectBooking(bookingId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("booking-form.jsp");
        request.setAttribute("bookings", existingBooking);
        dispatcher.forward(request, response);
    }
    
    private void updateBookings(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        String originStation = request.getParameter("originStation");
        String destinationStation = request.getParameter("destinationStation");
        String noOfPassengers = request.getParameter("noOfPassengers");
        String date = request.getParameter("date");
        String preferedClass = request.getParameter("preferedClass");
        String departTime = request.getParameter("departTime");
        String paymentType = request.getParameter("paymentType");

        bookings booking = new bookings(bookingId, originStation, destinationStation,noOfPassengers,date,preferedClass,departTime,paymentType);
        bookingsDAO.updateBookings(booking);
        response.sendRedirect("list");
    }
    
    private void listBookings(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<bookings> listBookings = bookingsDAO.selectAllBookings();
        request.setAttribute("listBookings", listBookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("booking-list.jsp");
        dispatcher.forward(request, response);
    }
}
