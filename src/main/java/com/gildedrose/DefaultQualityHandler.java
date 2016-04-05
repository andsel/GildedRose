package com.gildedrose;

class DefaultQualityHandler implements QualityHandler {

    @Override
    public void handleQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = item.quality - 2;
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