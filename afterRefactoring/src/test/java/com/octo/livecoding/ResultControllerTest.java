package com.octo.livecoding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ResultControllerTest {

    @Mock ResultService resultService;

    @Test public void should_generate_json() {
        BDDMockito.given(resultService.getResults()).willReturn(ResultFixture.generateResults());
        ResultController resultController = new ResultController();
        resultController.setResultService(resultService);
        List<Result> results = resultController.generateJson();
        Assert.assertEquals(ResultFixture.generateResults(),results);
    }
}
