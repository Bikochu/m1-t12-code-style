import java.util.Scanner;

// методы calculateSimplePercent и calculateComplexPercent принемают одни и теже параметры,
// и название аргументов в них было бы здорово назвать одинаково
public class DepositCalculator {
    // переменные a,y,d не несат смысловой нагрузки.
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }
    // отлично, название метода в стиле lowerСamelCase
    // В названиях переменных лучше не указывать тип переменной
    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return round(doubleAmount+doubleAmount * doubleYearRate *depositPeriod, 2);
    }

    double round(double value,int places) {
        // ScaLe -  переменные лучше писать в lowerСamelCase
        double ScaLe = Math.pow(10, places);
        return Math.round(value*ScaLe)/ScaLe;
    }

    void doImportantJob() {
        // Желательно каждую синтаксическаую конструкция языка писать на отдельной строке.
        int period, action ;
        // На одной строке выполняются разные конструкции.
        Scanner scanner = new Scanner(System.in); System.out.println("Введите сумму вклада в рублях:") ;
        // На одной строке выполняются разные конструкции.
        int amount = scanner.nextInt(); System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
            // В качестве отступа между последней скобкой метода и фигурной скобкой желательно использовать пробел
        } else if (action == 2){
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}
