package com.mahwishriazjamil.interfaces;

import com.mahwishriazjamil.domain.Rate;

import java.util.Dictionary;

public interface ForexService {
	double getRateByCode(String code);
	Dictionary<String, Rate> getRates();
}
