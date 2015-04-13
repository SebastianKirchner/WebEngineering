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

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Question;

public abstract class SimpleJeopardyFactory implements JeopardyFactory {

	@Override
	public Category createCategory() {
		return new SimpleCategory();
	}

	@Override
	public Question createQuestion() {
		return new SimpleQuestion();
	}

	@Override
	public Answer createAnswer() {
		return new SimpleAnswer();
	}

}
