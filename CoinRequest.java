package com.example.asseco;

import java.util.List;

class CoinRequest {
    private List<Character> rightPerson;
    private List<Character> leftPerson;

    public List<Character> getRightPerson() {
        return rightPerson;
    }

    public void setRightPerson(List<Character> rightPerson) {
        this.rightPerson = rightPerson;
    }

    public List<Character> getLeftPerson() {
        return leftPerson;
    }

    public void setLeftPerson(List<Character> leftPerson) {
        this.leftPerson = leftPerson;
    }
}