package com.gildedrose;

class DefaultQualityHandler implements QualityHandler {

    @Override
    public void handleQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        limitMaxQuality(item);
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = item.quality - 2;
        limitMinQuality(item);
        limitMaxQuality(item);
    }

    protected void limitMinQuality(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    protected void limitMaxQuality(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

}