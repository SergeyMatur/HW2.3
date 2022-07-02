package pro.sky.hw2_3.contoller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw2_3.service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String greetings() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Должны быть переданы оба параметра!";
        }
        return buildResult(a, b, calculatorService.plus(a, b), "+");
        // проверяем в адресной строке c num1 = 1, num 2 = 2: http://localhost:8080/calculator/plus?num1=1&num2=2
        // Вывод: 1 + 2 = 3

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Должны быть переданы оба параметра!";
        }

        return buildResult(a, b, calculatorService.minus(a, b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Должны быть переданы оба параметра!";
        }
        return buildResult(a, b, calculatorService.multiply(a, b), "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a,
                           @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Должны быть переданы оба параметра!";
        }
        if (b == 0) {
            return "На ноль делить нельзя!";
        }
        return buildResult(a, b, calculatorService.divide(a, b), "/");
    }

    private String buildResult(Integer a, Integer b, Number result, String operation) {
        return String.format("%s, %s, %s = %s", a, operation, b, result);

    }

}
