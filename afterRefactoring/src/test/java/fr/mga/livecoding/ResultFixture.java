package fr.mga.livecoding;

import fr.mga.livecoding.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultFixture {
    public static List<Result> generateResults() {
        Result result = generateResult(4000.0,4000.0,"Mathieu","Media",9,2013);
        List<Result> results = new ArrayList<>();
        results.add(result);
        return results;
    }

    public static List<Result> generateResultsWithAlert() {
        List<Result> results = new ArrayList<>();
        results.add(generateResult(4.0,4000000.0,"Mathieu","Media",9,2013));
        results.add(generateResult(4.0,4000000.0,"Mathieu","Bank",9,2013));
        results.add(generateResult(4.0,4000000.0,"Mathieu","Indus",9,2013));
        results.add(generateResult(4.0,4000000.0,"Mathieu","Mobile",9,2013));
        results.add(generateResult(4.0,4000000.0,"Mathieu","UX",9,2013));

        return results;
    }

    private static Result generateResult(double profit, double expense, String manager, String sector, int turnover, int year) {
        Result result = new Result();
        result.setNetProfit(profit);
        result.setOperatingExpense(expense);
        result.setManager(manager);
        result.setDepartement(sector);
        result.setTurnover(turnover);
        result.setYear(year);
        return result;
    }
}
