package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {

	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (!checkOut.isAfter(checkIn)) {
			// Esse meu métodos esta apenas lançando a exceção, quem trata é o programa main
			// Por esse motivo, temos que propagar o DomainException
			throw new DomainException("check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	//GETTERS E SETTERS
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	// METODOS
	public Integer duration() {
		Duration duration = Duration.between(getCheckIn().atStartOfDay(), getCheckOut().atStartOfDay());
		return (int)duration.toDays();
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
			// exceção para argumentos errados
			throw new DomainException("Reservation dates for update must be futures dates");
		}
		if (!checkOut.isAfter(checkIn)) {
			// Esse meu métodos esta apenas lançando a exceção, quem trata é o programa main
			// Por esse motivo, temos que propagar o DomainException
			throw new DomainException("check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: ");
		sb.append("Room " + roomNumber);
		sb.append(", Check-in: " + fmt.format(checkIn));
		sb.append(", Check-out: " + fmt.format(checkOut));
		sb.append(", " + duration() + " nigths.");
		return sb.toString();
	}
	
}
