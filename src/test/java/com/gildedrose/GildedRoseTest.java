package com.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void qualityDecreaseBeforeSellByPassed() {
        Item item = new Item("foo", 1, 4);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(3, item.quality);
    }

    @Test
    public void qualityDecreaseTwiceAfterSellByPassed() {
        Item item = new Item("foo", 0, 4);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(2, item.quality);
    }

    @Test
    public void qualityIsNeverNegative() {
        Item item = new Item("foo", 0, 0);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertTrue(item.quality >= 0);
    }

    @Test
    public void agedBrieIncreasesInQualityOlderItGets() {
        Item item = new Item("Aged Brie", 1, 1);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", item.name);
        assertEquals(0, item.sellIn);
        assertEquals(2, item.quality);
    }

    @Test
    public void qualityOfAnItemIsNeverMoreThan_50_agedBrie() {
        Item item = new Item("Aged Brie", 1, 50);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", item.name);
        assertEquals(0, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void qualityOfAnItemIsNeverMoreThan_50() {
        Item item = new Item("foo", 2, 52);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(1, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
        Item item = new Item("Sulfuras", 1, 10);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras", item.name);
        assertEquals(1, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    public void qualityOfSulfurasIsNeverMoreThan_80() {
        Item item = new Item("Sulfuras", 2, 90);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras", item.name);
        assertEquals(2, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    public void backstagePassesIncreasesTwiceInQuality_lessThan10Days() {
        Item item = new Item("Backstage passes", 10, 2);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes", item.name);
        assertEquals(9, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    public void backstagePassesIncreasesTripleInQuality_lessThan5Days() {
        Item item = new Item("Backstage passes", 5, 2);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes", item.name);
        assertEquals(4, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    public void backstagePassesDecreaseQualityTo0AfterExpires() {
        Item item = new Item("Backstage passes", 0, 2);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Ignore
    public void conjuredItemsDegradeInQualityTwiceAsFastAsNormalItems() {
        Item item = new Item("Conjured", 1, 4);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", item.name);
        assertEquals(2, item.quality);
    }

    @Ignore
    public void conjuredItemsDegradeInQualityTwiceAsFastAsNormalItems_passedSellIn() {
        Item item = new Item("Conjured", 0, 4);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Ignore
    public void conjuredItemsQualityNeverNegative() {
        Item item = new Item("Conjured", 0, 1);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", item.name);
        assertEquals(0, item.quality);
    }
}