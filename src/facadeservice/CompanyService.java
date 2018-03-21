package facadeservice;

import java.util.Collection;
import java.util.Date;

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
import facade.ClientType;
import facade.CompanyFacade;
import javabeans.Company;
import javabeans.Coupon;
import javabeans.CouponType;

@Path("/company")
public class CompanyService {

	public CompanyService() {
		
	}
	
	private CompanyFacade getFacadeFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		CompanyFacade companyfacade = (CompanyFacade) session.getAttribute("company");
		return companyfacade;
	}
	
	@Path("/login/{username}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message login(@PathParam("username") String username, 
						 @PathParam("password") String password, 
						 @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.login()");
		CompanyFacade companyfacade = (CompanyFacade) CouponSystem.getInstance().login(username, password, ClientType.COMPANY);
		if (username != null && !username.trim().isEmpty()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("company", companyfacade);
			return new Message("Session ID: " + session.getId());
		}
		return new Message("Login Failed");
	}
	
	@Path("/logout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message logout(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.logout()");
		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("Session ID: " + session.getId());
			session.invalidate();
			return new Message("Session Invalidated Successfully");
		}
		return new Message("Session Invalidation Failed");
	}
	
	@Path("/createcoupon")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coupon createCoupon(Coupon coupon, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.createCoupon()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		return companyfacade.createCoupon(coupon);
	}
	
	@Path("/removecoupon/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeCoupon(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.removeCoupon()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Coupon coupon = companyfacade.getCoupon(id);
		companyfacade.removeCoupon(coupon);
		
	}
	
	@Path("/updatecoupon")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCoupon(Coupon coupon, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.updateCoupon()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		companyfacade.updateCoupon(coupon);
	}
	
	@Path("/getcompany")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompany(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getCompany()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Company company = companyfacade.getCompany();
		return company;
	}
	
	@Path("/getcoupon/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Coupon getCoupon(@PathParam("id") long id, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getCoupon()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Coupon coupon = companyfacade.getCoupon(id);
		return coupon;
	}
	
	@Path("/getallcoupons")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getAllCoupons(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getAllCoupons()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = companyfacade.getAllCoupon();
		return coupons;
	}
	
	@Path("/getcouponbytype/{type}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getCouponByType(@PathParam("type") CouponType type, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getCouponByType()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = companyfacade.getCompanyCouponByType(type);
		return coupons;
	}
	
	@Path("/getcouponbyprice/{price}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getCouponByPrice(@PathParam("price") double price, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getCouponByPrice()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = companyfacade.getCouponByPrice(price);
		return coupons;
	}
	
	@Path("/getcouponbydate/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//Unable to path Date as @PathParam
	public Collection<Coupon> getCouponByDate(@PathParam("date") Date date, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CompanyService.getCouponByDate()");
		CompanyFacade companyfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = companyfacade.getCouponByDate(date);
		return coupons;
	}
}
