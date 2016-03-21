package fr.mga.livecoding;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.List;

public class ResultControllerTest {
    @Test public void should_generate_json() {
        ResultController resultController = new ResultController();
        List<Result> results = resultController.generateJson();
        Assertions.assertThat(results).isEqualTo(ResultFixture.generateResults());
    }
}
