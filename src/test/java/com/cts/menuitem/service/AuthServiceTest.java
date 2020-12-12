package com.cts.menuitem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.feign.TruyumAuthFeign;

@SpringBootTest
class AuthServiceTest {
	@Mock
	TruyumAuthFeign truyumAuthFeign;

	//test for authorization
	@Test
	void test() {
		AuthServiceImpl as = new AuthServiceImpl();
		as.truyumAuthFeign = truyumAuthFeign;
		when(truyumAuthFeign.validateToken("a")).thenReturn(true);
		assertEquals(true, as.checkValidation("a"));
	}

}
