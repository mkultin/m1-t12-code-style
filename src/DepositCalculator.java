import java.util.Scanner;

public class DepositCalculator {
    double countComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundPercent(pay, 2);
    }

    double countSimplePercent(double amount, double yearRate, int period) {
        return roundPercent(amount + amount * yearRate * period, 2);
    }

    double roundPercent(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void launchingOfCalculator() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositBalance = 0;
        if (action == 1) {
            depositBalance = countSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositBalance = countComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositBalance);
    }

    public static void main(String[] args) {
        new DepositCalculator().launchingOfCalculator();
    }




}
