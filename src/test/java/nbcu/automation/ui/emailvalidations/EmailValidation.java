package nbcu.automation.ui.emailvalidations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import nbcu.automation.ui.constants.ncxUnifiedTool.Constants;
import nbcu.automation.ui.pages.ncxUnifiedTool.ProducerDashboardGeneralPage;
import nbcu.framework.utils.encryption.PasswordEncryption;
import nbcu.framework.utils.propertyfilereader.ConfigFileReader;
import nbcu.framework.utils.report.ReportGenerate;
import nbcu.framework.utils.ui.WebAction;

public class EmailValidation {

	/**
	 * To read email content
	 * 
	 * @param store
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void verifyEmailReceived(String emailReceived, String status) throws NumberFormatException, Exception {

		Store store = null;
		String userName = "";
		boolean emailCheck = false;
		try {

			// To fetch gmail host, user name and password from config.properties
			String host = ConfigFileReader.getProperty("Gmail-Host", "emailconfig.properties");
			userName = ConfigFileReader.getProperty("Gmail-UserName", "emailconfig.properties");

			String password = ConfigFileReader.getProperty("Gmail-Password", "emailconfig.properties");

			Folder emailFolder = null;
			String subject = "", toList = "", ccList = "", emailBody = "";

			// create properties
			Properties properties = new Properties();

			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.pop3.starttls.enable", "true");

			Session emailSession = Session.getDefaultInstance(properties);

			// create the pop3 store object and connect to the pop3 server
			store = emailSession.getStore("imaps");

			store.connect(host, userName, password);

			outer: for (int waitCount = 0; waitCount < 2; waitCount++) {
				// wait for 10 seconds
				Thread.sleep(10000);

				// create the folder object and open it
				emailFolder = store.getFolder("INBOX");
				emailFolder.open(Folder.READ_WRITE);

				// retrieve the messages from the folder in an array and print it
				Message[] messages = emailFolder.getMessages();
				System.out.println("messages.length---> " + messages.length);

				for (int i = messages.length - 1; i >= messages.length - 5; i--) {
					Message message = messages[i];
					System.out.println("Email Number " + (i + 1));
					subject = message.getSubject();

					emailBody = getTextFromMessage(message);

					emailCheck = emailBody.contains(status.toUpperCase() + " - " + Constants.getRequestNumber());

					if (emailCheck) {
						ReportGenerate.test.log(Status.PASS,"<b>"+status +"</b> EMAIL received for the request <b>"+Constants.getRequestNumber());
						if (message.getRecipients(Message.RecipientType.TO) != null) {
							for (Address address : message.getRecipients(Message.RecipientType.TO)) {
								toList = toList + address.toString() + ",";
							}
							toList = toList.substring(0, toList.length() - 1);
						}

						if (message.getRecipients(Message.RecipientType.CC) != null) {
							for (Address address : message.getRecipients(Message.RecipientType.CC)) {
								ccList = ccList + address.toString() + ",";
							}
							ccList = ccList.substring(0, ccList.length() - 1);
						}

						EmailConstants.setEmailSubject(subject.replace("  ", " "));
						EmailConstants.setEmailToList(toList);
						EmailConstants.setEmailCcList(ccList);
						EmailConstants.setEmailBody(emailBody);

						break outer;
					} else {
						subject = "";
						toList = "";
						ccList = "";
						emailBody = "";
					}

				}
			}

			// Close email folder
			emailFolder.close(false);
			// close the store and folder objects
			store.close();

		} catch (MessagingException e) {
			store.close();
			e.printStackTrace();
			throw new Exception("Failed to connect email account -" + userName);
		} catch (Exception e) {
			store.close();
			e.printStackTrace();
			throw new Exception("Failed to connect email account -" + userName);
		}
	}

	/**
	 * To read email body
	 * 
	 * @param message
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	private static String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		} else if (message.isMimeType("text/html")) {
			String html = (String) message.getContent();
			result = org.jsoup.Jsoup.parse(html).text();
		}
		return result;
	}

	/**
	 * To read multi part email body
	 * 
	 * @param mimeMultipart
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}

	/*
	 * private static boolean checkEmailIsPresent(String emailBody, String
	 * bookingType, String expectedShowName, String expectedGuestName, String
	 * showDate, String showTime, String expectedStudio, String expectedTopicName)
	 * throws MessagingException, IOException { boolean emailCheck = false; try { if
	 * ((bookingType.equalsIgnoreCase("NEW BOOKING")) ||
	 * (bookingType.equalsIgnoreCase("EDITED BOOKING"))) { if
	 * ((emailBody.toLowerCase().contains(expectedShowName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedGuestName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(showDate)) &&
	 * (emailBody.toLowerCase().contains(showTime.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedStudio.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedTopicName.toLowerCase()))) {
	 * emailCheck = true; }
	 * 
	 * } else if (bookingType.equalsIgnoreCase("CANCEL BOOKING")) { if
	 * ((emailBody.toLowerCase().contains(expectedShowName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedGuestName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(showDate)) &&
	 * (emailBody.toLowerCase().contains("cancelled"))) { emailCheck = true; } }
	 * else if (bookingType.equalsIgnoreCase("DUPLICATE BOOKING")) { showTime =
	 * DateFunctions.convertDateStringToAnotherFormat(BookingGuestConstants.
	 * getDuplicateBookingShowTime(), "HH:mm", "hh:mm:ss a"); if
	 * ((emailBody.toLowerCase().contains(expectedShowName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedGuestName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(showDate)) &&
	 * (emailBody.toLowerCase().contains(showTime.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains(expectedTopicName.toLowerCase())) &&
	 * (emailBody.toLowerCase().contains("duplicate booking alert"))) { emailCheck =
	 * true; } } else Assert.assertTrue(false,
	 * "Enter valid booking type for email check"); } catch (Exception e) {
	 * e.printStackTrace(); } return emailCheck; }
	 */

