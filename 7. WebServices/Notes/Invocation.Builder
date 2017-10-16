package javax.ws.rs.client;

public interface Invocation 
{
	...
	public interface Builder extends SyncInvoker, Configurable<Builder> 
	{
		...
		public Builder accept(String... types);
		public Builder accept(MediaType... types
		public Builder acceptLanguage(Locale... locales);
		public Builder acceptLanguage(String... locales);
		public Builder acceptEncoding(String... encodings);
		public Builder cookie(Cookie cookie);
		public Builder cookie(String name, String value);
		public Builder cacheControl(CacheControl cacheControl);
		public Builder header(String name, Object value);
		public Builder headers(MultivaluedMap<String, Object> headers);
	}
}