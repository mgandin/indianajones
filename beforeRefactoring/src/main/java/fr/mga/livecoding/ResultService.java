package fr.mga.livecoding;

import java.util.ArrayList;
import java.util.List;

public class ResultService {

    private String frame;

    public List<Result> getResults() {
        List<Result> resultList = ResultDao.query();
        List<Result> results = new ArrayList<Result>();
        if(resultList.size() != 0) {
            int maxYear = 0;
            int minYear = 9999;
            for (int i = 0; i < resultList.size(); i++) {
                Result result = resultList.get(i);
                if (result.getDepartement() != "Media" && result.getDepartement() != "Bank" && result.getDepartement() != "Indus") {
                    if(result.getNetProfit() < 5000) {
                        result.setUnderKpiMessage(true);
                    }
                    if(result.getOperatingExpense() >= 5000) {
                        result.setTooMuchExpenseMessage(true);
                    }
                    results.add(result);
                } else {
                    if (result.getDepartement() == "Media") {
                        if(result.getNetProfit() < 7500) {
                            result.setUnderKpiMessage(true);
                        }
                        if(result.getOperatingExpense() >= 4200) {
                            result.setTooMuchExpenseMessage(true);
                        }
                        results.add(result);
                    }
                    if(result.getDepartement() == "Bank") {
                        if(result.getNetProfit() < 10000) {
                            result.setUnderKpiMessage(true);
                        }
                        results.add(result);
                    }
                    if(result.getDepartement() == "Indus") {
                        if(result.getOperatingExpense() >= 1000) {
                            result.setTooMuchExpenseMessage(true);
                        }
                        results.add(result);
                    }
                }

                maxYear = Math.max(maxYear, result.getYear());
                minYear = Math.min(minYear, result.getYear());
            }
            frame = minYear+ " - " + maxYear;
        }
        return results;
    }

    public String getFrame() {
        return frame;
    }

    public String getMessage() {
        return "No result";
    }
}
