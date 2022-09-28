package coachingmateanalytics.coachingmate.service;

import org.springframework.http.HttpRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


public class HttpRequestAdapter implements oauth.signpost.http.HttpRequest
{
    private final HttpRequest request;
    private byte[] body;

    public HttpRequestAdapter(HttpRequest request, byte[] body)
    {
        this.request = request;
        this.body = body;
    }

    @Override
    public String getMethod()
    {
        return request.getMethod().name();
    }

    @Override
    public String getRequestUrl()
    {
        return request.getURI().toString();
    }

    @Override
    public void setRequestUrl(String url)
    {
        throw new UnsupportedOperationException("url can't be changed for spring request");
    }

    @Override
    public void setHeader(String name, String value)
    {
        this.request.getHeaders().set(name, value);
    }

    @Override
    public String getHeader(String name)
    {
        return this.request.getHeaders().getFirst(name);
    }

    @Override
    public Map<String, String> getAllHeaders()
    {
        return this.request.getHeaders().toSingleValueMap();
    }

    @Override
    public InputStream getMessagePayload() throws IOException
    {
        if (body == null)
        {
            return null;
        }
        return new ByteArrayInputStream(this.body);
    }

    @Override
    public String getContentType()
    {
        if (request.getHeaders().getContentType() == null)
        {
            return null;
        }
        return request.getHeaders().getContentType().toString();
    }

    @Override
    public Object unwrap()
    {
        return request;
    }
}