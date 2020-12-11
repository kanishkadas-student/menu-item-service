package com.cts.menuitem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.feign.TruyumAuthFeign;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	TruyumAuthFeign truyumAuthFeign;

	public boolean checkValidation(String token) {
		return truyumAuthFeign.validateToken(token);
	}

}
