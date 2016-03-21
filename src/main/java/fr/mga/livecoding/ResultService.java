package fr.mga.livecoding;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultService {

    private String frame;

    private ResultDao resultDao;

    @Autowired
    public ResultService(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public List<Result> getResults() {
        List<Result> resultList = resultDao.findAll();
        List<Result> results = new ArrayList<>();
        if(resultList.size() != 0) {
            int maxYear = 0;
            int minYear = 9999;
            results = resultList.stream()
                    .map(Result::compute)
                    .collect(Collectors.toList());
            maxYear = Math.max(maxYear, results.get(0).getYear());
            minYear = Math.min(minYear, results.get(0).getYear());
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
