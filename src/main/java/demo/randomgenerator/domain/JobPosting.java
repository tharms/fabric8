package demo.randomgenerator.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "jobposting")
public class JobPosting {

    @Id
    @Column(name = "id", nullable = false)
    String id;

    @Column(name = "site", nullable = false)
    String site;

    @Column(name = "posting", nullable = false)
    String posting;

    @Column(name = "hits", nullable = false)
    Integer hits;

    @Column(name = "last_modification", nullable = true)
    Instant lastModification;

}