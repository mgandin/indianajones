package com.octo.livecoding;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ResultControllerTest {
    @Test public void should_generate_json() {
        ResultController resultController = new ResultController();
        List<Result> results = resultController.generateJson();
        Assert.assertEquals(ResultFixture.generateResults(),results);
    }
}
