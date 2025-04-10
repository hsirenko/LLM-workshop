package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeGenerator{

	private final ChatClient chatClient;
	public RecipeGenerator(ChatClient.Builder builder) {
    	this.chatClient = builder.build();
	}

    @GetMapping("/recipe")
    public String generateRecipe(String instructions) {
		return chatClient.prompt("Generate a cooking recipe for a delicious dish.").call().content();
    }
}