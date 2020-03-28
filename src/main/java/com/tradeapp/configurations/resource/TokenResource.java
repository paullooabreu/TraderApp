package com.tradeapp.configurations.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse res) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setSecure(false); // TODO em produção passar para True
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);

		res.addCookie(cookie);
		res.setStatus(HttpStatus.NO_CONTENT.value());
	}

}
