package fr.mga.livecoding;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PageGenerator {

    private final ResultService resultService;

    @Deprecated
    public PageGenerator() {
        this.resultService = new ResultService();
    }

    public PageGenerator(ResultService resultService) {
        this.resultService = resultService;
    }

    public String generate() {

		List<Result> results = resultService.getResults();
		String pageXml = new String();

        pageXml = generateHeader(pageXml);
		if (results.size() == 0) {
            pageXml = generateEmptyResult(pageXml);

        } else {
            pageXml = generateResultsHeader(pageXml);
            pageXml += results.stream()
                    .map(result -> generateResult(result))
                    .collect(joining());
            pageXml = generateResultsFooter(pageXml);
        }
        pageXml = generateFooter(pageXml);
        return pageXml;
	}

    public String generateFooter(String pageXml) {
        pageXml += "</report>";
        return pageXml;
    }

    public String generateResultsFooter(String pageXml) {
        pageXml += "\t</results>\n";
        return pageXml;
    }

    public String generateResult(Result result) {
        String pageXml = "\t\t<result>\n";
        pageXml += "\t\t\t<lob>" + result.getDepartement() + "</lob>\n";
        pageXml += "\t\t\t<manager>" + result.getManager() + "</manager>\n";
        pageXml += "\t\t\t<net>" + (result.getNetProfit() / 100) + "</net>\n";
        if(result.getUnderKpi()) {
            pageXml += "\t\t\t<alertNet>Alert : Net Profit too low</alertNet>\n";
        }
        pageXml += "\t\t\t<operatingExpense>" + (result.getOperatingExpense() / 100)
                + "</operatingExpense>\n";
        if (result.getHasTooMuchExpense()) {
            pageXml += "\t\t\t<alertExpense>Alert : Too much notes</alertExpense>\n";
        }
        pageXml += "\t\t\t<turnover>" + result.getTurnover() + "</turnover>\n";
        pageXml += "\t\t</result>\n";
        return pageXml;
    }

    public String generateResultsHeader(String pageXml) {
        pageXml += "\t<results>\n";
        return pageXml;
    }

    public String generateEmptyResult(String pageXml) {
        pageXml += "\t<message>" + resultService.getMessage() + "</message>\n";
        return pageXml;
    }

    public String generateHeader(String pageXml) {
        pageXml += "<report>\n";
        pageXml += "\t<title>";
        pageXml += "Quaterly Report";
        pageXml += "</title>\n";
        pageXml += "\t<frame>";
        pageXml += resultService.getFrame();
        pageXml += "</frame>\n";
        return pageXml;
    }

}
