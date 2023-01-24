package practice.spring.ProblemTracker.problem;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDate;

@Entity
@Table
public class Problem {

    @Id
    @SequenceGenerator(
            name = "problem_sequence",
            sequenceName = "problem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "generator_sequence"
    )


    private Long id;
    private String title;

    @Column(length = 1000)
    private String url;
    private String difficulty;

    @Column(length = 1000)
    private String solution;
    private String pattern;
    private LocalDate dateSolved;

    public Problem() {
    }

    public Problem(String title, String url, String difficulty, String solution, String pattern, LocalDate dateSolved) {
        this.title = title;
        this.url = url;
        this.difficulty = difficulty;
        this.solution = solution;
        this.pattern = pattern;
        this.dateSolved = dateSolved;
    }

    public Problem(Long id, String title, String url, String difficulty, String solution, String pattern, LocalDate dateSolved) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.difficulty = difficulty;
        this.solution = solution;
        this.pattern = pattern;
        this.dateSolved = dateSolved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getPattern() {
        return pattern;
    }


    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public LocalDate getDateSolved() {
        return dateSolved;
    }

    public void setDateSolved(LocalDate dateSolved) {
        this.dateSolved = dateSolved;
    }
    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", solution='" + solution + '\'' +
                ", pattern='" + pattern + '\'' +
                ", dateSolved=" + dateSolved +
                '}';
    }
}
