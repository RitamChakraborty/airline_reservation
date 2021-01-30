package com.cognizant.airline_ticket_reservation_system.constant;

public class Queries {
    public static final String BOOKING_FIND_BY_FLIGHT_BOOKING_ID = "select * from booking where flight_booking_id = ?;";
    public static final String BOOKING_FIND_BY_USER_ID = "select * from booking where user_id = ?;";
    public static final String BOOKING_FIND_BY_FLIGHT_BOOKING_ID_AND_USER_ID = "select * from booking where flight_booking_id = ? and user_id = ?;";
    public static final String FLIGHT_BOOKING_FIND_BY_FLIGHT_SCHEDULED_ID_AND_DATE = "select * from flight_booking where scheduled_flight_id = ? and date = ?;";
    public static final String FLIGHT_BOOKING_UPDATE = "update flight_booking set economy_seats_available = ?, business_seats_available = ?;";
    public static final String FLIGHT_UPDATE = "update flight set airline = ?, model = ?, type = ?, economy_seats = ?, business_seats = ? where no = ?";
    public static final String PASSENGER_FIND_ALL_BY_BOOKING_ID = "select * from passenger where booking_id = ?;";
    public static final String USER_UPDATE = "update user set password = ?, name = ?, age = ?, gender = ?, email = ?, address = ?, phone = ?, secret_question = ?, answer = ? where id = ?;";
}