	public static void main(String[] args) throws Exception {
		String host = "imap.gmail.com";
		String userName = "jeevanbcutest@gmail.com";
		String password = "wnjqjrrjmoumcsae";
		Store store = null;
		boolean emailCheck = false;
		/*
		 * String host = "imap.gmail.com"; String mailStoreType = "imap"; String
		 * username = "@gmail.com"; String password = "ednkpqmqnwiiyxfa";
		 */

		// EmailValidation email = new EmailValidation();
		// email.verifyEmailReceived("received", "NEW");
		Folder emailFolder = null;
		String subject = "", toList = "", ccList = "", emailBody = "";

		// create properties
		Properties properties = new Properties();

		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", "993");
		properties.put("mail.pop3.starttls.enable", "true");

		Session emailSession = Session.getDefaultInstance(properties);

		// create the pop3 store object and connect to the pop3 server
		store = emailSession.getStore("imaps");

		store.connect(host, userName, password);
		emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_WRITE);

		// retrieve the messages from the folder in an array and print it
		Message[] messages = emailFolder.getMessages();
		System.out.println("messages.length---> " + messages.length);
		List<String> listA = new ArrayList<String>();

		listA.add("A");
		listA.add("B");
		List<String> listB = new ArrayList<String>();

		listB.add("B");
		listB.add("A");

