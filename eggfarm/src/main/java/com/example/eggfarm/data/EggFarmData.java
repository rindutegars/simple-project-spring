package com.example.eggfarm.data;

import org.springframework.stereotype.Component;

@Component
public class EggFarmData {

    private int totalEggs = 0;
    private int totalIncome = 0;
    public static final int PRICE_PER_EGG = 5000;

    public int getTotalEggs() {
        return totalEggs;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void addEggs(int quantity) {
        totalEggs += quantity;
        totalIncome += quantity * PRICE_PER_EGG;
    }
}
