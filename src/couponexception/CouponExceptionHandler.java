package couponexception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CouponExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		String message = e.getMessage();
		if (message == null) {
			message = "Error while executing this method";
		}
		return Response
				.serverError()
				.entity(new Message(message))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
