public abstract class Response {
/*
 * Methods used as part of Sending the Response to Client
 */
public static ResponseBuilder status(Status status) {...}
public static ResponseBuilder status(int status) {...}
public static ResponseBuilder ok() {...}
public static ResponseBuilder ok(Object entity) {...}
public static ResponseBuilder ok(Object entity, MediaType type) {...}
public static ResponseBuilder ok(Object entity, String type) {...}
public static ResponseBuilder ok(Object entity, Variant var) {...}
public static ResponseBuilder serverError() {...}
public static ResponseBuilder created(URI location) {...}
public static ResponseBuilder noContent() {...}
public static ResponseBuilder notModified() {...}
public static ResponseBuilder notModified(EntityTag tag) {...}
public static ResponseBuilder notModified(String tag) {...}
public static ResponseBuilder seeOther(URI location) {...}
public static ResponseBuilder temporaryRedirect(URI location) {...}
public static ResponseBuilder notAcceptable(List<Variant> variants) {...}
public static ResponseBuilder fromResponse(Response response) {...}
...
...
}