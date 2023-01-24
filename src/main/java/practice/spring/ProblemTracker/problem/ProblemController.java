package practice.spring.ProblemTracker.problem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/problems")
public class ProblemController {

    private final ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public List<Problem> getProblems(){
        return problemService.getProblems();
    }

    @PostMapping
    public void registerNewProblem(@RequestBody Problem[] problems){
        problemService.addNewProblems(problems);
    }

    @DeleteMapping(path = "{problemId}")
    public void deleteProblem(@PathVariable("problemId") Long problemId){
        problemService.deleteProblem(problemId);
    }

    @PutMapping(path = "{problemId}")
    public void updateProblem(
            @PathVariable("problemId") Long problemId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String solution,
            @RequestParam(required = false) String url){
        problemService.updateProblem(problemId, title, solution, url);
    }
}
