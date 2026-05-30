package com.psb.potential.services;

import com.psb.potential.text.prompttemplate.dtos.CountryCuisines;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAiService {

	private ChatClient chatClient;

    public OpenAiService(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
               // .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    public ChatResponse generateAnswer(String question) {
        return chatClient.prompt()
                .user(question)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "default"))
                .call()
                .chatResponse();
    }

    public String getTravelGuidance(String city, String month, String language, String budget) {
        PromptTemplate promptTemplate = new PromptTemplate("Welcome to the {city} travel guide!\n" +
                "If you're visiting in {month}, here's what you can do:\n" +
                "1. Must-visit attractions.\n" +
                "2. Local cuisine you must try.\n" +
                "3. Useful phrases in {language}.\n" +
                "4. Tips for traveling on a {budget} budget.\n" +
                "Enjoy your trip!");
        Prompt prompt = promptTemplate.create(Map.of("city", city, "month", month, "language", language, "budget", budget));
        return chatClient.prompt(prompt)
                .call()
                .chatResponse().getResult().getOutput().getText();
    }

    public CountryCuisines getCuisines(String country, String numCuisines, String language) {
        PromptTemplate promptTemplate = new PromptTemplate("You are an expert in traditional cuisines.\n" +
                "You provide information about a specific dish from a specific\n" +
                "country.\n" +
                "Answer the question: What is the traditional cuisine of {country}?\n" +
                "Return a list of {numCuisines} in {language}.\n" +
                "Avoid giving information about fictional places. If the country is\n" +
                "fictional\n" +
                "or non-existent answer: I don't know.");
        Prompt prompt = promptTemplate.create(Map.of("country", country, "numCuisines", numCuisines, "language", language));
        return chatClient.prompt(prompt)
                .call()
                .entity(CountryCuisines.class);
    }
}
