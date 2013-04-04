package com.octo.livecoding;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ResultService {

    private String frame;

    @Autowired
    private ResultDao resultDao;

    public List<Result> getResults() {
        List<Result> resultList = resultDao.findAll();
        List<Result> results = new ArrayList<Result>();
        if(resultList.size() != 0) {
            int maxYear = 0;
            int minYear = 9999;
            for (int i = 0; i < resultList.size(); i++) {
                Result result = resultList.get(i);
                if (result.getDepartement() != "Media" && result.getDepartement() != "Bank" && result.getDepartement() != "Indus") {
                    result.handleProfit(5000);
                    result.handleExpense(5000);
                    results.add(result);
                } else {
                    if (result.getDepartement() == "Media") {
                        result.handleProfit(7500);
                        result.handleExpense(4200);
                        results.add(result);
                    }
                    if(result.getDepartement() == "Bank") {
                        result.handleProfit(10000);
                        results.add(result);
                    }
                    if(result.getDepartement() == "Indus") {
                        result.handleExpense(1000);
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

    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }
}
