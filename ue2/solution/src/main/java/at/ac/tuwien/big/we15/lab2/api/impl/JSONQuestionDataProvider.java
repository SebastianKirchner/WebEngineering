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
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JSONQuestionDataProvider implements QuestionDataProvider {

	private InputStream inputStream;
	private JeopardyFactory factory;

	private Comparator<Question> questionSorter = new Comparator<Question>() {
		@Override
		public int compare(Question q1, Question q2) {
			if(q1 == null || q2 == null)
				throw new IllegalArgumentException("Questions can not be null.");
			return Integer.compare(q1.getValue(), q2.getValue());
		}
	};
	
	public JSONQuestionDataProvider(InputStream inputStream, JeopardyFactory factory) {
		this.inputStream = inputStream;
		this.factory = factory;
	}

	@Override
	public List<Category> getCategoryData() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Category.class, new CategoryDeserializer());
		gsonBuilder.registerTypeAdapter(Question.class, new QuestionDeserialzier());

		Gson gson = gsonBuilder.create();
		Type collectionType = new TypeToken<List<Category>>() {}.getType();
		List<Category> categories = gson.fromJson(
				new InputStreamReader(inputStream, Charsets.UTF_8), 
				collectionType);

		return categories;
	}

	protected class CategoryDeserializer implements JsonDeserializer<Category> {
		
		public static final String MEMBER_NAME = "name";
		public static final String MEMBER_QUESTIONS = "questions";
		
		@Override
		public Category deserialize(JsonElement json, Type type,
				JsonDeserializationContext context) throws JsonParseException {
			Category category = factory.createCategory();
			JsonObject object = json.getAsJsonObject();
			
			category.setName(object.get(MEMBER_NAME).getAsString());
			List<Question> questions = new ArrayList<>();
			
			for (JsonElement jsonquestion : object.get(MEMBER_QUESTIONS).getAsJsonArray()) {
				Question question = context.deserialize(
						jsonquestion,
						new TypeToken<Question>() {}.getType());
				questions.add(question);
			}
			
			Collections.sort(questions, questionSorter);
			category.setQuestions(questions);
			return category;
		}

	}

	protected class QuestionDeserialzier implements JsonDeserializer<Question> {
		
		public static final String MEMBER_ID = "id";
		public static final String MEMBER_TEXT = "text";
		public static final String MEMBER_VALUE = "value";
		public static final String MEMBER_WRONG_ANSWERS = "wrongAnswers";
		public static final String MEMBER_RIGHT_ANSWERS = "rightAnswers";
		
		private int lastChoiceId = 0;

		@Override
		public Question deserialize(JsonElement json, Type type,
				JsonDeserializationContext context) throws JsonParseException {

			JsonObject object = json.getAsJsonObject();

			Question question = factory.createQuestion();
			question.setId(object.get(MEMBER_ID).getAsInt());
			question.setText(object.get(MEMBER_TEXT).getAsString());

			for (JsonElement wrongAnswer : object.get(MEMBER_WRONG_ANSWERS).getAsJsonArray()) {
				SimpleAnswer answer = context.deserialize(
						wrongAnswer,
						new TypeToken<SimpleAnswer>() {}.getType());
				answer.setId(lastChoiceId++);
				question.addAnswer(answer, false);
			}
			
			question.setValue(object.get(MEMBER_VALUE).getAsInt());

			for (JsonElement correctChoice : object.get(MEMBER_RIGHT_ANSWERS).getAsJsonArray()) {
				SimpleAnswer answer = context.deserialize(
						correctChoice,
						new TypeToken<SimpleAnswer>() {}.getType());
				answer.setId(lastChoiceId++);
				question.addAnswer(answer, true);
			}

			return question;
		}

	}
}


