package com.example.asseco;

import org.springframework.http.ResponseEntity;

public class EstadoUtilizador {
    private int rightPerson;
    private int leftPerson;
    private String rightBoxStatus;
    private String leftBoxStatus;

    public EstadoUtilizador(int rightPerson, int leftPerson, String rightBoxStatus, String leftBoxStatus) {
        this.rightPerson = rightPerson;
        this.leftPerson = leftPerson;
        this.rightBoxStatus = rightBoxStatus;
        this.leftBoxStatus = leftBoxStatus;
    }

    public int getRightPerson() {
        return rightPerson;
    }

    public int getLeftPerson() {
        return leftPerson;
    }

    public String getRightBoxStatus() {
        return rightBoxStatus;
    }

    public String getLeftBoxStatus() {
        return leftBoxStatus;
    }
}

