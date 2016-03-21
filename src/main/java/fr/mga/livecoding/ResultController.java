package fr.mga.livecoding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Result> generateJson() {
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
}
