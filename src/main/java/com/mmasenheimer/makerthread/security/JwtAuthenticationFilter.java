package com.mmasenheimer.makerthread.security;

import com.mmasenheimer.makerthread.services.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = extractToken(request);
            if(token != null) {
                UserDetails userDetails = authenticationService.validateToken(token);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);

                if(userDetails instanceof MakerThreadUserDetails) {
                    request.setAttribute("userId", ((MakerThreadUserDetails) userDetails).getId());
                }
            }else {
                // No token - set default test user for development
                setDefaultTestUser(request);
            }

        } catch(Exception ex) {
            // Not throwing exceptions, just don't authenticate the user
            log.warn("Received invalid auth token");
        }

        filterChain.doFilter(request, response);

    }
    private void setDefaultTestUser(HttpServletRequest request) {
        UUID testUserId = UUID.fromString("33b0fc10-49bc-47b1-9e3e-9e8090660549");
        request.setAttribute("userId", testUserId);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
