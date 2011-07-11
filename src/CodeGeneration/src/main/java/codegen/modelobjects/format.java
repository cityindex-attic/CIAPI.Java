package codegen.modelobjects;

import com.google.gson.annotations.SerializedName;

public enum format {
	decimal, 
	@SerializedName("wcf-date")
	wcf_date;
}
