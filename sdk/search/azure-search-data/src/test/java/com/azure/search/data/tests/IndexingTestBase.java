// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search.data.tests;

import com.azure.search.data.customization.models.GeoPoint;
import com.azure.search.data.env.SearchIndexClientTestBase;
import com.azure.search.data.generated.models.IndexingResult;

import org.junit.Assert;
import org.junit.Test;

import com.azure.search.data.models.Hotel;
import com.azure.search.data.models.HotelAddress;
import com.azure.search.data.models.HotelRoom;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public abstract class IndexingTestBase extends SearchIndexClientTestBase {
    protected static final String INDEX_NAME = "hotels";

    @Override
    protected void beforeTest() {
        super.beforeTest();
        initializeClient();
    }

    @Test
    public abstract void countingDocsOfNewIndexGivesZero();

    @Test
    public abstract void indexDoesNotThrowWhenAllActionsSucceed();

    @Test
    public abstract void canIndexWithPascalCaseFields();

    @Test
    public abstract void indexWithInvalidDocumentThrowsException();

    @Test
    public abstract void canRoundtripBoundaryValues() throws Exception;

    protected abstract void initializeClient();

    protected void assertIndexActionSucceeded(String key, IndexingResult result, int expectedStatusCode) {
        Assert.assertEquals(key, result.key());
        Assert.assertTrue(result.succeeded());
        Assert.assertNull(result.errorMessage());
        Assert.assertEquals(expectedStatusCode, result.statusCode());
    }

    protected void waitFor(int seconds) {
        seconds = seconds * 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected List<Hotel> getBoundaryValues() throws ParseException {
        return Arrays.asList(
            // Minimum values
            new Hotel()
                .hotelId("1")
                .category("")
                .lastRenovationDate(DATE_FORMAT.parse("0001-01-01T00:00:00Z"))
                .location(GeoPoint.createWithDefaultCrs(-180, -90))   // South pole, date line from the west
                .parkingIncluded(false)
                .rating(Integer.MIN_VALUE)
                .tags(Arrays.asList())
                .address(new HotelAddress())
                .rooms(Arrays.asList(
                new HotelRoom()
                    .baseRate(Double.MIN_VALUE)
            )),
            // Maximum values
            new Hotel()
                .hotelId("2")
                .category("test")   // No meaningful string max since there is no length limit (other than payload size or term length).
                .lastRenovationDate(DATE_FORMAT.parse("9999-12-31T11:59:59Z"))
                .location(GeoPoint.createWithDefaultCrs(180, 90))     // North pole, date line from the east
                .parkingIncluded(true)
                .rating(Integer.MAX_VALUE)
                .tags(Arrays.asList("test"))    // No meaningful string max; see above.
                .address(new HotelAddress()
                    .city("Maximum"))
                .rooms(Arrays.asList(
                new HotelRoom()
                    .baseRate(Double.MAX_VALUE)
            )),
            // Other boundary values #1
            new Hotel()
                .hotelId("3")
                .category(null)
                .lastRenovationDate(null)
                .location(GeoPoint.createWithDefaultCrs(0, 0))     // Equator, meridian
                .parkingIncluded(null)
                .rating(null)
                .tags(Arrays.asList())
                .address(new HotelAddress()
                    .city("Maximum"))
                .rooms(Arrays.asList(
                new HotelRoom()
                    .baseRate(Double.NEGATIVE_INFINITY)
            )),
            // Other boundary values #2
            new Hotel()
                .hotelId("4")
                .location(null)
                .tags(Arrays.asList())
                .rooms(Arrays.asList(
                new HotelRoom()
                    .baseRate(Double.POSITIVE_INFINITY)
            )),
            // Other boundary values #3
            new Hotel()
                .hotelId("5")
                .tags(Arrays.asList())
                .rooms(Arrays.asList(
                new HotelRoom()
                    .baseRate(Double.NaN)
            )),
            // Other boundary values #4
            new Hotel()
                .hotelId("6")
                .category(null)
                .tags(Arrays.asList())
                .rooms(Arrays.asList()));
    }
}
