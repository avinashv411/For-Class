public static abstract class ResponseBuilder {
public abstract Response build();
public abstract ResponseBuilder clone();
public abstract ResponseBuilder status(int status);
public ResponseBuilder status(Status status) {...}
public abstract ResponseBuilder entity(Object entity);
public abstract ResponseBuilder type(MediaType type);
public abstract ResponseBuilder type(String type);
public abstract ResponseBuilder variant(Variant variant);
public abstract ResponseBuilder variants(List<Variant> variants);
public abstract ResponseBuilder language(String language);
public abstract ResponseBuilder language(Locale language);
public abstract ResponseBuilder location(URI location);
public abstract ResponseBuilder contentLocation(URI location);
public abstract ResponseBuilder tag(EntityTag tag);
public abstract ResponseBuilder tag(String tag);
public abstract ResponseBuilder lastModified(Date lastModified);
public abstract ResponseBuilder cacheControl(CacheControl cacheControl);
public abstract ResponseBuilder expires(Date expires);
public abstract ResponseBuilder header(String name, Object value);
public abstract ResponseBuilder cookie(NewCookie... cookies);
}