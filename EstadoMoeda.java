package com.example.asseco;

public class EstadoMoeda {
    private int rightCoins;
    private int leftCoins;

    public EstadoMoeda(int rightCoins, int leftCoins) {
        this.rightCoins = rightCoins;
        this.leftCoins = leftCoins;
    }

    public int getRightCoins() {
        return rightCoins;
    }

    public int getLeftCoins() {
        return leftCoins;
    }
}
