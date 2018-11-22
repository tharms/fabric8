package demo.randomgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@RestController
public class RandomGeneratorApplication {
	public static UUID id = UUID.randomUUID();

	public static Random random = new Random();

	public static void main(String[] args) {
		SpringApplication.run(RandomGeneratorApplication.class, args);
	}

	@RequestMapping(value = "/", produces = "application/json")
	public Map getRandom() {
		Map ret = new HashMap();
		ret.put("id", id);
		ret.put("random", random.nextInt());
		return ret;
	}
}
