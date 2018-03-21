package testing;

import java.util.Calendar;
import java.util.GregorianCalendar;

import couponsystem.CouponSystem;
import couponsystem.CouponSystemException;
import facade.AdminFacade;
import facade.ClientType;
import facade.CompanyFacade;
import facade.CustomerFacade;
import javabeans.Company;
import javabeans.Coupon;
import javabeans.CouponType;
import javabeans.Customer;

/**
 * This main class tests all the abilities of all the Facades: Admin, Company and Customer
 * This test includes only successful operations since an unsuccessful operation will throw an exception
 * and will stop the test.
 * The console results describe each method that was executed in this test
 * Important note: The shut down method, in addition to closing all the JDBC connections to the database
 * interrupts the daily thread and throws a "sleep interrupted" exception
 * @author Guy Ben-David
 * @author Tomer Banyan
 */

public class CompanyCustomerCouponCreation {

	public static void main(String[] args) throws CouponSystemException {
		
		CouponSystem cs = null;
		
		try {
			
			cs = CouponSystem.getInstance();
			
			//Company List
			
			Company eci = new Company("ECI Telecom", "1234", "eci@ecitele.com");
			Company matrix = new Company("Matrix", "1234", "matrix@matrix.co.il");
			Company google = new Company("Google", "1234", "google@google.com");
			Company apple = new Company("Apple", "1234", "apple@apple.com");
			Company cisco = new Company("Cisco", "1234", "cisco@cisco.com");
			Company checkpoint = new Company("Check Point", "1234", "check@point.com");
			Company amazon = new Company("Amazon", "1234", "amazon@amazon.com");
			Company ebay = new Company("eBay", "1234", "ebay@ebay.com");
			Company microsoft = new Company("Microsoft", "1234", "micro@microsoft.com");
			Company samsung = new Company("Samsung", "1234", "samsung@samsung.com");
			
			//Customer List
			
			Customer tomer = new Customer("Tomer", "1234");
			Customer guy = new Customer("Guy", "1234");
			Customer or = new Customer("Or", "1234");
			Customer moshe = new Customer("Moshe", "1234");
			Customer shay = new Customer("Shay", "1234");
			Customer moran = new Customer("Moran", "1234");
			Customer naor = new Customer("Naor", "1234");
			Customer sai = new Customer("Sai", "1234");
			Customer shira = new Customer("Shira", "1234");
			Customer hadar = new Customer("Hadar", "1234");
			
			//Coupon List
			
			Coupon food1 = new Coupon("Food1", new GregorianCalendar(2019, Calendar.JANUARY, 30).getTime(),
					new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime(), 300, CouponType.FOOD,
					"Variety of delicious food", 105.99, "http://foodimage.com");
			
			Coupon food2 = new Coupon("Food2", new GregorianCalendar(2019, Calendar.JANUARY, 30).getTime(),
					new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime(), 250, CouponType.FOOD,
					"Variety of delicious food", 105.99, "http://foodimage.com");
			
			Coupon food3 = new Coupon("Food3", new GregorianCalendar(2019, Calendar.JANUARY, 30).getTime(),
					new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime(), 150, CouponType.FOOD,
					"Variety of delicious food", 105.99, "http://foodimage.com");
			
			Coupon health1 = new Coupon("Health1", new GregorianCalendar(2019, Calendar.FEBRUARY, 2).getTime(),
					new GregorianCalendar(2020, Calendar.FEBRUARY, 2).getTime(), 270, CouponType.HEALTH,
					"Health Care Program", 179.99, "http://healthimage.com");
			
			Coupon health2 = new Coupon("Health2", new GregorianCalendar(2019, Calendar.FEBRUARY, 2).getTime(),
					new GregorianCalendar(2020, Calendar.FEBRUARY, 2).getTime(), 100, CouponType.HEALTH,
					"Health Care Program", 179.99, "http://healthimage.com");
			
			Coupon health3 = new Coupon("Health3", new GregorianCalendar(2019, Calendar.FEBRUARY, 2).getTime(),
					new GregorianCalendar(2020, Calendar.FEBRUARY, 2).getTime(), 180, CouponType.HEALTH,
					"Health Care Program", 179.99, "http://healthimage.com");
			
			Coupon camping1 = new Coupon("Camping1", new GregorianCalendar(2019, Calendar.MARCH, 5).getTime(),
					new GregorianCalendar(2020, Calendar.MARCH, 5).getTime(), 110, CouponType.CAMPING,
					"Camping in the wilderness under the moonlight", 210.99, "http://campimage.com");
			
			Coupon camping2 = new Coupon("Camping2", new GregorianCalendar(2019, Calendar.MARCH, 5).getTime(),
					new GregorianCalendar(2020, Calendar.MARCH, 5).getTime(), 450, CouponType.CAMPING,
					"Camping in the wilderness under the moonlight", 210.99, "http://campimage.com");
			
			Coupon camping3 = new Coupon("Camping3", new GregorianCalendar(2019, Calendar.MARCH, 5).getTime(),
					new GregorianCalendar(2020, Calendar.MARCH, 5).getTime(), 350, CouponType.CAMPING,
					"Camping in the wilderness under the moonlight", 210.99, "http://campimage.com");
			
			Coupon electricity1 = new Coupon("Electricity1", new GregorianCalendar(2019, Calendar.APRIL, 10).getTime(),
					new GregorianCalendar(2020, Calendar.APRIL, 10).getTime(), 300, CouponType.ELECTRICITY,
					"Electricity services around the clock", 110.99, "http://electricimage.com");
			
			Coupon electricity2 = new Coupon("Electricity2", new GregorianCalendar(2019, Calendar.APRIL, 10).getTime(),
					new GregorianCalendar(2020, Calendar.APRIL, 10).getTime(), 230, CouponType.ELECTRICITY,
					"Electricity services around the clock", 110.99, "http://electricimage.com");
			
			Coupon electricity3 = new Coupon("Electricity3", new GregorianCalendar(2019, Calendar.APRIL, 10).getTime(),
					new GregorianCalendar(2020, Calendar.APRIL, 10).getTime(), 330, CouponType.ELECTRICITY,
					"Electricity services around the clock", 110.99, "http://electricimage.com");
			
			Coupon sports1 = new Coupon("Sports1", new GregorianCalendar(2019, Calendar.MAY, 15).getTime(),
					new GregorianCalendar(2020, Calendar.MAY, 15).getTime(), 260, CouponType.SPORTS,
					"Enjoy all major Sports fields", 100.99, "http://sportimage.com");
			
			Coupon sports2 = new Coupon("Sports2", new GregorianCalendar(2019, Calendar.MAY, 15).getTime(),
					new GregorianCalendar(2020, Calendar.MAY, 15).getTime(), 140, CouponType.SPORTS,
					"Enjoy all major Sports fields", 100.99, "http://sportimage.com");
			
			Coupon sports3 = new Coupon("Sports3", new GregorianCalendar(2019, Calendar.MAY, 15).getTime(),
					new GregorianCalendar(2020, Calendar.MAY, 15).getTime(), 50, CouponType.SPORTS,
					"Enjoy all major Sports fields", 100.99, "http://sportimage.com");
			
			Coupon restaurants1 = new Coupon("Restaurants1", new GregorianCalendar(2019, Calendar.JUNE, 20).getTime(),
					new GregorianCalendar(2020, Calendar.JUNE, 20).getTime(), 160, CouponType.RESTAURANTS,
					"Enjoy variety of popular restaurants", 89.99, "http://sportimage.com");
			
			Coupon restaurants2 = new Coupon("Restaurants2", new GregorianCalendar(2019, Calendar.JUNE, 20).getTime(),
					new GregorianCalendar(2020, Calendar.JUNE, 20).getTime(), 340, CouponType.RESTAURANTS,
					"Enjoy variety of popular restaurants", 89.99, "http://sportimage.com");
			
			Coupon restaurants3 = new Coupon("Restaurants3", new GregorianCalendar(2019, Calendar.JUNE, 20).getTime(),
					new GregorianCalendar(2020, Calendar.JUNE, 20).getTime(), 120, CouponType.RESTAURANTS,
					"Enjoy variety of popular restaurants", 89.99, "http://sportimage.com");
			
			Coupon traveling1 = new Coupon("Traveling1", new GregorianCalendar(2019, Calendar.JULY, 25).getTime(),
					new GregorianCalendar(2020, Calendar.JULY, 25).getTime(), 190, CouponType.TRAVELING,
					"Explore the beauty of nature and culture", 129.99, "http://sportimage.com");
			
			Coupon traveling2 = new Coupon("Traveling2", new GregorianCalendar(2019, Calendar.JULY, 25).getTime(),
					new GregorianCalendar(2020, Calendar.JULY, 25).getTime(), 220, CouponType.TRAVELING,
					"Explore the beauty of nature and culture", 129.99, "http://sportimage.com");
			
			Coupon traveling3 = new Coupon("Traveling3", new GregorianCalendar(2019, Calendar.JULY, 25).getTime(),
					new GregorianCalendar(2020, Calendar.JULY, 25).getTime(), 370, CouponType.TRAVELING,
					"Explore the beauty of nature and culture", 129.99, "http://sportimage.com");
			
			
			System.out.println("Admin Company Creation\n======================\n");
			
			AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);
			
			if (adminfacade.createCompany(eci) != null) {
				System.out.println("Company: " + eci.getCompName() + " ID: " + eci.getId() + " created");
			}
			if (adminfacade.createCompany(matrix) != null) {
				System.out.println("Company: " + matrix.getCompName() + " ID: " + matrix.getId() + " created");
			}
			if (adminfacade.createCompany(google) != null) {
				System.out.println("Company: " + google.getCompName() + " ID: " + google.getId() +  " created");
			}
			if (adminfacade.createCompany(apple) != null) {
				System.out.println("Company: " + apple.getCompName() + " ID: " + apple.getId() +  " created");
			}
			if (adminfacade.createCompany(cisco) != null) {
				System.out.println("Company: " + cisco.getCompName() + " ID: " + cisco.getId() +  " created");
			}
			if (adminfacade.createCompany(checkpoint) != null) {
				System.out.println("Company: " + checkpoint.getCompName() + " ID: " + checkpoint.getId() +  " created");
			}
			if (adminfacade.createCompany(amazon) != null) {
				System.out.println("Company: " + amazon.getCompName() + " ID: " + amazon.getId() +  " created");
			}
			if (adminfacade.createCompany(ebay) != null) {
				System.out.println("Company: " + ebay.getCompName() + " ID: " + ebay.getId() +  " created");
			}
			if (adminfacade.createCompany(microsoft) != null) {
				System.out.println("Company: " + microsoft.getCompName() + " ID: " + microsoft.getId() +  " created");
			}
			if (adminfacade.createCompany(samsung) != null) {
				System.out.println("Company: " + samsung.getCompName() + " ID: " + samsung.getId() +  " created");
			}
			
			System.out.println("\nAdmin Customer Creation\n=======================\n");
			
			if (adminfacade.createCustomer(tomer) != null) {
				System.out.println("Customer: " + tomer.getCustName() + " ID: " + tomer.getId() +  " created");
			}
			if (adminfacade.createCustomer(guy) != null) {
				System.out.println("Customer: " + guy.getCustName() + " ID: " + guy.getId() +  " created");
			}
			if (adminfacade.createCustomer(or) != null) {
				System.out.println("Customer: " + or.getCustName() + " ID: " + or.getId() +  " created");
			}
			if (adminfacade.createCustomer(moshe) != null) {
				System.out.println("Customer: " + moshe.getCustName() + " ID: " + moshe.getId() +  " created");
			}
			if (adminfacade.createCustomer(shay) != null) {
				System.out.println("Customer: " + shay.getCustName() + " ID: " + shay.getId() +  " created");
			}
			if (adminfacade.createCustomer(moran) != null) {
				System.out.println("Customer: " + moran.getCustName() + " ID: " + moran.getId() +  " created");
			}
			if (adminfacade.createCustomer(naor) != null) {
				System.out.println("Customer: " + naor.getCustName() + " ID: " + naor.getId() +  " created");
			}
			if (adminfacade.createCustomer(sai) != null) {
				System.out.println("Customer: " + sai.getCustName() + " ID: " + sai.getId() +  " created");
			}
			if (adminfacade.createCustomer(shira) != null) {
				System.out.println("Customer: " + shira.getCustName() + " ID: " + shira.getId() +  " created");
			}
			if (adminfacade.createCustomer(hadar) != null) {
				System.out.println("Customer: " + hadar.getCustName() + " ID: " + hadar.getId() +  " created");
			}
			
			System.out.println("\nECI Telecom Coupon Creation\n===========================\n");

			CompanyFacade companyfacade = (CompanyFacade) CouponSystem.getInstance().login("ECI Telecom", "1234", ClientType.COMPANY);

			if (companyfacade.createCoupon(food1) != null) {
				System.out.println("Coupon: " + food1.getTitle() + " ID: " + food1.getId() + " created");
			}
			if (companyfacade.createCoupon(food2) != null) {
				System.out.println("Coupon: " + food2.getTitle() + " ID: " + food2.getId() + " created");
			}
			if (companyfacade.createCoupon(food3) != null) {
				System.out.println("Coupon: " + food3.getTitle() + " ID: " + food3.getId() + " created");
			}
			if (companyfacade.createCoupon(health1) != null) {
				System.out.println("Coupon: " + health1.getTitle() + " ID: " + health1.getId() + " created");
			}
			if (companyfacade.createCoupon(health2) != null) {
				System.out.println("Coupon: " + health2.getTitle() + " ID: " + health2.getId() + " created");
			}
			if (companyfacade.createCoupon(electricity1) != null) {
				System.out.println("Coupon: " + electricity1.getTitle() + " ID: " + electricity1.getId() + " created");
			}
			if (companyfacade.createCoupon(electricity2) != null) {
				System.out.println("Coupon: " + electricity2.getTitle() + " ID: " + electricity2.getId() + " created");
			}
			if (companyfacade.createCoupon(restaurants1) != null) {
				System.out.println("Coupon: " + restaurants1.getTitle() + " ID: " + restaurants1.getId() + " created");
			}
			if (companyfacade.createCoupon(restaurants2) != null) {
				System.out.println("Coupon: " + restaurants2.getTitle() + " ID: " + restaurants2.getId() + " created");
			}
			
			System.out.println("\nMatrix Coupon Creation\n======================\n");
			
			companyfacade = (CompanyFacade) CouponSystem.getInstance().login("Matrix", "1234", ClientType.COMPANY);
			
			if (companyfacade.createCoupon(camping1) != null) {
				System.out.println("Coupon: " + camping1.getTitle() + " ID: " + camping1.getId() + " created");
			}
			if (companyfacade.createCoupon(camping2) != null) {
				System.out.println("Coupon: " + camping2.getTitle() + " ID: " + camping2.getId() + " created");
			}
			if (companyfacade.createCoupon(sports1) != null) {
				System.out.println("Coupon: " + sports1.getTitle() + " ID: " + sports1.getId() + " created");
			}
			if (companyfacade.createCoupon(sports2) != null) {
				System.out.println("Coupon: " + sports2.getTitle() + " ID: " + sports2.getId() + " created");
			}
			
			System.out.println("\nGoogle Coupon Creation\n======================\n");
			
			companyfacade = (CompanyFacade) CouponSystem.getInstance().login("Google", "1234", ClientType.COMPANY);
			
			if (companyfacade.createCoupon(traveling1) != null) {
				System.out.println("Coupon: " + traveling1.getTitle() + " ID: " + traveling1.getId() + " created");
			}
			if (companyfacade.createCoupon(traveling2) != null) {
				System.out.println("Coupon: " + traveling2.getTitle() + " ID: " + traveling2.getId() + " created");
			}
			if (companyfacade.createCoupon(traveling3) != null) {
				System.out.println("Coupon: " + traveling3.getTitle() + " ID: " + traveling3.getId() + " created");
			}
			
			System.out.println("\nAmazon Coupon Creation\n======================\n");

			companyfacade = (CompanyFacade) CouponSystem.getInstance().login("Amazon", "1234", ClientType.COMPANY);
			
			if (companyfacade.createCoupon(health3) != null) {
				System.out.println("Coupon: " + health3.getTitle() + " ID: " + health3.getId() + " created");
			}
			if (companyfacade.createCoupon(camping3) != null) {
				System.out.println("Coupon: " + camping3.getTitle() + " ID: " + camping3.getId() + " created");
			}
			if (companyfacade.createCoupon(electricity3) != null) {
				System.out.println("Coupon: " + electricity3.getTitle() + " ID: " + electricity3.getId() + " created");
			}
			if (companyfacade.createCoupon(sports3) != null) {
				System.out.println("Coupon: " + sports3.getTitle() + " ID: " + sports3.getId() + " created");
			}
			if (companyfacade.createCoupon(restaurants3) != null) {
				System.out.println("Coupon: " + restaurants3.getTitle() + " ID: " + restaurants3.getId() + " created");
			}
			
		} catch (Exception e) {
			throw new CouponSystemException("Main Test Failed to Complete", e);
		} finally {
			if (cs != null) {
				System.out.println("\nPerforming System Shut Down\n");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new CouponSystemException("Main failed to sleep", e);
				}
				cs.shutDown();
			}
		}
	}
}

