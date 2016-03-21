package fr.mga.livecoding;

import java.util.List;

public class PageGenerator {
	
	public String generate() {

        ResultService service = new ResultService();
		List<Result> results = service.getResults();
		String pageXml = new String();

		pageXml += "<report>\n";
		pageXml += "\t<title>";
		pageXml += "Quaterly Report";
		pageXml += "</title>\n";
		pageXml += "\t<frame>";
        pageXml += service.getFrame();
        pageXml += "</frame>\n";
		if (results.size() == 0) {
            pageXml += "\t<message>" + service.getMessage() + "</message>\n";

		} else {
            pageXml += "\t<results>\n";
            for (Result result : results) {
                pageXml += "\t\t<result>\n";
                pageXml += "\t\t\t<lob>" + result.getDepartement() + "</lob>\n";
                pageXml += "\t\t\t<manager>" + result.getManager() + "</manager>\n";
                pageXml += "\t\t\t<net>" + (result.getNetProfit() / 100) + "</net>\n";
                if(result.getUnderKpiMessage()) {
                    pageXml += "\t\t\t<alertNet>Alert : Net Profit too low</alertNet>\n";
                }
                pageXml += "\t\t\t<operatingExpense>" + (result.getOperatingExpense() / 100)
                        + "</operatingExpense>\n";
                if (result.getTooMuchExpenseMessage()) {
                    pageXml += "\t\t\t<alertExpense>Alert : Too much notes</alertExpense>\n";
                }
                pageXml += "\t\t</result>\n";
            }
            pageXml += "\t</results>\n";
		}
		pageXml += "</report>";
		return pageXml;
	}

}
