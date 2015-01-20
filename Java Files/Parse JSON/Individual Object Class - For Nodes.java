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

	public class LastReading{
		public String value;
		public String units;
		public String date_time;
	}

	public class TargetRange{
		public String low;
		public String high;
	}

	public String last_reading_range;

	@SerializedName("photoUrl")
	public String photo_url;
	@SerializedName("photoDate")
	public String photo_date;

}
