package fr.mga.livecoding;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ResultControllerTest {


    @Test public void should_generate_json() {
        ResultService resultService = new ResultService();
        ResultController resultController = new ResultController(resultService);
        List<Result> results = resultController.generateJson();
        assertThat(results).hasSize(5);
    }

}
