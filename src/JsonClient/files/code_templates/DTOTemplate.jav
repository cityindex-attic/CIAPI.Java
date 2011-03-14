package <@packageName@>;

/**
 * !This is an auto generated model object!
 *
 * <@description@>
 */
public class <@name@> {

	/**
	 * No argument constructor
	 */
	public <@name@>() {
	}

	/* Commented out for now because I'm not sure how do deal with the trailing comma. (Otherwise it works)

	public <@name@>(<@@constructorParams@@><@propertyType@> <@propertyName@>,<@@@@>) {
		<@@constructorBody@@>
			this.<@propertyName@> = <@propertyName@>;
		<@@@@>
	}
	
	*/

	<@@properties@@>
	private <@propertyType@> <@propertyName@>;
	
	public <@propertyType@> get<@propertyName@>() {
		return <@propertyName@>;
	}
	<@@@@>
}
