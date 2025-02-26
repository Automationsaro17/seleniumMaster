package nbcu.framework.utils.Other;

public class CommonUtils {

	/**
	 * To generate random number for given range
	 * 
	 * @param start - minimum value
	 * @param end   - maximum value
	 * @return - random integer value
	 */
	public static int generateRamdomNumberForGivenRange(int start, int end) {
		int output = 0;
		try {
			output = (int) Math.floor(Math.random() * (end - start + 1) + start);
		} catch (Exception | Error e) {
			System.out.println(e);
			throw e;
		}
		return output;
	}

	/**
	 * To generate random alphanumeric value for given length
	 * 
	 * @param length - length of string
	 * @return - random string
	 */
	public static String generateRandomString(int length) {
		String output = "";
		try {
			// chose a Character random from this String
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

			// create StringBuffer size of AlphaNumericString
			StringBuilder sb = new StringBuilder(length);

			for (int i = 0; i < length; i++) {

				// generate a random number between
				// 0 to AlphaNumericString variable length
				int index = (int) (AlphaNumericString.length() * Math.random());

				// add Character one by one in end of sb
				sb.append(AlphaNumericString.charAt(index));
				output = sb.toString();
			}
		} catch (Exception | Error e) {
			System.out.println(e);
			throw e;
		}
		return output;
	}
	
	public static int findCountOfKeywordInString(String input, String keyword) {
		int output = 0;
		try {
			output=input.split(keyword).length-1;
		} catch (Exception | Error e) {
			System.out.println(e);
			throw e;
		}
		return output;
	}

	public static void main(String[] args) {
		generateRamdomNumberForGivenRange(2, 10);
	}
}
