public enum Status 
{
	OK(200, "OK"),
	CREATED(201, "Created"),
	ACCEPTED(202, "Accepted"),
	NO_CONTENT(204, "No Content"),
	MOVED_PERMANENTLY(301, "Moved Permanently"),
	SEE_OTHER(303, "See Other"),
	NOT_MODIFIED(304, "Not Modified"),
	TEMPORARY_REDIRECT(307, "Temporary Redirect"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"),
	NOT_ACCEPTABLE(406, "Not Acceptable"),
	CONFLICT(409, "Conflict"),
	GONE(410, "Gone"),
	PRECONDITION_FAILED(412, "Precondition Failed"),
	UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	SERVICE_UNAVAILABLE(503, "Service Unavailable");
	
	public enum Family 
	{
		INFORMATIONAL, SUCCESSFUL, REDIRECTION,
		CLIENT_ERROR, SERVER_ERROR, OTHER
	}
	public Family getFamily()
	public int getStatusCode()
	public static Status fromStatusCode(final int statusCode)
	
}//End of Enum