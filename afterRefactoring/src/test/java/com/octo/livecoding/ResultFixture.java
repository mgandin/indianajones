package com.octo.livecoding;

import java.util.ArrayList;
import java.util.List;

public class ResultFixture {
    public static List<Result> generateResults() {
        Result result = new Result();
        result.setNetProfit(4000.0);
        result.setOperatingExpense(4000.0);
        result.setManager("Mathieu");
        result.setDepartement("Media");
        result.setTurnover(9);
        result.setYear(2013);
        List<Result> results = new ArrayList<Result>();
        results.add(result);
        return results;
    }

    public static List<Result> generateResultsWithAlertMessage() {
        Result result = new Result();
        result.setNetProfit(40.0);
        result.setOperatingExpense(400000.0);
        result.setManager("Mathieu");
        result.setDepartement("Media");
        result.setTurnover(9);
        result.setYear(2013);
        List<Result> results = new ArrayList<Result>();
        results.add(result);
        return results;
    }
}
