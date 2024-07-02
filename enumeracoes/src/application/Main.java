package application;

import java.time.LocalDateTime;

import entities.Order;
import entities.enums.StatusOrder;

public class Main {

	public static void main(String[] args) {
		
		Order order = new Order(1080, LocalDateTime.now(), StatusOrder.PENDING_PAYMENT);
		
		System.out.println(order);
		
		StatusOrder os1 = StatusOrder.PROCESSING;
		StatusOrder os2 = StatusOrder.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);

	}

}
