package com.example.asseco;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
class CoinMachineController {

    @PostMapping("/coins")
    public CoinResponse processTransactions(@RequestBody CoinRequest request) {

        int rightCoins = 3;
        int leftCoins = 3;

        List<Character> rightActions = request.getRightPerson();
        List<Character> leftActions = request.getLeftPerson();

        for (int i = 0; i < rightActions.size(); i++) {
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

        return new CoinResponse(rightCoins, leftCoins);
    }
}
