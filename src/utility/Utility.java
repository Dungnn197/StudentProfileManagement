package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public final class Utility {

	/**
	 * Method to secure password by MD5
	 * 
	 * @param password
	 *            a String get from form
	 * 
	 * @return a hashed String by MD5
	 */
	public static String hashPassword(String password) {
		String myHash = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			byte[] digest = messageDigest.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return myHash;
	}

}
