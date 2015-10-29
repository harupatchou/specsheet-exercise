package com.example.management.logic;

import org.springframework.stereotype.Component;

import com.example.management.form.SpecForm;
import com.example.management.page.SpecRegistConfirmPage;

@Component
public interface DevelopLogic {
	public SpecRegistConfirmPage hGenerateDevPage(SpecForm form);
		
}
