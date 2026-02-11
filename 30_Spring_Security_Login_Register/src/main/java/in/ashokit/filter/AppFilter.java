package in.ashokit.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.ashokit.service.CustomerService;
import in.ashokit.service.JwtService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@Component
public class AppFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtservice;

    @Autowired
    private CustomerService cserv;
    
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authheader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        if (authheader != null && authheader.startsWith("Bearer ")) {

            token = authheader.substring(7);
            username = jwtservice.extractUsername(token);
        }

        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = cserv.loadUserByUsername(username);

            if (jwtservice.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

       filterChain.doFilter(request, response);   // ⭐ VERY IMPORTANT
    }
}
