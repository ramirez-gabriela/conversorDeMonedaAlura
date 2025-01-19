import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Conversor de Monedas ---");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Elija una opción: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        handleConversion(scanner);
                        break;
                    case 2:
                        exit = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido para la opción.");
            }
        }
        scanner.close();
    }

    private static void handleConversion(Scanner scanner) {
        try {
            System.out.println("\n--- Seleccione la moneda de origen ---");
            System.out.println("1. ARS (Peso Argentino)");
            System.out.println("2. BOB (Boliviano)");
            System.out.println("3. BRL (Real Brasileño)");
            System.out.println("4. CLP (Peso Chileno)");
            System.out.println("5. COP (Peso Colombiano)");
            System.out.println("6. USD (Dólar Estadounidense)");
            System.out.print("Elija una opción: ");

            int sourceOption = Integer.parseInt(scanner.nextLine());
            String sourceCurrency = getCurrencyCode(sourceOption);

            if (sourceCurrency == null) {
                System.out.println("Moneda no válida. Intente nuevamente.");
                return;
            }

            System.out.println("\n--- Seleccione la moneda de destino de la lista anterior ---");
            System.out.print("Opción: ");
            int targetOption = Integer.parseInt(scanner.nextLine());
            String targetCurrency = getCurrencyCode(targetOption);

            if (targetCurrency == null) {
                System.out.println("Moneda no válida. Intente nuevamente.");
                return;
            }

            double amount = -1;
            int attempts = 0;

            while (amount <= 0) {
                System.out.print("\nIngrese el monto a convertir: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());

                    if (amount <= 0) {
                        System.out.println("El monto debe ser mayor a 0. Intente nuevamente.");
                        attempts++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido para el monto.");
                    attempts++;
                }

                if (attempts >= 3) {
                    System.out.println("\n******************************************\n");
                    System.out.println("Número de intentos superado.");
                    System.out.println("Volviendo al menú, intente nuevamente con un valor válido.");
                    return;
                }
            }

            // Llamado a la clase que maneja las conversiones
            double convertedAmount = CurrencyConversion.convert(sourceCurrency, targetCurrency, amount);
            System.out.printf("El monto de: %.2f %s corresponde a %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);

        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Intente nuevamente.");
        }
    }

    private static String getCurrencyCode(int option) {
        return switch (option) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> null;
        };
    }
}


