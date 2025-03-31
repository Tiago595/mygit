package com.example.asseco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControladorMaquinaMoeda {

    @PostMapping("/escolha")
    public ResponseEntity<EstadoUtilizador> Escolha(@RequestBody PedidoLado request) {
        int postoDir = 0;
        int postoEsq = 0;

        List<Character> rightActions = request.getRightPerson();
        List<Character> leftActions = request.getLeftPerson();

       // for (int i = 0; i < 2 && i < rightActions.size() && i < leftActions.size(); i++) {
         //   char rightAction = rightActions.get(i);
        // char leftAction = leftActions.get(i);
        if (rightActions.size() > 1 || leftActions.size() > 1) {
            return ResponseEntity.badRequest().body(
                    new EstadoUtilizador(postoDir, postoEsq, "Posto Ocupado", "Posto Ocupado")
            );
        }
        char rightAction = rightActions.isEmpty() ? 'X' : rightActions.get(0);
        char leftAction = leftActions.isEmpty() ? 'X' : leftActions.get(0);

            if (rightAction == 'D' && postoDir < 1) {
                postoDir++;
            } else {
                return ResponseEntity.badRequest().body(new EstadoUtilizador(postoDir, postoEsq, "Posto da direita Livre", "Posto da Esuqerda Ocupado"));
            }

            if (leftAction == 'E' && postoEsq < 1) {
                postoEsq++;
            } else {
                return ResponseEntity.badRequest().body(new EstadoUtilizador(postoDir, postoEsq, "Posto da Direita Ocupado", "Posto da Esquerda Livre"));
            }

        return ResponseEntity.ok(new EstadoUtilizador(postoDir, postoEsq, "Partilhar ou Receber?", "Partilhar ou Receber?"));
    }

    @PostMapping("/coins")
    public ResponseEntity<EstadoMoeda> Transacao(@RequestBody PedidoMoeda request) {
        int rightCoins = 3;
        int leftCoins = 3;

        List<Character> rightActions = request.getRightPerson();
        List<Character> leftActions = request.getLeftPerson();

        for (int i = 0; i < rightActions.size() && i < leftActions.size(); i++) {
            char rightAction = rightActions.get(i);
            char leftAction = leftActions.get(i);

            if (rightAction == 'P' && rightCoins > 0) {
                rightCoins--;
                leftCoins += 3;
            }
            if (leftAction == 'P' && leftCoins > 0) {
                leftCoins--;
                rightCoins += 3;
            }
        }

        return ResponseEntity.ok(new EstadoMoeda(rightCoins, leftCoins));
    }
}