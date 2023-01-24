package practice.spring.ProblemTracker.problem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository){
        this.problemRepository = problemRepository;
    }

    public List<Problem> getProblems(){
        return problemRepository.findAll();
    }

/*    public void addNewProblem(Problem problem){
        Optional<Problem> problemByUrl = problemRepository.findProblemByUrl(problem.getUrl());
        if(problemByUrl.isPresent()){
            throw new IllegalStateException("Question already in the database");
        }
        problemRepository.save(problem);

    }*/

    public void addNewProblems(Problem[] problems) {
        for(Problem problem : problems) {
            Optional<Problem> problemByUrl = problemRepository.findProblemByUrl(problem.getUrl());
            if(problemByUrl.isPresent()){
                throw new IllegalStateException("Question already in the database");
            }
        }
        problemRepository.saveAll(Arrays.asList(problems));
    }

    public void deleteProblem(Long problemId) {
        boolean exists = problemRepository.existsById(problemId);

        if(!exists){
            throw new IllegalStateException(
                    "Problem with id " +problemId + "doesnot exists"
            );
        }
        problemRepository.deleteById(problemId);
    }


    @Transactional
    public void updateProblem(Long problemId, String title, String solution, String url) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(() -> new IllegalStateException("Problem with id  doesnot exist"));

        if(title != null && title.length() > 0 && !Objects.equals(problem.getTitle(), title)){
            problem.setTitle(title);
        }

        if(url != null && url.length() > 0 && !Objects.equals(problem.getUrl(), url)){
            Optional<Problem> problemByUrl = problemRepository.findProblemByUrl(url);
            if(problemByUrl.isPresent()){
                throw new IllegalStateException("Problem already exist");
            }
            problem.setUrl(url);
        }
        if(solution != null && solution.length() > 0 && !Objects.equals(problem.getSolution(), solution)){
            problem.setSolution(solution);
        }

        problem.setDateSolved(LocalDate.now());
    }


}
