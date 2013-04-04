package com.octo.livecoding;

import java.util.List;

public class PageGenerator {

    private ResultService resultService;

    public PageGenerator(ResultService resultService) {
        this.resultService = resultService;
    }

    public PageGenerator() {
        ResultDao resultDao = new ResultDao();
        resultService = new ResultService();
        resultService.setResultDao(resultDao);
    }

    public String generate() {
		List<Result> results = resultService.getResults();
		String pageXml = new String();

        pageXml = generateReportHeader(pageXml);
		if (results.size() == 0) {
            pageXml = generateNoResultMessage(pageXml);

        } else {
            pageXml = generateResultsHeader(pageXml);
            for (Result result : results) {
                pageXml += result.generateHeader();
            }
            pageXml = generateResultsFooter(pageXml);
        }
        pageXml = generateFooter(pageXml);
        return pageXml;
	}

    private String generateFooter(String pageXml) {
        pageXml += "</report>";
        return pageXml;
    }

    private String generateResultsFooter(String pageXml) {
        pageXml += "\t</results>\n";
        return pageXml;
    }

    private String generateResultsHeader(String pageXml) {
        pageXml += "\t<results>\n";
        return pageXml;
    }

    private String generateNoResultMessage(String pageXml) {
        pageXml += "\t<message>" + resultService.getMessage() + "</message>\n";
        return pageXml;
    }

    private String generateReportHeader(String pageXml) {
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
