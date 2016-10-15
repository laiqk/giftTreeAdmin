package com.dept.web.controller;

import org.springframework.stereotype.Component;

@Component
public class JobController {

	public synchronized void excute() throws Exception {
		System.out.println("sssssnihao");
	}
}
