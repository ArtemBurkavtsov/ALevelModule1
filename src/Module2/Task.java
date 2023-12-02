package src.Module2;

import src.Module2.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        try {
            task.transfer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transfer() throws IOException {
        String inputFile = "C:\\Users\\burka_gqys6yk\\IdeaProjects\\ALevelModule1\\src\\Module2\\input.txt";
        String outputFile = "C:\\Users\\burka_gqys6yk\\IdeaProjects\\ALevelModule1\\src\\Module2\\output.txt";
        List<Product> products = Files.lines(Paths.get(inputFile))
                .map(line -> {
                    String[] parts = line.split("\\|");
                    String name = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    double price = Double.parseDouble(parts[2].trim());
                    return new Product(name, quantity, price);
                })
                .collect(Collectors.toList());

        int filterQuantity = 3;
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getQuantity() > filterQuantity)
                .collect(Collectors.toList());

        int totalQuantity = products.stream().mapToInt(Product::getQuantity).sum();

        double totalCost = products.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();

        double averagePrice = Math.round((totalCost / totalQuantity) * 100.0) / 100.0;

        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparing(product -> product.getQuantity() * product.getPrice(), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        writeResultsToFile(outputFile, filteredProducts, totalQuantity, averagePrice, sortedProducts, totalCost);
    }

    private void writeResultsToFile(String filePath, List<Product> filteredProducts,
                                    int totalQuantity, double averagePrice, List<Product> sortedProducts,
                                    double totalCost) throws IOException {
        List<String> lines = List.of(
                "Отфильтрованные продукты:",
                filteredProducts.stream().map(Product::toString).collect(Collectors.joining(System.lineSeparator())),
                "",
                "Общее количество продуктов в холодильнике: " + totalQuantity,
                "Средняя цена продуктов: " + averagePrice,
                "Продукты, отсортированные по цене в порядке убывания:",
                sortedProducts.stream().map(Product::toString).collect(Collectors.joining(System.lineSeparator())),
                "",
                "Общая стоимость продуктов: " + totalCost
        );

        Files.write(Paths.get(filePath), lines);
    }
}