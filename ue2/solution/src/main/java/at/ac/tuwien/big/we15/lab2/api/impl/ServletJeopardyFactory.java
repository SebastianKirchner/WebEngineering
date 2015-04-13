/**
 * <copyright>
 *
 * Copyright (c) 2014 http://www.big.tuwien.ac.at All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */
package at.ac.tuwien.big.we15.lab2.api.impl;

import java.io.InputStream;

import javax.servlet.ServletContext;

import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;

public class ServletJeopardyFactory extends SimpleJeopardyFactory {

	private static final String DATA_FILE = "/WEB-INF/data.json";
	
	private ServletContext context;

	public ServletJeopardyFactory(ServletContext context) {
		this.context = context;
	}

	@Override
	public QuestionDataProvider createQuestionDataProvider() {
		InputStream inputStream = context.getResourceAsStream(DATA_FILE);
		return new JSONQuestionDataProvider(inputStream, this);
	}
}
