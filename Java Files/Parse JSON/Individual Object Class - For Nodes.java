//Note the serialized lines here, they are used to reference what the node/ returned item ACTUALLY says on the JSON data if your declared variable is a different name
import com.google.gson.annotations.SerializedName;

public class Patient {

	public String id;
	@SerializedName("firstName")
	public String first_name;
	@SerializedName("lastName")
	public String last_name;
	public String gender;
	@SerializedName("dateOfBirth")
	public String date_of_birth;
	public String last_reading_range;
	@SerializedName("photoUrl")
	public String photo_url;
	@SerializedName("photoDate")
	public String photo_date;

	/*
	These 2 objects pull from other classes with the same organizational structure as this one. 
	The ideas is that this class is the parent JSONObject and these 2 classes are
	Sub-classes of this one and can be referenced by GSON when made as an object this way.
	*/
	public LastReading lastReading;
	public TargetRange targetRange;
}
