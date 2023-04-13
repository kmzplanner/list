import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> productsList = new ArrayList<>();

        while (true) {
            System.out.println("Выбирите операцию:\r\n 1. Добавить\r\n 2. Показать\r\n 3. Удалить\r\n 4. Найти");
            String operationNumber = scanner.nextLine();
            if (operationNumber.equals("1")) {
                System.out.println("Какую покупку хотите добавить");
                String product = scanner.nextLine();
                productsList.add(product);
                System.out.println("Итого в списке покупок " + productsList.size());

            } else {
                if (operationNumber.equals("2")) {
                    outputList(productsList);

                } else {
                    if (operationNumber.equals("3")) {
                        outputList(productsList);
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        String productRemov = scanner.nextLine();
                        try {
                            int index = Integer.parseInt(productRemov);
                            productsList.remove((index+1));
                            outputList(productsList);
                        } catch (NumberFormatException exception){
                            productsList.remove(productRemov);
                            outputList(productsList);
                        }
                    } else {
                        if (operationNumber.equals("4")){
                            System.out.println("Введите текст для поиска");
                            String productSearch = scanner.nextLine();
                            String queryLower = productSearch.toLowerCase(Locale.ROOT);
                            System.out.println("Найдено:");
                            for (int i = 0; i < productsList.size(); i++){
                                String itemLower = productsList.get(i).toLowerCase(Locale.ROOT);
                                if (itemLower.contains(queryLower)){
                                    System.out.println((i + 1) + ". " + productsList.get(i));
                                }
                            }

                        }

                    }
                }
            }

        }
    }

    private static void outputList(ArrayList<String> arrayList) {
        System.out.println("Список покупок:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i));
        }
    }
}
