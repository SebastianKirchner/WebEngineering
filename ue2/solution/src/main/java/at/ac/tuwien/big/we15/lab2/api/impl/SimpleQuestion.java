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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Question;

public class SimpleQuestion implements Question {

	private int id;
	
	private String text;

	private int value;

	private List<Answer> wrongAnswers;

	private List<Answer> rightAnswers;

	private Category category;

	public SimpleQuestion() {
		this.text = "";
		this.value = 60;
		this.wrongAnswers = new ArrayList<>();
		this.rightAnswers = new ArrayList<>();
		this.category = null;
	}

	public SimpleQuestion(int id, String text, int value, Category category) {
		super();
		this.id = id;
		this.text = text;
		this.value = value;
		this.wrongAnswers = new ArrayList<>();
		this.rightAnswers = new ArrayList<>();
		this.category = category;
	}

	public SimpleQuestion(int id, String text, int value, List<Answer> wrongChoices,
			List<Answer> correctChoices, Category category) {
		super();
		this.id = id;
		this.text = text;
		this.value = value;
		this.wrongAnswers = wrongChoices;
		this.rightAnswers = correctChoices;
		this.category = category;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public List<Answer> getAllAnswers() {
		List<Answer> allChoices = new ArrayList<>();

		allChoices.addAll(rightAnswers);
		allChoices.addAll(wrongAnswers);

		Collections.shuffle(allChoices);

		return allChoices;
	}

	@Override
	public List<Answer> getCorrectAnswers() {
		return rightAnswers;
	}

	@Override
	public void addAnswer(Answer answer, boolean isCorrect) {
		if (isCorrect) {
			rightAnswers.add(answer);
			answer.setQuestion(this);
		} else {
			wrongAnswers.add(answer);
			answer.setQuestion(this);
		}
	}

	@Override
	public void removeAnswer(Answer answer) {
		if (rightAnswers.contains(answer)) {
			rightAnswers.remove(answer);
		}
		if (wrongAnswers.contains(answer)) {
			wrongAnswers.remove(answer);
		}
	}

	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public void setCategory(Category category) {
		this.category = category;

		boolean updateCategory = true;

		for (Question question : category.getQuestions()) {
			if (question == this) {
				updateCategory = false;
				break;
			}
		}

		if (updateCategory) {
			category.addQuestion(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rightAnswers == null) ? 0 : rightAnswers.hashCode());
		result = prime * result + (int) (value ^ (value >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result
				+ ((wrongAnswers == null) ? 0 : wrongAnswers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleQuestion other = (SimpleQuestion) obj;
		if (rightAnswers == null) {
			if (other.rightAnswers != null)
				return false;
		} else if (!rightAnswers.equals(other.rightAnswers))
			return false;
		if (value != other.value)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (wrongAnswers == null) {
			if (other.wrongAnswers != null)
				return false;
		} else if (!wrongAnswers.equals(other.wrongAnswers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleQuestion [value=" + value + ", text=" + text 
				+ ", wrongChoices=" + wrongAnswers + ", correctChoices="
				+ rightAnswers + ", category=" + ((category != null)? category.getName() : "null") + "]";
	}

}
