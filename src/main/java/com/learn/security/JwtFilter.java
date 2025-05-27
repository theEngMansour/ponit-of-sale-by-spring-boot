package com.learn.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;


    protected void doFilterInternal(
            @jakarta.annotation.Nonnull HttpServletRequest request,
            @jakarta.annotation.Nonnull HttpServletResponse response,
            @jakarta.annotation.Nonnull FilterChain filterChain) throws IOException, ServletException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        Integer id = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            id = jwtUtil.extractUserId(token);
        }

        if (id != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailsService.loadUserById(id);
            if (jwtUtil.validateToken(token, userDetails)) {
                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                request.setAttribute("auth", id);

            }
        }
        filterChain.doFilter(request, response);
    }
}
