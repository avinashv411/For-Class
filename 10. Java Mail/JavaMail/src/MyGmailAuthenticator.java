import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MyGmailAuthenticator extends Authenticator
{
	protected PasswordAuthentication getPasswordAuthentication() 
	{
		return new PasswordAuthentication("your_Gmail_Id@gmail.com","gmail_Password");
	}
}
