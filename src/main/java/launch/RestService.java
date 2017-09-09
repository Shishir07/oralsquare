package launch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.util.List;
import java.util.Properties;

@Path("/formsubmit")
public class RestService {

   // private final UserService userService;
	

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create (
    		@QueryParam("name") String name,
    		@QueryParam("phone") String phone,
    		@QueryParam("slot") String slot,
    		@QueryParam("time") String time,
    		@QueryParam("email") String email,
    		@QueryParam("message") String message
    		
            ) throws AddressException, MessagingException {
    	sendMailtoDoctor(name,phone,slot,time,email,message);
    	return Response.ok(phone, MediaType.APPLICATION_JSON).build();
    }

	private void sendMailtoDoctor(String name, String phone, String slot,
			String time,String email, String message) throws AddressException, MessagingException {
			final Properties mailServerProperties;
			final Session getMailSession;
			final MimeMessage generateMailMessage;
	   // Step1
			System.out.println("\n 1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			System.out.println("Mail Server Properties have been setup successfully..");
	 
			// Step2
			System.out.println("\n\n 2nd ===> get Mail Session..");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("garg_barkha@yahoo.com"));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("garg.meghna14@gmail.com"));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("shishirsandeep7@gmail.com"));
			generateMailMessage.setSubject("Appointment Request By "+name+" on "+slot);
			String emailBody = "There is an appointment request by" + "<br><br>Name : "+name+"<br><br>Contact : "+phone+"<br><br>email : "+email+"<br><br>Date : "+slot+"<br><br>Time : "+time+"<br><br>Details : "+message;
			generateMailMessage.setContent(emailBody, "text/html");
			System.out.println("Mail Session has been created successfully..");
	 
			// Step3
			System.out.println("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = getMailSession.getTransport("smtp");
	 
			// Enter your correct gmail UserID and Password
			// if you have 2FA enabled then provide App Specific Password
			transport.connect("smtp.gmail.com", "shishirsandeep7@gmail.com", "abkowglgvlojyilv");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
	   
		
	}


}
