package javax.ws.rs.client.Client;

public interface WebTarget extends Configurable<WebTarget> 
{
  public URI getUri();
  public UriBuilder getUriBuilder();
  public WebTarget path(String path);
  public WebTarget resolveTemplate(String name, Object value);
  public WebTarget resolveTemplate(String name, Object value,  boolean encodeSlashInPath);
  public WebTarget resolveTemplateFromEncoded(String name, Object value);
  public WebTarget resolveTemplates(Map<String, Object> templateValues);
  public WebTarget resolveTemplates(Map<String, Object> templateValues, boolean encodeSlashInPath);
  public WebTarget resolveTemplatesFromEncoded(Map<String, Object> templateValues);
  public WebTarget matrixParam(String name, Object... values);
  public WebTarget queryParam(String name, Object... values);
  ...
}