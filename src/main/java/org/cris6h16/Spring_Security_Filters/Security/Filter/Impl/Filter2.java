package org.cris6h16.Spring_Security_Filters.Security.Filter.Impl;

import jakarta.servlet.*;

import java.io.IOException;

//@Component is commented, because Spring automatically add the filters
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        // example of a filter which affects the flow of the application

//        String key = (String) request.getAttribute("key"); // make sure first if that attribute exists
//        if (key != null && key.equals("12345") && false) {
//            throw new AccessDeniedException("Access Denied");
            /* we can create a customized exception

            public class
                myException extends ResponseStatusException ----> RuntimeException
                .....

                we can customize the response code, response, etc (single responsibility principle)
             */
//        }

        // do something before the rest of the application
        servletResponse.getWriter().println("Filter2, going to `DispatcherServlet`");
        servletResponse.flushBuffer();

        // invoke the rest of the application
        filterChain.doFilter(servletRequest, servletResponse);

//        // do something after the rest of the application
        servletResponse.getWriter().println("Filter2, going to `Client`");
        servletResponse.flushBuffer();
    }
}

