package facadeservice;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import couponexception.Message;
import couponsystem.CouponSystem;
import couponsystem.CouponSystemException;
import facade.ClientType;
import facade.CustomerFacade;
import javabeans.Coupon;
import javabeans.CouponType;

@Path("/customer")
public class CustomerService {

	public CustomerService() {
		
	}
	
	private CustomerFacade getFacadeFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		CustomerFacade customerfacade = (CustomerFacade) session.getAttribute("customer");
		return customerfacade;
	}
	
	@Path("/login/{username}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message login(@PathParam("username") String username, @PathParam("password") String password, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.login()");
		CustomerFacade customerfacade = (CustomerFacade) CouponSystem.getInstance().login(username, password, ClientType.CUSTOMER);
		if (username != null && !username.trim().isEmpty()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("customer", customerfacade);
			return new Message("Session ID: " + session.getId());
		}
		return new Message("Login Failed");
	}
	
	@Path("/logout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message logout(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.logout()");
		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("Session ID: " + session.getId());
			session.invalidate();
			return new Message("Session Invalidated Successfully");
		}
		return new Message("Session Invalidation Failed");
	}
	
	@Path("/purchasecoupon")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coupon purchaseCoupon(Coupon coupon, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.purchaseCoupon()");
		CustomerFacade customerfacade = getFacadeFromSession(request);
		Coupon couponpurchase = customerfacade.purchaseCoupon(coupon);
		return couponpurchase;
	}
	
	@Path("/getallpurchasedcoupons")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getAllPurchasedCoupons(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.getAllPurchasedCoupons()");
		CustomerFacade customerfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = customerfacade.getAllPurchasedCoupons();
		return coupons;
	}
	
	@Path("/getallpurchasedcouponsbytype/{type}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getAllPurchasedCouponsByType(@PathParam("type") CouponType type, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.getAllPurchasedCouponsByType()");
		CustomerFacade customerfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = customerfacade.getAllPurchasedCouponByType(type);
		return coupons;
	}
	
	@Path("/getallpurchasedcouponsbyprice/{price}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getAllPurchasedCouponsByPrice(@PathParam("price") double price, @Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.getAllPurchasedCouponsByPrice()");
		CustomerFacade customerfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = customerfacade.getAllPurchasedCouponByPrice(price);
		return coupons;
	}
	
	@Path("/getallsystemcoupons")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getAllSystemCoupons(@Context HttpServletRequest request) throws CouponSystemException {
		System.out.println("CustomerService.getAllSystemCoupons()");
		CustomerFacade customerfacade = getFacadeFromSession(request);
		Collection<Coupon> coupons = customerfacade.getAllSystemCoupons();
		return coupons;
	}
}
