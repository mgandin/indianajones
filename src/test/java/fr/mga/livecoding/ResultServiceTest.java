package fr.mga.livecoding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceTest {

    @MockitoAnnotations.Mock
    private ResultDao resultDao;

    @Test
    public void should_get_all_result() {
        ResultService resultService = new ResultService(new ResultDao());
        List<Result> results = resultService.getResults();
        assertThat(results).hasSize(5);
    }

    @Test
    public void should_get_one_result() {
        Result result = new Result();
        result.setNetProfit(4000.0);
        result.setOperatingExpense(4000.0);
        result.setManager("Mathieu");
        result.setDepartement("Media");
        result.setTurnover(9);
        result.setYear(2013);
        given(resultDao.findAll()).willReturn(ResultFixture.generateResults());
        ResultService resultService = new ResultService(resultDao);
        List<Result> results = resultService.getResults();
        assertThat(results).containsExactly(result);
    }


    @Test
    public void should_generate_results_with_alert() {
        given(resultDao.findAll()).willReturn(ResultFixture.generateResultsWithAlert());
        ResultService resultService = new ResultService(resultDao);
        List<Result> results = resultService.getResults();
        results.stream()
                .filter(result -> result.getDepartement().equals("Media"))
                .forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());
        results.stream()
                .filter(result -> result.getDepartement().equals("Media"))
                .forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream()
                .filter(result -> result.getDepartement().equals("Media"))
                .forEach(result -> assertThat(result.getTooMuchExpenseMessage()).isEqualTo("Alert EXPENSE"));
        results.stream()
                .filter(result -> result.getDepartement().equals("Media"))
                .forEach(result -> assertThat(result.getUnderKpiMessage()).isEqualTo("Alert KPI"));

        results.stream()
                .filter(result -> result.getDepartement().equals("UX"))
                .forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());
        results.stream()
                .filter(result -> result.getDepartement().equals("UX"))
                .forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream()
                .filter(result -> result.getDepartement().equals("UX"))
                .forEach(result -> assertThat(result.getTooMuchExpenseMessage()).isEqualTo("Alert EXPENSE"));
        results.stream()
                .filter(result -> result.getDepartement().equals("UX"))
                .forEach(result -> assertThat(result.getUnderKpiMessage()).isEqualTo("Alert KPI"));

        results.stream()
                .filter(result -> result.getDepartement().equals("Bank"))
                .forEach(result -> assertThat(result.getUnderKpi()).isTrue());

        results.stream()
                .filter(result -> result.getDepartement().equals("Bank"))
                .forEach(result -> assertThat(result.getUnderKpiMessage()).isEqualTo("Alert KPI"));


        results.stream()
                .filter(result -> result.getDepartement().equals("Indus"))
                .forEach(result -> assertThat(result.getHasTooMuchExpense()).isTrue());

        results.stream()
                .filter(result -> result.getDepartement().equals("Indus"))
                .forEach(result -> assertThat(result.getTooMuchExpenseMessage()).isEqualTo("Alert EXPENSE"));
    }
}
