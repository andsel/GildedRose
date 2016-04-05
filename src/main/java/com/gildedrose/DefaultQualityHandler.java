package com.gildedrose;

class DefaultQualityHandler implements QualityHandler {

    @Override
    public void handleQuality(Item item) {
        item.quality = item.quality - 1;
        limitMinMaxQuality(item);
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = item.quality - 2;
        limitMinMaxQuality(item);
    }

    protected void limitMinMaxQuality(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

}