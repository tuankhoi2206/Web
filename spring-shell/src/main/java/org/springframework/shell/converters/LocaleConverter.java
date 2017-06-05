/*
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.converters;

import java.util.List;
import java.util.Locale;

import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

/**
 * {@link Converter} for {@link Locale}. Supports locales with ISO-639 (ie 'en') or a combination of ISO-639 and
 * ISO-3166 (ie 'en_AU').
 * 
 * @author Stefan Schmidt
 * @since 1.1
 */
@Component
public class LocaleConverter implements Converter<Locale> {

	@Override
	public Locale convertFromText(final String value, final Class<?> requiredType, final String optionContext) {
		if (value.length() == 2) {
			// In case only a simpele ISO-639 code is provided we use that code also for the country (ie 'de_DE')
			return new Locale(value, value.toUpperCase());
		}
		else if (value.length() == 5) {
			String[] split = value.split("_");
			return new Locale(split[0], split[1]);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean getAllPossibleValues(final List<Completion> completions, final Class<?> requiredType,
			final String existingData, final String optionContext, final MethodTarget target) {
		return false;
	}

	@Override
	public boolean supports(final Class<?> requiredType, final String optionContext) {
		return Locale.class.isAssignableFrom(requiredType);
	}
}