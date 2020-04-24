package com.simplerestclient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class URLBuilderTest {

    @Test
    public void shouldMountUrlWithSuccess() {
        URLBuilder urlBuilder = new URLBuilder();
        urlBuilder.addQueryParam("nome", "Wesley");
        urlBuilder.addQueryParam("sobrenome", "Inacio");
        urlBuilder.addQueryParam("idade", "27");

        String result = urlBuilder.getURL();
        String expected = "?nome=Wesley&sobrenome=Inacio&idade=27";

        Assert.assertEquals(expected, result);
    }
}
