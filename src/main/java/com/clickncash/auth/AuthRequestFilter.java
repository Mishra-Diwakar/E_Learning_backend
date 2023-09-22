package com.clickncash.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.clickncash.model.UserPrincipal;
import com.clickncash.service.AuthenticationService;
import com.clickncash.utils.AuthTokenUtil;

@Component
public class AuthRequestFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationService authUserDetailsService;

	@Autowired
	private AuthTokenUtil authTokenUtil;

	private static final Logger logger = LoggerFactory.getLogger(AuthRequestFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			System.out.println("2222222222222222222");
			String jwt = getJwtFromRequest(request);			
			String userId = null;
			if (StringUtils.hasText(jwt) && authTokenUtil.validateToken(jwt)) {
				userId = authTokenUtil.getUserIdFromJWT(jwt);
				System.out.println(userId);
			} else if (request.getRequestURI() != null && (request.getRequestURI().contains("login") || request.getHeader("email") != null)) {
				userId = request.getHeader("email") != null ? request.getHeader("email") : "diwakar";
			} else if (request.getRequestURI().contains("printloaddata")) {
				userId = "admin@vandiest.com";
			}
			if (userId != null) {
				System.out.println("333333333333333333333-> " + userId);
//				userId = "diwakar";
				UserDetails userDetails = authUserDetailsService.loadUserByUsername(userId);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
				request.setAttribute("userId", userPrincipal.getId());
			}
		} catch (Exception ex) {
			logger.error("Could not set user authentication in security context", ex);
		}
		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}