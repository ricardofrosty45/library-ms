package com.library.ms.utils;

import java.util.function.Supplier;

import com.library.ms.exceptions.UserException;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class ExceptionUtil {

	public Supplier<RuntimeException> throwsSupplierClientException(String message) {
		return () -> {
			log.info(message);
			throw new UserException(message);
		};
	}
}