		Collections.sort(listA);
		Collections.sort(listB);
		Assert.assertEquals(listA, listB);
	}

	
	public void toListAssertion(List<String> toListArray ) {
		try {
			Assert.assertEquals(toListArray, ProducerDashboardGeneralPage.emailtoList);
			ReportGenerate.test.log(Status.PASS,"Expected TO List <b>"+
					ProducerDashboardGeneralPage.emailtoList +"</b> \n is matched with received EMAIL TO dls <b>"+toListArray);
			}catch(Exception e) {
				ReportGenerate.test.log(Status.FAIL,"Expected TO List is <b>"+
						ProducerDashboardGeneralPage.emailtoList +"</b> but received <b>"+toListArray);
			}
	}
	
	public void ccListAssertion(List<String> ccListArray ) {
		try {
			Assert.assertEquals(ccListArray, ProducerDashboardGeneralPage.emailCCList);
			ReportGenerate.test.log(Status.PASS,"Expected CC List <b>"+
					ProducerDashboardGeneralPage.emailCCList +"</b> \n is matched with received EMAIL CC dls <b>"+ccListArray);
			}catch(Exception e) {
				ReportGenerate.test.log(Status.FAIL,"Expected CC List is <b>"+
						ProducerDashboardGeneralPage.emailCCList +"</b> but received <b>"+ccListArray);
			}
	}
	
	public void workingCCListAssertion(List<String> workingCCListArray ) {
		try {
			Assert.assertEquals(workingCCListArray, ProducerDashboardGeneralPage.workingEmailCCList);
			ReportGenerate.test.log(Status.PASS,"Expected CC List <b>"+
					ProducerDashboardGeneralPage.workingEmailCCList +"</b> \n is matched with received WORKING Status EMAIL CC dls <b>"+workingCCListArray);
			}catch(Exception e) {
				ReportGenerate.test.log(Status.FAIL,"Expected CC List is <b>"+
						ProducerDashboardGeneralPage.workingEmailCCList +"</b> but received <b>"+workingCCListArray);
			}
	}
	
	public void workingTOListAssertion(List<String> workingTOListArray ) {
		try {
			Assert.assertEquals(workingTOListArray, ProducerDashboardGeneralPage.workingEmailtoList);
			ReportGenerate.test.log(Status.PASS,"Expected TO List <b>"+
					ProducerDashboardGeneralPage.workingEmailtoList +"</b> matched with received WORKING Status EMAIL TO dls <b>"+workingTOListArray);
			}catch(Exception e) {
				ReportGenerate.test.log(Status.FAIL,"Expected TO List is <b>"+
						ProducerDashboardGeneralPage.workingEmailtoList +"</b> but received <b>"+workingTOListArray);
			}
	}
	
	/**
	 * To Verify TO & CC DLs corresponding forms
	 * 
	 * @param ToOrCCList
	 * @throws Exception
	 */
	public void validateTOandCCList(String ToOrCCList) throws Exception {

		if (ToOrCCList.equals("ToList")) {
			String tolist[] = EmailConstants.getEmailToList().split(",");
			List<String> toListArray = new ArrayList<String>();
			for (String item : tolist) {
				toListArray.add(item);
			}
			Collections.sort(toListArray);
			Collections.sort(ProducerDashboardGeneralPage.emailtoList);
			System.out.println("Constant To List    " + ProducerDashboardGeneralPage.emailtoList);
			System.out.println("Email To List       " + toListArray);
			ReportGenerate.test.log(Status.INFO,"TO list array received from EMAIL <b>\n"+
					toListArray +"</b>");
			ReportGenerate.test.log(Status.INFO,"TO list array added for appropriate fields <b>\n"+
					ProducerDashboardGeneralPage.emailtoList +"</b>");
			toListAssertion(toListArray);
		} else if (ToOrCCList.equals("CcList")) {
			String cclist[] = EmailConstants.getEmailCcList().split(",");
			List<String> ccListArray = new ArrayList<String>();
			for (String item : cclist) {
				ccListArray.add(item);
			}
			System.out.println("Constant CC List    " + ProducerDashboardGeneralPage.emailCCList);
			System.out.println("Email CC List       " + ccListArray);
			Collections.sort(ccListArray);
			Collections.sort(ProducerDashboardGeneralPage.emailCCList);
			
			ReportGenerate.test.log(Status.INFO,"CC list array received from EMAIL :<b>"+
					ccListArray +"</b>");
			ReportGenerate.test.log(Status.INFO,"CC list array added for appropriate fields :<b>"+
					ProducerDashboardGeneralPage.emailCCList +"</b>");
			ccListAssertion(ccListArray);
		}
	}

	public void validateTOandCCList(String ToOrCCList, String status) throws Exception {

		if (ToOrCCList.equals("ToList")) {
			String tolist[] = EmailConstants.getEmailToList().split(",");
			List<String> toListArray = new ArrayList<String>();
			for (String item : tolist) {
				toListArray.add(item);
			}
			Collections.sort(toListArray);
			if (status.equalsIgnoreCase("WORKING") || status.equalsIgnoreCase("CONFIRM CANCELLATION")
					|| status.equalsIgnoreCase("CANCELLED")) {
				switch (Constants.getFormName().toUpperCase()) {
				case "SINGLE CAMERA LIVE SHOT":
				case "EXTEND OR BRIDGE CREW & FACILITIES":
				case "ROCK CENTER":
					try {
						Collections.sort(ProducerDashboardGeneralPage.workingEmailtoList);
						workingTOListAssertion(toListArray);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
					}
					break;
				case "CNBC":
					Collections.sort(ProducerDashboardGeneralPage.emailtoList);
					toListAssertion(toListArray);
					break;
				}

			} else if (status.equalsIgnoreCase("FULFILLED")) {
				switch (Constants.getFormName().toUpperCase()) {
				case "SINGLE CAMERA LIVE SHOT":
				case "EXTEND OR BRIDGE CREW & FACILITIES":
				case "ROCK CENTER":
					String division= Constants.getDivision().toLowerCase().replace(" ", "");
					try {
						
						
						if(! division.equalsIgnoreCase("acorn") || division.equalsIgnoreCase("ERGEvents") || division.equalsIgnoreCase("NBCNewsStudios") || division.equalsIgnoreCase("Olympics") ) {
							ProducerDashboardGeneralPage.emailtoList
							.add(ConfigFileReader.getProperty("prodreq-response-"+division, "emailconfig.properties"));
						}
						
						
						
						Collections.sort(ProducerDashboardGeneralPage.emailtoList);
						toListAssertion(toListArray);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						ProducerDashboardGeneralPage.emailtoList.remove(
								ConfigFileReader.getProperty("prodreq-response-"+division, "emailconfig.properties"));
					}
					break;
				}

			} else {

				Collections.sort(ProducerDashboardGeneralPage.emailtoList);
				toListAssertion(toListArray);
			}
		} else if (ToOrCCList.equals("CcList")) { //***************************** ELSE CASE **********//
			String cclist[] = EmailConstants.getEmailCcList().split(",");
			List<String> ccListArray = new ArrayList<String>();
			for (String item : cclist) {
				ccListArray.add(item);
			}
			Collections.sort(ccListArray);

			switch (Constants.getFormName().toUpperCase()) {
			case "EXTEND OR BRIDGE CREW & FACILITIES":
			case "ROCK CENTER":
			case "CNBC":
				if (status.equalsIgnoreCase("WORKING")) {
					switch (Constants.getFormName().toUpperCase()) {
					case "ROCK CENTER":
					case "EXTEND OR BRIDGE CREW & FACILITIES":
					case "SINGLE CAMERA LIVE SHOT":
						Collections.sort(ProducerDashboardGeneralPage.workingEmailCCList);
						workingCCListAssertion(ccListArray);
						break;
					case "CNBC":

						break;
					}
				} else if (status.equalsIgnoreCase("FULFILLED") || status.equalsIgnoreCase("CONFIRM CANCELLATION")
						|| status.equalsIgnoreCase("CANCELLED")) {

					switch (Constants.getFormName().toUpperCase()) {
					case "CNBC":
						try {
							ProducerDashboardGeneralPage.emailCCList.add(
									ConfigFileReader.getProperty("cnbc-fulfilled-pretape", "emailconfig.properties"));
							ProducerDashboardGeneralPage.emailCCList.add(
									ConfigFileReader.getProperty("cnbc-fulfilled-studio", "emailconfig.properties"));
							Collections.sort(ProducerDashboardGeneralPage.emailCCList);
							ccListAssertion(ccListArray);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							ProducerDashboardGeneralPage.emailCCList.remove(
									ConfigFileReader.getProperty("cnbc-fulfilled-pretape", "emailconfig.properties"));
							ProducerDashboardGeneralPage.emailCCList.remove(
									ConfigFileReader.getProperty("cnbc-fulfilled-studio", "emailconfig.properties"));
						}
						break;
					}

				} else {
					System.out.println("Email CC List    " + ProducerDashboardGeneralPage.emailCCList);
					System.out.println("Constant CC List " + ccListArray);
					Collections.sort(ProducerDashboardGeneralPage.emailCCList);
					ccListAssertion(ccListArray);
				}
				break;
				
			case "ANIMALS ON PREMISES":
				try {
					ProducerDashboardGeneralPage.emailCCList.add(
							ConfigFileReader.getProperty("animalsonpremises-completed", "emailconfig.properties"));
					Collections.sort(ProducerDashboardGeneralPage.emailCCList);
					ccListAssertion(ccListArray);
					ReportGenerate.test.log(Status.PASS,
							"CC DLs in Email is receiving as expected. Expected CC DLs : " + ccListArray + " Actual CC DLs : " +ProducerDashboardGeneralPage.emailCCList);
				} catch (Exception e) {
					e.printStackTrace();
					ReportGenerate.test.log(Status.FAIL,
							"CC DLs in Email is receiving is not expected. Expected CC DLs : " + ccListArray + " Actual CC DLs : " +ProducerDashboardGeneralPage.emailCCList+ "\n Error Msg : "+e.getMessage() );
				} finally {
				}
				break;
			case "FIREARMS ON PREMISES":
				try {
					ProducerDashboardGeneralPage.emailCCList.add(
							ConfigFileReader.getProperty("firearmsonpremises-completed", "emailconfig.properties"));
					Collections.sort(ProducerDashboardGeneralPage.emailCCList);
					ccListAssertion(ccListArray);
					ReportGenerate.test.log(Status.PASS,
							"CC DLs in Email is receiving as expected. Expected CC DLs : " + ccListArray + " Actual CC DLs : " +ProducerDashboardGeneralPage.emailCCList);
				} catch (Exception e) {
					e.printStackTrace();
					ReportGenerate.test.log(Status.FAIL,
							"CC DLs in Email is receiving is not expected. Expected CC DLs : " + ccListArray + " Actual CC DLs : " +ProducerDashboardGeneralPage.emailCCList+ "\n Error Msg : "+e.getMessage() );
				} finally {
				}
				break;
			}
		}
	}
	
}
