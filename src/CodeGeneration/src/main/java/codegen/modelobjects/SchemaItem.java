package codegen.modelobjects;

import java.util.Map;


public class SchemaItem {
	private SchemaItemType ItemType;
	private String Id;
	private String Type;
	private String Ref;
	private boolean Required;
	private double Minimum;
	private double Maximum;
	private boolean ExclusiveMinimum;
	private boolean ExclusiveMaximum;
	private int MinItems;
	private int MaxItems;
	private boolean UniqueItems;
	private String Pattern;
	private String Title;
	private String Description;
	private String Format;
	private double DivisibleBy;
	private int MinLength;
	private int MaxLength;
	private SchemaItem[] Items;
	private SchemaItem[] Enum;
	private SchemaItem Default;
	private SchemaItem Extends;
	private Map<String, SchemaItem> Properties;
}
