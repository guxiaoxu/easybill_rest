package xgu.myproject.easybill.rest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import xgu.myproject.easybill.rest.security.service.SessionService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Component
@Order(1)
public class SessionTokenAuthFilter implements Filter
{
    private final static String TOKEN_HEADER_KEY = "Authorization";
    private final static String[] BY_PASS_URIS = {"/user"};

    @Autowired
    private SessionService sessionService;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException, IOException {

        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        String requestURI = httpRequest.getRequestURI();
        System.out.println("RequestURI: " + requestURI);
        if(!byPassURI(requestURI)){
            //extract token from header
            final String accessToken = httpRequest.getHeader(TOKEN_HEADER_KEY);
            Optional<String> userId = this.sessionService.checkToken(accessToken);

            if(!userId.isPresent()) {
                //invalid access token
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setHeader("WWW-Authenticate", "BASIC realm=\"REALM\"");
                httpResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                PrintWriter writer=response.getWriter();
                writer.println("{ \"message\" : \"Invalid Access Token\"}");
            } else {
                httpRequest.getSession().setAttribute("userId", userId.get());
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    private static boolean byPassURI(String requestURI) {
        for(String test : BY_PASS_URIS) {
            if (requestURI.startsWith(test)){
                return true;
            }
        }
        return false;
    }

}
