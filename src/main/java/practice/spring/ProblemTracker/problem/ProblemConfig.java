package practice.spring.ProblemTracker.problem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ProblemConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProblemRepository repository){
       return args -> {
          Problem preOrderTraversal = new Problem("Pre Order Traversal", "https://practice.geeksforgeeks.org/problems/preorder-traversal/1?page=1&status[]=unsolved&category[]=Tree&sortBy=difficulty" , "Basic", "Create an arraylist and a seprate function to recursively iterate through the left and right and add them to the list which prevents the duplication of list.", "Trees", LocalDate.now());


         // repository.save(preOrderTraversal);
       };
    }
}
