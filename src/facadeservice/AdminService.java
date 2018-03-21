package facadeservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import couponexception.Message;
import couponsystem.CouponSystem;
import couponsystem.CouponSystemException;
import facade.AdminFacade;
import facade.ClientType;
import javabeans.Company;
import javabeans.Customer;

@Path("/admin")
public class AdminService {
	
	private AdminFacade adminfacade;
	
	public AdminService() {
		adminfacade = new AdminFacade();
	}
	
	private AdminFacade getFacadeFromSessions(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		AdminFacade adminfacade = (AdminFacade) session.getAttribute("admin");
		return adminfacade;
	}

	@Path("/login/{username}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message login(@PathParam("username") String username, 
						 @PathParam("password") String password, 
						 @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.login()");
		AdminFacade adminfacade = (AdminFacade) CouponSystem.getInstance().login(username, password, ClientType.ADMIN);
		if (username != null && !username.trim().isEmpty()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", adminfacade);
			return new Message("Session ID: " + session.getId());
		}
		return new Message ("Login Failed");
	}
	
	@Path("/logout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message logout(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.logout()");
		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("Session ID: " + session.getId());
			session.invalidate();
			return new Message("Session Invalidated Successfully");
		}
		return new Message("Session Invalidation Failed");
	}
	
	@Path("/createcompany")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Company createCompany(Company company, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.createCompany()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		return adminfacade.createCompany(company);
	}
	
	@Path("/removecompany/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeCompany(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.removeCompany()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Company company = adminfacade.getCompany(id);
		adminfacade.removeCompany(company);
	}
	
	@Path("/updatecompany")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCompany(Company company, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.updateCompany()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		adminfacade.updateCompany(company);
	}
	
	@Path("/getcompany/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompany(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.getCompany()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Company company = adminfacade.getCompany(id);
		return company;
	}
	
	@Path("/getallcompanies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Company> getAllCompanies (@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.getAllCompanies()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Collection<Company> companies = adminfacade.getAllCompanies();
		//Collection<Company> companies = getCompaniesList(request);
		return companies;
	}
	
	@Path("/createcustomer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer createCustomer(Customer customer, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.createCustomer()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		return adminfacade.createCustomer(customer);
	}
	
	@Path("/removecustomer/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeCustomer(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.removeCustomer()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Customer customer = adminfacade.getCustomer(id);
		adminfacade.removeCustomer(customer);
	}
	
	@Path("/updatecustomer")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer(Customer customer, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.updateCustomer()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		adminfacade.updateCustomer(customer);
	}
	
	@Path("/getcustomer/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.getCustomer()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Customer customer = adminfacade.getCustomer(id);
		return customer;
	}
	
	@Path("/getallcustomers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Customer> getAllCustomers (@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("AdminService.getAllCustomers()");
		AdminFacade adminfacade = getFacadeFromSessions(request);
		Collection<Customer> customers = adminfacade.getAllCustomer();
		//Collection<Customer> customers = getCustomersList(request);
		return customers;
	}
}
