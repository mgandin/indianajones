package com.octo.livecoding;

import java.util.ArrayList;
import java.util.List;

public class ResultFixture {
    public static List<Result> generateResults() {
        Result result = generateResult(4000.0,4000.0,"Mathieu","Media",9,2013);
        List<Result> results = new ArrayList<Result>();
        results.add(result);
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
