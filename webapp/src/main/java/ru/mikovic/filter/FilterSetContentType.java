package ru.mikovic.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class FilterSetContentType implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // читаем из конфигурации
        encoding = filterConfig.getInitParameter("requestEncoding");

        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        req.setCharacterEncoding(encoding);
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
