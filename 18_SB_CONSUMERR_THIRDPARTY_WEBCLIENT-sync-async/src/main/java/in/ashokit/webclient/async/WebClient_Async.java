package in.ashokit.webclient.async;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.Quote;
import in.ashokit.binding.QuoteResponse;
@Service
public class WebClient_Async {
	
	public void getclientAsync() {
		
		String apiURL="https://dummyjson.com/quotes";
		WebClient webClient = WebClient.create();
		System.out.println("=====request sending.......=====");
		webClient.get()
		         .uri(apiURL)
		         .retrieve().bodyToMono(QuoteResponse.class)
		         .subscribe(response->{
		        	handleresponse(response); 
		         });
		System.out.println("=====request sending completed=====");
	}
	
	private static void handleresponse(QuoteResponse response) {
		System.out.println(response);
		response.getQuotes().forEach(res->System.out.println(res));
		//future logic implememnt
		
	}

}
