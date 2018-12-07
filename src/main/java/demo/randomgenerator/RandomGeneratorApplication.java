package demo.randomgenerator;

import demo.randomgenerator.domain.JobPosting;
import demo.randomgenerator.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@EnableScheduling
@RestController
public class RandomGeneratorApplication {
	public static int runs = 0;

	public static UUID id = UUID.randomUUID();

	public static Random random = new Random();

	@Autowired
	private PostingRepository postingRepository;

	public static void main(String[] args) {
		SpringApplication.run(RandomGeneratorApplication.class, args);
	}

	@RequestMapping(value = "/", produces = "application/json")
	public Map getRandom() {
		Map ret = new HashMap();
		ret.put("id", id);
		ret.put("runs", runs);
		ret.put("random", random.nextInt());
		return ret;
	}

	@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {

		List<JobPosting> bySiteAndPosting = postingRepository.findBySiteAndPosting("stackoverflow", "zalando retail software java");
		JobPosting jobPosting = null;
		if (bySiteAndPosting.isEmpty()) {
			jobPosting = JobPosting.builder().posting("zalando retail software java").site("stackoverflow").build();
		} else {
			jobPosting = bySiteAndPosting.get(0);
		}
		jobPosting.setHits(runs++);
		postingRepository.saveAndFlush(jobPosting);

	}
}
