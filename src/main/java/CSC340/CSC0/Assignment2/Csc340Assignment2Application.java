package CSC340.CSC0.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Csc340Assignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Csc340Assignment2Application.class, args);
        getFruitFact();
    }

    public static void getFruitFact() {
        try {
            String url = "https://www.fruityvice.com/api/fruit/strawberry";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String fact = root.findValue("name").asText();
            String length = root.findValue("calories").asText();

            System.out.println("**********FRUIT FACT********");
            System.out.println("Name: " + fact);
            System.out.println("Number of Calories: " + length);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(assignment2ApiController.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getFruitFact");

        }
    }

}
