package ss.sf.pages;

import java.sql.SQLException;
import java.util.Scanner;

import ss.sf.library.DAO.PublisherDAO;

import java.util.List;

public class EditPublishers {
	public static void editPublishers(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("What would you like to do\n?"
				+ "1) Add Publisher\n2) Update Publisher \n3) Delete Publisher");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch (choice) {
			case 1:
				addPublisher(scanner);
				break;
			case 2:
				editPublisher(scanner);
				break;
			case 3:
				deletePublisher(scanner);
				break;
			default:
				
			}
		}
	}
	public static void addPublisher(Scanner scanner) throws ClassNotFoundException, SQLException {
		PublisherDAO pubDAO = new PublisherDAO();
		Publisher publisher = new Publisher();
		System.out.println("What is the Id of the publisher you would like to add?");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int pubId = scannedLine.nextInt();
			publisher.setPublisherId(pubId);
		}
		System.out.println("What is the name of the publisher you would like to add?");
		String pubName = scanner.nextLine();
		publisher.setPublisherName(pubName);
		System.out.println("What is the address of the publisher you would like to add?");
		String pubAddress= scanner.nextLine();
		publisher.setPublisherAddress(pubAddress);
		System.out.println("What is the phone of the publisher you would like to add?");
		String pubPhone= scanner.nextLine();
		publisher.setPublisherPhone(pubPhone);
		pubDAO.addPublisher(publisher);
		AdministratorPage.admin1(scanner);
		
	}
	public static void editPublisher(Scanner scanner) throws ClassNotFoundException, SQLException {
		PublisherDAO pubDAO = new PublisherDAO();
		Publisher publisher = new Publisher();
		List<Publisher> publishers = pubDAO.getPublishers();
		publishers.forEach(p -> System.out.println(publishers.indexOf(p)+1+") Name: " + p.getPublisherName()
		 	+ " Address: " + p.getPublisherAddress() + " Phone: " + p.getPublisherPhone()));
		System.out.println("Enter the publisher you would like to edit by row number");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			publisher = publishers.get(choice-1);
		}
		System.out.println("What would you like to change the publisher name to?");
		String pubName = scanner.nextLine();
		publisher.setPublisherName(pubName);
		System.out.println("What would you like to change the publisher address to?");
		String pubAddress= scanner.nextLine();
		publisher.setPublisherAddress(pubAddress);
		System.out.println("What would you like to change the publisher phone  to?");
		String pubPhone= scanner.nextLine();
		publisher.setPublisherPhone(pubPhone);
		pubDAO.updatePublisher(publisher);
		AdministratorPage.admin1(scanner);
		
	}
	public static void deletePublisher(Scanner scanner) throws ClassNotFoundException, SQLException {
		PublisherDAO pubDAO = new PublisherDAO();
		List<Publisher> publishers = pubDAO.getPublishers();
		publishers.forEach(p -> System.out.println("Id: " + p.getPublisherId()+ " Name: " + p.getPublisherName()
		 	+ " Address: " + p.getPublisherAddress() + " Phone: " + p.getPublisherPhone()));
		System.out.println("Enter the publisher you would like to delete by Id");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		int pubId = 0;
		if (scannedLine.hasNextInt()) {
			pubId = scannedLine.nextInt();			
		}
		pubDAO.deletePublisher(pubId);
		AdministratorPage.admin1(scanner);
	}
	
}
