package com.api_pragas.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UUIDServices {
	
	public static String genUUID() {
		UUID uuid_ = UUID.randomUUID();
		return uuid_.toString().replace("-", "");
	}
}

