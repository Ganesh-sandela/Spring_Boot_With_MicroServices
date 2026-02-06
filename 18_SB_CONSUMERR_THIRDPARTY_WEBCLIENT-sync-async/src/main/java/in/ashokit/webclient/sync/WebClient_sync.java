package in.ashokit.webclient.sync;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
@Service
public class WebClient_sync {
	
	public void getClient() {
		
		String apiURL="https://dummyjson.com/quotes";
		WebClient webClient = WebClient.create();
		Mono<String> mono = webClient.get()
		         .uri(apiURL)
		         .retrieve()
		         .bodyToMono(String.class);
		String block = mono.block();
		System.out.println(block);
		
		System.out.println("...............................thankyou");
	}

}
