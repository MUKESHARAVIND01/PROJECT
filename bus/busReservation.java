package bus;

import java.util.*;
import java.text.SimpleDateFormat;

//booking class
class Booking extends busReservation
{
	// nooking class instance variable 
	int busNo,seatNo;
	String name;
	Date date;
	
	//constructor
	Booking()
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.println("ENETR BUS NUMBER");
		busNo=scan.nextInt();
		
		System.out.println("ENETR USER NAME");
		name=scan.next();
		
		System.out.println("ENETR SEAT NUMBER");
		seatNo=scan.nextInt();
		
		
		System.out.println("ENETR DATE(dd-MM-yyyy)");
		 String dateInput=scan.next();  // date value get in string type
		 
		 // here used simpleDateFormate class for handle date 
		 SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
		 try
		 {
			 date=dateformat.parse(dateInput);
		 }catch(Exception e )
		 {
			 e.printStackTrace();
		 }
		 
	}
	// give bus &booking list reference in  parameter to check seat availble  
	public boolean isAvailable(ArrayList<Bus>buses,ArrayList<Booking>bookings)
	{
		//check capacity
		int capacity=0;
		for(Bus bus:buses )
		{
			// in bus class busNumber == booking class busNumber
			if(bus.busNo==busNo)
			{
				capacity=bus.capacity;
				if(seatNo>capacity)
				{
					System.out.println("sorry you are entered wrong seat number please check the seat number ");
					return false;
				}
			}
		}
		//booking method 
		int bookedseat=0;
		// creating for each loop for checks booking
		 for(Booking booked:bookings)
		 {
			 
			 if(booked.busNo==busNo && booked.date.equals(date))
			 {
				bookedseat++;
				if(booked.seatNo==seatNo)
				{
					System.out.println("sorry your seats already booked ");
					return false;
				}
			 }
		 }
		 return true;
		
	}
	
}
class Bus extends  busReservation
{
	int busNo,capacity;
	boolean ac;
	Bus(int busNo,int capacity,boolean ac)
	{
		this.busNo=busNo;
		this.capacity=capacity;
		this.ac=ac;
	}
	// bus information 
	public void busInfo()
	{
		System.out.println("busNo: "+busNo+" capacity: "+capacity+" ac :"+ ac);
	}
}
class  busReservation
{
	public static void main(String arg[])
	{
		ArrayList<Bus>buses=new ArrayList<Bus>();
		ArrayList<Booking>bookings=new ArrayList<Booking>();
		
		// adding buses in list
		buses.add(new Bus(1,2,true));
		buses.add(new Bus(2,28,true));
		buses.add(new Bus(3,30,false));
		
		// display bus info to user
		for(Bus b:buses)
		{
			b.busInfo();
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.println("user enter 1 to 'book' 2 to 'exit");
		
		int userInput=1;
		while(userInput==1)
		{
			userInput=scan.nextInt();
			if(userInput==1)
			{
				// creating object for booking class
				Booking booking=new Booking();
				// check availbilty with help of bus &booking list
				if(booking.isAvailable(buses,bookings))
				{
					//if seats availble ,add booking
					bookings.add(booking);
					System.out.println(booking.name +" your seat is booking successfully ");
				}
				
				
			}
			
		}
		
	}
}

