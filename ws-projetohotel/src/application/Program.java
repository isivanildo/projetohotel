package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkiout = sdf.parse(sc.next());
		
		if (!checkiout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservetion = new Reservation(number, checkin, checkiout);
			System.out.println("Reservation: " + reservetion);
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkiout = sdf.parse(sc.next());
			
			String erro = reservetion.updateDates(checkin, checkiout);
			if (erro != null) {
				System.out.println("Erro in reservation: " + erro);
			}
			else {
				System.out.println("Reservation: " + reservetion);
			}
									
		}
		
		sc.close();		
	}

}
