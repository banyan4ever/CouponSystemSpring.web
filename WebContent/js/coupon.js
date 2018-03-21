angular
		.module('couponSystem', [ 'ngResource' ])
		.controller('couponController',
				function($resource) {

					var c = this;

					c.adminLoginResource = $resource(
							"couponsystem/admin/login/:username/:password", {
								"username" : "@username",
								"password" : "@password"
							});

					c.companyLoginResource = $resource(
							"couponsystem/company/login/:username/:password", {
								"username" : "@username",
								"password" : "@password"
							});

					c.customerLoginResource = $resource(
							"couponsystem/customer/login/:username/:password",
							{
								"username" : "@username",
								"password" : "@password"
							});

					c.loginDiv = true;
					c.adminDiv = false;
					c.companyDiv = false;
					c.customerDiv = false;

					// Admin DIV

					c.createCompanyDiv = false;
					c.removeCompanyDiv = false;
					c.updateCompanyDiv = false;
					c.getCompanyDiv = false;
					c.getAllCompaniesDiv = false;
					c.createCustomerDiv = false;
					c.removeCustomerDiv = false;
					c.updateCustomerDiv = false;
					c.getCustomerDiv = false;
					c.getAllCustomersDiv = false;

					// Company DIV

					c.createCouponDiv = false;
					c.removeCouponDiv = false;
					c.updateCouponDiv = false;
					c.getThisCompanyDiv = false;
					c.getCouponByIdDiv = false;
					c.getAllCouponsDiv = false;
					c.getCouponByTypeDiv = false;
					c.getCouponByPriceDiv = false;
					c.getCouponByDateDiv = false;

					// Customer DIV

					c.purchaseCouponDiv = false;
					c.getAllPurchasedCouponsDiv = false;
					c.getAllPurchasedCouponsByTypeDiv = false;
					c.getAllPurchasedCouponsByPriceDiv = false;

					// Table DIV

					c.companyTableDiv = false;
					c.getCompanyTableDiv = false;
					c.getAllCompaniesTableDiv = false;
					c.updateCompanyTableDiv = false;
					
					c.customerTableDiv = false;
					c.getCustomerTableDiv = false;
					c.getAllCustomersTableDiv = false;
					
					c.couponTableDiv = false;
					c.getMyCompanyTableDiv = false;
					c.getCouponByIdTableDiv = false;
					c.getAllCouponsTableDiv = false;
					c.couponByTypeTableDiv = false;
					c.couponByPriceTableDiv = false;
					c.couponByDateTableDiv = false;
					
					c.getAllSystemCouponsTableDiv = false;
					
					// Exceptions DIV
					
					c.loginExceptionDiv = false;
					c.companyExceptionDiv = false;
					c.removeCompanyExceptionDiv = false;
					c.getCompanyExceptionDiv = false;
					c.getAllCompaniesExceptionDiv = false;
					c.customerExceptionDiv = false;
					c.removeCustomerExceptionDiv = false;
					c.getCustomerExceptionDiv = false;
					c.getAllCustomersExceptionDiv = false;
					
					c.couponExceptionDiv = false;
					c.removeCouponExceptionDiv = false;
					c.getMyCompanyExceptionDiv = false;
					c.getCouponByIdExceptionDiv = false;
					c.getAllCouponsExceptionDiv = true;
					c.couponByTypeExceptionDiv = false;
					c.couponByPriceExceptionDiv = false;
					c.couponByDateExceptionDiv = false;
					
					c.getAllSystemCouponExceptionDiv = false;
					
					

					c.loginFields = {
						"username" : "",
						"password" : "",
						"clientType" : ""
					};

					c.companyFields = {
						"id" : null,
						"compName" : "",
						"password" : "",
						"email" : ""
					};
					
					c.customerFields = {
						"id" : null,
						"custName" : "",
						"password" : ""
					}
					
					c.couponFields = {
						"id" : null,
						"title" : "",
						"startDate" : "",
						"endDate" : "",
						"amount" : "",
						"type" : "",
						"message" : "",
						"price" : "",
						"image" : ""
					}
					
					c.infoMessage = "";
					c.errorMessage = "";

					c.info = function(message) {
						c.infoMessage = message;
						c.errorMessage = "";
					}

					c.error = function(message) {
						c.infoMessage = "";
						c.errorMessage = message;
					}

					c.handleError = function(response, defaultMessage) {
						if (response.data != null
								&& response.data.message != null) {
							c.error("Error: " + response.data.message);
						} else {
							c.error(defaultMessage);
						}
					}

					c.submitLoginForm = function() {
						if (c.loginFields.clientType == "Admin") {
							c.adminLoginResource.get(c.loginFields,
									function(response) {
										c.adminDiv = true;
										c.loginDiv = false;
										c.companyDiv = false;
										c.customerDiv = false;
										
										c.createCompanyDiv = false;
										c.removeCompanyDiv = false;
										c.updateCompanyDiv = false;
										c.getCompanyDiv = false;
										c.getAllCompaniesDiv = false;
										c.createCustomerDiv = false;
										c.removeCustomerDiv = false;
										c.updateCustomerDiv = false;
										c.getCustomerDiv = false;
										c.getAllCustomersDiv = false;
										
										c.loginExceptionDiv = false;
										c.companyExceptionDiv = false;
										c.removeCompanyExceptionDiv = false;
										c.getCompanyExceptionDiv = false;
										c.getAllCompaniesExceptionDiv = false;
										c.customerExceptionDiv = false;
										c.removeCustomerExceptionDiv = false;
										c.getCustomerExceptionDiv = false;
										c.getAllCustomersExceptionDiv = false;
									}, function() {
										c.error("Login Failed")
										c.loginExceptionDiv = true;
									});
						} else if (c.loginFields.clientType == "Company") {
							c.companyLoginResource.get(
									c.loginFields, function(response) {
										c.loginFields.username;
										c.companyDiv = true;
										c.loginDiv = false;
										c.adminDiv = false;
										c.customerDiv = false;
										
										c.createCouponDiv = false;
										c.removeCouponDiv = false;
										c.updateCouponDiv = false;
										c.getThisCompanyDiv = false;
										c.getCouponByIdDiv = false;
										c.getAllCouponsDiv = false;
										c.getCouponByTypeDiv = false;
										c.getCouponByPriceDiv = false;
										c.getCouponByDateDiv = false;
										
										c.couponExceptionDiv = false;
										c.removeCouponExceptionDiv = false;
										c.getMyCompanyExceptionDiv = false;
										c.getCouponByIdExceptionDiv = false;
										c.getAllCouponsExceptionDiv = true;
										c.couponByTypeExceptionDiv = false;
										c.couponByPriceExceptionDiv = false;
										c.couponByDateExceptionDiv = false;
									}, function() {
										c.error("Login Failed")
										c.loginExceptionDiv = true;
									});
						} else if (c.loginFields.clientType == "Customer") {
							c.customerLoginResource.get(
									c.loginFields, function(response) {
										c.loginFields.username;
										c.customerDiv = true;
										c.loginDiv = false;
										c.adminDiv = false;
										c.companyDiv = false;
									}, function() {
										c.error("Login Failed")
										c.loginExceptionDiv = true;
									});
						}
					}

					c.adminLogoutResource = $resource("couponsystem/admin/logout");

					c.adminLogoutButton = function() {
						c.adminLogoutResource.get(function(response) {
							c.loginFields = {
								"username" : "",
								"password" : "",
								"clientType" : ""
							};
							c.loginDiv = true;
							c.loginExceptionDiv = false;
							c.customerDiv = false;
							c.adminDiv = false;
							c.companyDiv = false;
						});
					}

					c.companyLogoutResource = $resource("couponsystem/company/logout");

					c.companyLogoutButton = function() {
						c.companyLogoutResource.get(function(response) {
							c.loginFields = {
								"username" : "",
								"password" : "",
								"clientType" : ""
							};
							c.loginDiv = true;
							c.loginExceptionDiv = false;
							c.customerDiv = false;
							c.adminDiv = false;
							c.companyDiv = false;
						});
					}

					c.customerLogoutResource = $resource("couponsystem/customer/logout");

					c.customerLogoutButton = function() {
						c.customerLogoutResource.get(function(response) {
							c.loginFields = {
								"username" : "",
								"password" : "",
								"clientType" : ""
							};
							c.loginDiv = true;
							c.loginExceptionDiv = false;
							c.customerDiv = false;
							c.adminDiv = false;
							c.companyDiv = false;
						});
					}

					c.createCompanyResource = $resource("couponsystem/admin/createcompany");

				
					c.createCompanyForm = function() {
						c.createCompanyResource
								.save(
										c.companyFields,
										function(response) {
											c.companyFields.id = response.id;
											c.companyFields.compName = response.compName;
											c.companyFields.password = response.password;
											c.companyFields.email = response.email;
											c.companyTableDiv = true;
											c.companyExceptionDiv = false;
										}, function() {
											c.error("Company Creation Failed")
											c.companyExceptionDiv = true;
											c.companyTableDiv = false;
										});

					}

					c.removeCompanyResource = $resource("couponsystem/admin/removecompany/:id",{
						"id":"@id"
					});
					
					c.removeCompanyForm = function() {
						c.removeCompanyResource.delete(c.companyFields, function(company) {
							c.removeCompanyExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.removeCompanyExceptionDiv = true;
						});
					}
					
					c.updateCompanyResource = $resource("couponsystem/admin/updatecompany/:id", {"id" : "@id"}, 
							{'updateCompany' : {method : 'PUT'}});
					
						/*c.allCompanies = [];
					
						c.getAllCompaniesForm = function() {
							c.allCompanies = c.getAllCompaniesResource.query(c.companyFields, function() {
								c.allCompanies.forEach(function(company){
									c.companyFields = company;
								})
							});
						}*/
					
					/*c.updateCompanyResource = $resource("couponsystem/admin/updatecompany/:id", {"id" : "@id"}, 
							{'updateCompany' : {method : 'PUT'}});
					
					c.updateCompanyForm = function(company) {
						c.companyFields = company;
						company.$updateCompany(company, function() {
							c.companyFields.id = company.id;
							c.companyFields.compName = company.compName;
							c.companyFields.password = company.password;
							c.companyFields.email = company.email;
							c.updateCompanyTableDiv = true;
							c.updateCompanyExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed");
							c.updateCompanyExceptionDiv = true;
							c.updateCompanyTableDiv = false;
						});
					}*/
					
					c.updateCompanyForm = function(company) {
						company.$updateCompany(company, function() {
							c.companyFields = company;
							c.updateCompanyTableDiv = true;
						});
					}
					
					c.getCompanyResource = $resource(
							"couponsystem/admin/getcompany/:id", {
								"id" : "@id"
							});

					c.getCompanyForm = function() {
						c.getCompanyResource.get(c.companyFields,
								function(resCompany) {
									c.companyFields = resCompany; 
									c.getCompanyTableDiv = true;
									c.getCompanyExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.getCompanyExceptionDiv = true;
							c.getCompanyTableDiv = false;
						});
					}
					
					c.getAllCompaniesResource = $resource("couponsystem/admin/getallcompanies");
					
					c.allCompanies = [];
					
					c.getAllCompaniesForm = function() {
						c.allCompanies = c.getAllCompaniesResource.query(c.companyFields, function() {
							c.allCompanies.forEach(function(company){
							c.companyFields = company;
							c.getAllCompaniesTableDiv = true;
							c.getAllCompaniesExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.getAllCompaniesExceptionDiv = true;
								c.getAllCompaniesTableDiv = false;
							});
					}
					
					
					c.createCustomerResource = $resource("couponsystem/admin/createcustomer");


					c.createCustomerForm = function() {
						c.createCustomerResource
								.save(
										c.customerFields,
										function(response) {
											c.customerFields.id = response.id;
											c.customerFields.custName = response.custName;
											c.customerFields.password = response.password;
											c.customerTableDiv = true;
											c.customerExceptionDiv = false;
										}, function() {
											c.error("Customer Creation Failed")
											c.customerExceptionDiv = true;
											c.customerTableDiv = false;
										});

					}
					
					c.removeCustomerResource = $resource("couponsystem/admin/removecustomer/:id",{
						"id":"@id"
					});
					
					c.removeCustomerForm = function() {
						c.removeCustomerResource.delete(c.customerFields, function(customer) {
							c.removeCustomerExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.removeCustomerExceptionDiv = true;
						});
					}
					
					c.getCustomerResource = $resource(
							"couponsystem/admin/getcustomer/:id", {
								"id" : "@id"
							});

					c.getCustomerForm = function() {
						c.getCustomerResource.get(c.customerFields,
								function(resCustomer) {
									c.customerFields = resCustomer; 
									c.getCustomerTableDiv = true;
									c.getCustomerExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.getCustomerExceptionDiv = true;
							c.getCustomerTableDiv = false;
						});
					}
					
					c.getAllCustomersResource = $resource("couponsystem/admin/getallcustomers");
					
					c.allCustomers = [];
					
					c.getAllCustomersForm = function() {
						c.allCustomers = c.getAllCustomersResource.query(c.customerFields, function() {
							c.allCustomers.forEach(function(customer){
							c.customerFields = customer;
							c.getAllCustomersTableDiv = true;
							c.getAllCustomersExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.getAllCustomersExceptionDiv = true;
								c.getAllCustomersTableDiv = false;
							});
					}
					
					c.createCouponResource = $resource("couponsystem/company/createcoupon");
					
					c.createCouponForm = function() {
						c.createCouponResource.save(c.couponFields, function(resCoupon) {
							c.couponFields.id = resCoupon.id;
							c.couponFields.title = resCoupon.title;
							c.couponFields.startDate = resCoupon.startDate;
							c.couponFields.endDate = resCoupon.endDate;
							c.couponFields.amount = resCoupon.amount;
							c.couponFields.type = resCoupon.type;
							c.couponFields.message = resCoupon.message;
							c.couponFields.price = resCoupon.price;
							c.couponFields.image = resCoupon.image;
							c.couponTableDiv = true;
							c.couponExceptionDiv = false;
						}, function() {
							c.error("Coupon Creation Failed")
							c.couponExceptionDiv = true;
							c.couponTableDiv = false;
						});
					}
					
					c.removeCouponResource = $resource("couponsystem/company/removecoupon/:id",{
						"id":"@id"
					});
					
					c.removeCouponForm = function() {
						c.removeCouponResource.delete(c.couponFields, function(coupon) {
							c.removeCouponExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.removeCouponExceptionDiv = true;
						});
					}
					
					c.getMyCompanyResource = $resource("couponsystem/company/getcompany");

					c.getMyCompanyForm = function() {
						c.getMyCompanyResource.get(c.companyFields,
								function(resCompany) {
									c.companyFields = resCompany; 
									c.getMyCompanyTableDiv = true;
									c.getMyCompanyExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.getMyCompanyExceptionDiv = true;
							c.getMyCompanyTableDiv = false;
						});
					}
					
					c.getCouponByIdResource = $resource(
							"couponsystem/company/getcoupon/:id", {
								"id" : "@id"
							});

					c.getCouponByIdForm = function() {
						c.getCouponByIdResource.get(c.couponFields,
								function(resCoupon) {
									c.couponFields = resCoupon; 
									c.getCouponByIdTableDiv = true;
									c.getCouponByIdExceptionDiv = false;
						}, function() {
							c.error("Request could not be completed")
							c.getCouponByIdExceptionDiv = true;
							c.getCouponByIdTableDiv = false;
						});
					}
					
					c.getAllCouponsResource = $resource("couponsystem/company/getallcoupons");
					
					c.allCoupons = [];
					
					c.getAllCouponsForm = function() {
						c.allCoupons = c.getAllCouponsResource.query(c.couponFields, function() {
							c.allCoupons.forEach(function(coupon){
							c.couponFields = coupon;
							c.getAllCouponsTableDiv = true;
							c.getAllCouponsExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.getAllCouponsExceptionDiv = true;
								c.getAllCouponsTableDiv = false;
							});
					}
					
					c.getCouponByTypeResource = $resource(
							"couponsystem/company/getcouponbytype/:type", {
								"type" : "@type"
							});

					c.couponByType = [];
					
					c.getCouponByTypeForm = function() {
						c.couponByType = c.getCouponByTypeResource.query(c.couponFields, function() {
							c.couponByType.forEach(function(coupon){
							c.couponFields = coupon;
							c.couponByTypeTableDiv = true;
							c.couponByTypeExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.couponByTypeExceptionDiv = true;
								c.couponByTypeTableDiv = false;
							});
					}
					
					c.getCouponByPriceResource = $resource(
							"couponsystem/company/getcouponbyprice/:price", {
								"price" : "@price"
							});

					c.couponByPrice = [];
					
					c.getCouponByPriceForm = function() {
						c.couponByPrice = c.getCouponByPriceResource.query(c.couponFields, function() {
							c.couponByPrice.forEach(function(coupon){
							c.couponFields = coupon;
							c.couponByPriceTableDiv = true;
							c.couponByPriceExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.couponByPriceExceptionDiv = true;
								c.couponByPriceTableDiv = false;
							});
					}
					
					c.getCouponByDateResource = $resource(
							"couponsystem/company/getcouponbydate/:date", {
								"date" : "@date"
							});

					c.couponByDate = [];
					
					c.getCouponByDateForm = function() {
						c.couponByDate = c.getCouponByDateResource.query(c.couponFields, function() {
							c.couponByDate.forEach(function(coupon){
							c.couponFields = coupon;
							c.couponByDateTableDiv = true;
							c.couponByDateExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.couponByDateExceptionDiv = true;
								c.couponByDateTableDiv = false;
							});
					}
					
					c.purchaseCouponResource = $resource("couponsystem/customer/getallsystemcoupons");
					
					c.allSystemCoupons = [];
					
					c.purchaseCouponForm = function() {
						c.allSystemCoupons = c.purchaseCouponResource.query(c.couponFields, function() {
							c.allSystemCoupons.forEach(function(coupon){
							c.couponFields = coupon;
							c.getAllSystemCouponsTableDiv = true;
							c.getAllSystemCouponExceptionDiv = false;
							})}, function() {
								c.error("Request could not be completed")
								c.getAllCouponsExceptionDiv = true;
								c.getAllCouponsTableDiv = false;
							});
					}
					
					
					c.submitPurchaseResource = $resource("couponsystem/customer/purchasecoupon");
					
					c.submitPurchaseForm = function() {
						c.submitPurchaseResource.save(c.couponFields, function(coupon) {
							c.info("Coupon Purchased Successfully")
							c.purchaseCouponSuccessDiv = true;
							c.getAllSystemCouponsTableDiv = false;
							c.getAllSystemCouponExceptionDiv = false;
						}, function() {
							c.error("Coupon Purchase Failed")
							c.purchaseCouponSuccessDiv = false;
							c.getAllSystemCouponsTableDiv = false;
							c.getAllSystemCouponExceptionDiv = true;
						});
					}
					
					
					
					
					

					c.createCompanyButton = function() {
						c.createCompanyDiv = true;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.companyTableDiv = false;
						c.companyFields = {
							"compName" : "",
							"password" : "",
							"email" : ""
						};
						c.companyExceptionDiv = false;
					}
					
					c.removeCompanyButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = true;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.companyFields = {
								"id" : ""
						};
						c.removeCompanyExceptionDiv = false;
					}

					c.updateCompanyButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = true;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
					}

					c.getCompanyButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = true;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.getCompanyTableDiv = false;
						c.companyFields = {
								"id" : ""
							};
						c.getCompanyExceptionDiv = false;
					}

					c.getAllCompaniesButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = true;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.getAllCompaniesTableDiv = false;
						c.getAllCompaniesExceptionDiv = false;
						
					}

					c.createCustomerButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = true;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.customerTableDiv = false;
						c.customerFields = {
								"custName" : "",
								"password" : ""
						};
						c.customerExceptionDiv = false;
					}

					c.removeCustomerButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = true;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
						c.customerFields = {
								"id" : ""
						};
						c.removeCustomerExceptionDiv = false;
					}

					c.updateCustomerButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = true;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = false;
					}

					c.getCustomerButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = true;
						c.getAllCustomersDiv = false;
						c.getCustomerTableDiv = false;
						c.customerFields = {
								"id" : ""
						};
						c.getCustomerExceptionDiv = false;
					}

					c.getAllCustomersButton = function() {
						c.createCompanyDiv = false;
						c.removeCompanyDiv = false;
						c.updateCompanyDiv = false;
						c.getCompanyDiv = false;
						c.getAllCompaniesDiv = false;
						c.createCustomerDiv = false;
						c.removeCustomerDiv = false;
						c.updateCustomerDiv = false;
						c.getCustomerDiv = false;
						c.getAllCustomersDiv = true;
						c.getAllCustomersTableDiv = false;
					}

					c.createCouponButton = function() {
						c.createCouponDiv = true;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						c.couponTableDiv = false;
						c.couponFields = {
								"id" : null,
								"title" : "",
								"startDate" : "",
								"endDate" : "",
								"amount" : "",
								"type" : "",
								"message" : "",
								"price" : "",
								"image" : ""
						};
						c.couponExceptionDiv = false;
					}

					c.removeCouponButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = true;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						c.couponFields = {
								"id" : null
						};
						c.removeCouponExceptionDiv = false;
					}

					c.updateCouponButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = true;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
					}

					c.getThisCompanyButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = true;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						c.getMyCompanyTableDiv = false;
					}

					c.getCouponButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = true;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						c.couponFields = {
								"id" : null
						};
						c.getCouponByIdTableDiv = false;
						c.getCouponByIdExceptionDiv = false;
					}

					c.getAllCompanyCouponsButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = true;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						
						//Divs that do not disappear
						c.getAllCouponsTableDiv = false;
						c.getAllCouponsExceptionDiv = false;
					}

					c.getCouponsByTypeButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = true;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = false;
						c.couponFields = {
								"id" : null
						};
						//Divs that do not disappear
						c.couponByTypeTableDiv = false;
						c.couponByTypeExceptionDiv = false;
					}

					c.getCouponsByPriceButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = true;
						c.getCouponByDateDiv = false;
						c.couponFields = {
								"price" : ""
						};
						//Divs that do not disappear
						c.couponByPriceTableDiv = false;
						c.couponByPriceExceptionDiv = false;
					}

					c.getCouponsByDateButton = function() {
						c.createCouponDiv = false;
						c.removeCouponDiv = false;
						c.updateCouponDiv = false;
						c.getThisCompanyDiv = false;
						c.getCouponByIdDiv = false;
						c.getAllCouponsDiv = false;
						c.getCouponByTypeDiv = false;
						c.getCouponByPriceDiv = false;
						c.getCouponByDateDiv = true;
						c.couponFields = {
								"endDate" : ""
						};
						
						c.couponByDateTableDiv = false;
						c.couponByDateExceptionDiv = false;
					}

					c.purchaseCouponButton = function() {
						c.purchaseCouponDiv = true;
						c.getAllPurchasedCouponsDiv = false;
						c.getAllPurchasedCouponsByTypeDiv = false;
						c.getAllPurchasedCouponsByPriceDiv = false;
						
						c.getAllSystemCouponsTableDiv = false;
						c.getAllSystemCouponExceptionDiv = false;
					}

					c.getAllPurchasedCouponsButton = function() {
						c.purchaseCouponDiv = false;
						c.getAllPurchasedCouponsDiv = true;
						c.getAllPurchasedCouponsByTypeDiv = false;
						c.getAllPurchasedCouponsByPriceDiv = false;
					}

					c.getAllPurchasedCouponsByTypeButton = function() {
						c.purchaseCouponDiv = false;
						c.getAllPurchasedCouponsDiv = false;
						c.getAllPurchasedCouponsByTypeDiv = true;
						c.getAllPurchasedCouponsByPriceDiv = false;
					}

					c.getAllPurchasedCouponsByPriceButton = function() {
						c.purchaseCouponDiv = false;
						c.getAllPurchasedCouponsDiv = false;
						c.getAllPurchasedCouponsByTypeDiv = false;
						c.getAllPurchasedCouponsByPriceDiv = true;
					}
				});