package fr.mga.livecoding;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ResultControllerTest {

    @MockitoAnnotations.Mock
    private ResultService resultService;

    @Test
    public void should_generate_json() {
        given(resultService.getResults()).willReturn(ResultFixture.generateResults());
        ResultController resultController = new ResultController(resultService);
        List<Result> results = resultController.generateJson();
        Assertions.assertThat(results).isEqualTo(ResultFixture.generateResults());
    }
}
