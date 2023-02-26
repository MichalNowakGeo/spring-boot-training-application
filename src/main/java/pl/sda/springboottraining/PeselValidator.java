package pl.sda.springboottraining;

import org.springframework.stereotype.Component;

@Component
public class PeselValidator {

    boolean check(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            return false;
        }

        int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
        int suma = 0;
        for (int i = 0; i < 10; i++)
            suma += Integer.parseInt(pesel.substring(i, i+1)) * wagi[i];

        suma %= 10;
        suma = 10 - suma;
        suma %= 10;
        int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11));

        return suma == cyfraKontrolna;
    }
}