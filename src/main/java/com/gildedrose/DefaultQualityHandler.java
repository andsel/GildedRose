package com.gildedrose;

class DefaultQualityHandler implements QualityHandler {

    @Override
    public void handleQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

    }

}