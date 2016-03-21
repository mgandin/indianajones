package fr.mga.livecoding;

import java.util.List;
import java.util.stream.Collectors;

public class PageGenerator {

    private ResultService resultService;

    public PageGenerator(ResultService resultService) {
        this.resultService = resultService;
    }

    public String generate() {
        List<Result> results = resultService.getResults();

        String pageXml = generateHeader();
		if (results.size() == 0) {
            pageXml += generateNoResult();

        } else {
            pageXml += generateResultHeader();
            pageXml += results.stream()
                    .map(Result::toXml)
                    .collect(Collectors.joining());
            pageXml += generateFooterResult();
        }
        pageXml += generateFooter();
        return pageXml;
	}

    private String generateFooter() {
        return "</report>";
    }

    private String generateFooterResult() {
        return "\t</results>\n";
    }

    private String generateResultHeader() {
        return "\t<results>\n";
    }

    private String generateNoResult() {
        return "\t<message>" + resultService.getMessage() + "</message>\n";
    }

    private String generateHeader() {
        String pageXml = "<report>\n";
        pageXml += "\t<title>";
        pageXml += "Quaterly Report";
        pageXml += "</title>\n";
        pageXml += "\t<frame>";
        pageXml += resultService.getFrame();
        pageXml += "</frame>\n";
        return pageXml;
    }

}
