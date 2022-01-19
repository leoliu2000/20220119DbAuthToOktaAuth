package com.liu.SecurityDemo1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller1 {

	@GetMapping("/")
	public String test1() {
		return "home";
	}

	@GetMapping("/userInfo")
	public String getMessageOfTheDay(@AuthenticationPrincipal OidcUser user) {
		return "ログインアカウント：" + user.getName();
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/email")
	public String getUserEmail(AbstractOAuth2TokenAuthenticationToken authentication) {
		// AbstractOAuth2TokenAuthenticationToken works for both JWT and opaque access
		// tokens
		return (String) authentication.getTokenAttributes().get("sub");
	}

	@GetMapping("/hello")
	public String test2() {
		return "hello";
	}

	@GetMapping("/abc")
	public String abc() {
		return "abc";
	}
}
