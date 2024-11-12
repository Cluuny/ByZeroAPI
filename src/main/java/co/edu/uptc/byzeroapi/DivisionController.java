package co.edu.uptc.byzeroapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DivisionController {
    private static final Logger logger = LoggerFactory.getLogger(DivisionController.class);
    private final Random random = new Random();

    @GetMapping("/divide")
    public String divideNumbers() {
        int a = random.nextInt(100) + 1;
        int b = random.nextInt(5);

        try {
            int result = a / b;
            return a + " / " + b + " = " + result;
        } catch (ArithmeticException e) {
            logger.error("Error al dividir por cero. Dividendo: " + a + ", Divisor: " + b);
            throw e;
        }
    }
}
