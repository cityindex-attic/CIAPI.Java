package CIAPI.Java;

public interface RequestTranslator {

	public Object translateGetRequest(String url, Class<?> clazz);

	public Object translatePostRequest(String url, Object content, Class<?> clazz);

}
