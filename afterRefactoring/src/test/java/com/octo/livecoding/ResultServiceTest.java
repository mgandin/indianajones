package com.octo.livecoding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceTest {

    @Mock ResultDao resultDao;

    @Test public void should_compute_result_from_db() {
        BDDMockito.given(resultDao.findAll()).willReturn(ResultFixture.generateResultsWithAlertMessage());
        ResultService resultService = new ResultService();
        resultService.setResultDao(resultDao);
        List<Result> results = resultService.getResults();
        Assert.assertEquals(ResultFixture.generateResultsWithAlertMessage(),results);
    }
}
