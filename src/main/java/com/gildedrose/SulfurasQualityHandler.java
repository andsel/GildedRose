package com.gildedrose;

class SulfurasQualityHandler implements QualityHandler {
    @Override
    public void handleQuality(Item item) {
        item.quality = 80;
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = 80;
    }
}
