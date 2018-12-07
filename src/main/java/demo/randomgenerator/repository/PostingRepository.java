package demo.randomgenerator.repository;

import demo.randomgenerator.domain.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostingRepository extends JpaRepository<JobPosting, String> {

    Optional<JobPosting> findById(String id);

    @Query("SELECT j FROM JobPosting j"
            + " WHERE j.site like %?1% AND j.posting like %?2%")
    List<JobPosting> findBySiteAndPosting(String site, String posting);
}
