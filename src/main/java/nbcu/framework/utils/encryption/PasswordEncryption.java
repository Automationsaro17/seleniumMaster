package nbcu.framework.utils.encryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PasswordEncryption {

	private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
	private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33,
			(byte) 0x10, (byte) 0x12, };

	/**
	 * Used only for testing / getting back the value for encrypted and decrypted
	 * string
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			System.out.println(decrypt("AFElotCGwcAVlZkvS2ievQ=="));
			
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To encrypt given string to this method
	 * 
	 * @param property - string to encrypt
	 * @return - Encrypted string
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
	}

	public static String base64Encode(byte[] bytes) {
		return new String(Base64.getMimeEncoder().encode(bytes), StandardCharsets.UTF_8);
	}

	/**
	 * To decrypt the given encrypted string
	 * 
	 * @param property - Encrypted password
	 * @return - original password
	 * @throws GeneralSecurityException
	 * @throws IOException
	 */
	public static String decrypt(String property) throws GeneralSecurityException, IOException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		String temp = new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
		temp = temp.substring(0, temp.length());
		return temp;
	}

	private static byte[] base64Decode(String property) {
		Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
		return mimeDecoder.decode(property);
	}
}
