package org.cris6h16.Spring_Security_Filters.Security.Filter.Impl;

import jakarta.servlet.*;

import java.io.IOException;

//@Component is commented, because Spring automatically add the filters
public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException {

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
        response.getWriter().println("Filter1, going to `DispatcherServlet`");
        response.flushBuffer();


        try {
            // invoke the rest of the application
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        // do something after the rest of the application
        response.getWriter().println("Filter1, going to `Client`");
        response.flushBuffer();
    }
}
