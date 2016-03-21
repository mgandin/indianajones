package fr.mga.livecoding;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PageGeneratorTest {

    private String expectedXml = "<report>\n"
            + "\t<title>Quaterly Report</title>\n"
            + "\t<frame>2012 - 2012</frame>\n"
            + "\t<results>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>UX</lob>\n"
            + "\t\t\t<manager>Bob</manager>\n"
            + "\t\t\t<net>40.0</net>\n"
            + "\t\t\t<alertNet>Alert : Net Profit too low</alertNet>\n"
            + "\t\t\t<operatingExpense>80.0</operatingExpense>\n"
            + "\t\t\t<alertExpense>Alert : Too much notes</alertExpense>\n"
            + "\t\t\t<turnover>11</turnover>\n"
            + "\t\t</result>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>Media</lob>\n"
            + "\t\t\t<manager>Bob</manager>\n"
            + "\t\t\t<net>80.0</net>\n"
            + "\t\t\t<operatingExpense>40.0</operatingExpense>\n"
            + "\t\t\t<turnover>9</turnover>\n"
            + "\t\t</result>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>Bank</lob>\n"
            + "\t\t\t<manager>Bob</manager>\n"
            + "\t\t\t<net>40.0</net>\n"
            + "\t\t\t<alertNet>Alert : Net Profit too low</alertNet>\n"
            + "\t\t\t<operatingExpense>40.0</operatingExpense>\n"
            + "\t\t\t<turnover>10</turnover>\n"
            + "\t\t</result>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>Indus</lob>\n"
            + "\t\t\t<manager>Bob</manager>\n"
            + "\t\t\t<net>80.0</net>\n"
            + "\t\t\t<operatingExpense>80.0</operatingExpense>\n"
            + "\t\t\t<alertExpense>Alert : Too much notes</alertExpense>\n"
            + "\t\t\t<turnover>12</turnover>\n"
            + "\t\t</result>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>Mobile</lob>\n"
            + "\t\t\t<manager>Bob</manager>\n"
            + "\t\t\t<net>80.0</net>\n"
            + "\t\t\t<operatingExpense>40.0</operatingExpense>\n"
            + "\t\t\t<turnover>8</turnover>\n"
            + "\t\t</result>\n"
            + "\t</results>\n"
            + "</report>";

    private String expectedOneXml = "<report>\n"
            + "\t<title>Quaterly Report</title>\n"
            + "\t<frame>2013 - 2013</frame>\n"
            + "\t<results>\n"
            + "\t\t<result>\n"
            + "\t\t\t<lob>Media</lob>\n"
            + "\t\t\t<manager>Mathieu</manager>\n"
            + "\t\t\t<net>40.0</net>\n"
            + "\t\t\t<operatingExpense>40.0</operatingExpense>\n"
            + "\t\t\t<turnover>9</turnover>\n"
            + "\t\t</result>\n"
            + "\t</results>\n"
            + "</report>";

    @MockitoAnnotations.Mock
    private ResultService resultService;

    @Test
    public void should_generate_all_results_as_xml() {
        PageGenerator pageGenerator = new PageGenerator(new ResultService());
        String generatedXml = pageGenerator.generate();
        assertThat(generatedXml).isEqualTo(expectedXml);
    }

    @Test
    public void should_generate_one_result_as_xml() {
        given(resultService.getResults()).willReturn(ResultFixture.generateResults());
        given(resultService.getFrame()).willReturn("2013 - 2013");
        PageGenerator pageGenerator = new PageGenerator(resultService);
        String generatedXml = pageGenerator.generate();
        assertThat(generatedXml).isEqualTo(expectedOneXml);
    }

}
