package com.example.asseco;

class CoinResponse {
    private int rightPerson;
    private int leftPerson;

    public CoinResponse(int rightPerson, int leftPerson) {
        this.rightPerson = rightPerson;
        this.leftPerson = leftPerson;
    }

    public int getRightPerson() {
        return rightPerson;
    }

    public int getLeftPerson() {
        return leftPerson;
    }
}
