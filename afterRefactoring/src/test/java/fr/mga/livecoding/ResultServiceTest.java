package fr.mga.livecoding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceTest {

    @MockitoAnnotations.Mock
    private ResultDao resultDao;

    @Test
    public void should_calculate_results() {
        ResultService resultService = new ResultService(new ResultDao());
        assertThat(resultService.getResults()).hasSize(5);
    }

    @Test
    public void should_calculate_one_result() {

        Result result = new Result();
        result.setNetProfit(4000.0);
        result.setOperatingExpense(4000.0);
        result.setManager("Mathieu");
        result.setDepartement("Media");
        result.setTurnover(9);
        result.setYear(2013);

        when(resultDao.findAll()).thenReturn(ResultFixture.generateResults());
        ResultService resultService = new ResultService(resultDao);
        List<Result> results = resultService.getResults();
        assertThat(results).hasSize(1);
        assertThat(results.get(0)).isEqualTo(result);
    }

    @Test
    public void should_calculate_with_alert() {
        when(resultDao.findAll()).thenReturn(ResultFixture.generateResultsWithAlert());
        ResultService resultService = new ResultService(resultDao);
        List<Result> results = resultService.getResults();
        assertThat(results).hasSize(5);
        results.stream().filter(result -> result.getDepartement() == "Media").forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());
        results.stream().filter(result -> result.getDepartement() == "Media").forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream().filter(result -> result.getDepartement() == "UX").forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());
        results.stream().filter(result -> result.getDepartement() == "UX").forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream().filter(result -> result.getDepartement() == "Bank").forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream().filter(result -> result.getDepartement() == "Indus").forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());
    }
}
