package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${truyum-auth-url}", name = "truyum-auth-service")
public interface TruyumAuthFeign {
	
	@PostMapping("/auth/validate")
	public boolean validateToken(@RequestBody String token);
}
