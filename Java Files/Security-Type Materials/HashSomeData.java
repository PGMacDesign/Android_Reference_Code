import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//This class Shows off sha-512 Hashing techniques.
public class HashSomeData {

	public static void returnHashedString(String password) {

		System.out.println("Testing");
		
		String output = null;
		
		//Needed for creating hashable items
		MessageDigest messageDigest;
		
		//Need a try catch for algorithm errors
		try {
			//Get an instance of the sha-512. Can use any here, IE 256, 128
			messageDigest = MessageDigest.getInstance("SHA-512");

			//Additional item, helps prevent collisions to add more data in
			String additional_item = "There once was a man from nantuket...";
			String hash = password + additional_item;
			//Loop through it multiple times to create more entropy
			for (int i = 0; i < 100; i++) {
				//IMPORTANT, create a string first of NEW data being added in. DO NOT 
				//simply write: String str = hash as this will create more collisions
				String str = hash + password + additional_item;
				//Turn it into bytes via the messageDigest class
				messageDigest.update(str.getBytes());
				//Hash the data and set it = to the hash string.
				hash = new String(messageDigest.digest());
				//Print it out
				System.out.println("Encrypted String::" + hash + "::");
			}
			//Set it = to the output variable
			output = hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//Print the final version of it.
		System.out.println("Final Encrypted String = " + output);
		
		return output;
	}
}
