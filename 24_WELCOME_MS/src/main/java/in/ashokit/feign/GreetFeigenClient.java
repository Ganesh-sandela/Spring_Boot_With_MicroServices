package in.ashokit.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="GREET-MS" )
public interface GreetFeigenClient {
	

	@GetMapping("/greet")
	public String invokedmethod();
}
