package in.ashokit.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.Quote;
import in.ashokit.binding.QuoteResponse;
@Controller
public class QuoteController {
	
	@GetMapping("/quotes")
	public String getquotes(Model model) {
		
		String apiurl="https://dummyjson.com/quotes";
		RestTemplate rt= new RestTemplate();
		ResponseEntity<QuoteResponse> forEntity = rt.getForEntity(apiurl, QuoteResponse.class);
		
		QuoteResponse response = forEntity.getBody();
		model.addAttribute("quotes", response.getQuotes());
			
		return "index";
	}

}
