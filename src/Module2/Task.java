package src.Module2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.transfer();
    }

    public static void transfer() {
        String inputFile = "C:\\Users\\burka_gqys6yk\\IdeaProjects\\ALevelModule1\\src\\Module2\\input.txt";
        String outputFile = "C:\\Users\\burka_gqys6yk\\IdeaProjects\\ALevelModule1\\src\\Module2\\output.txt";
        try {
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
            double averagePrice = Math.round(products.stream().mapToDouble(Product::getPrice).average().orElse(0.0) * 100.0) / 100.0;;
            List<Product> sortedProducts = products.stream()
                    .sorted(Comparator.comparing(Product::getPrice).reversed())
                    .collect(Collectors.toList());

            double totalCost = products.stream()
                    .mapToDouble(product -> product.getQuantity() * product.getPrice())
                    .sum();
            writeResultsToFile(outputFile, filteredProducts, totalQuantity, averagePrice, sortedProducts, totalCost);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeResultsToFile(String filePath, List<Product> filteredProducts,
                                           int totalQuantity, double averagePrice, List<Product> sortedProducts,
                                           double totalCost) {
        try {
            List<String> lines = Stream.<String>of(
                            "Отфильтрованные продукты:",
                            filteredProducts.stream().map(Product::toString).collect(Collectors.joining(System.lineSeparator())),
                            "",
                            "Общее количество продуктов в холодильнике: " + totalQuantity,
                            "Средняя цена продуктов: " + averagePrice,
                            "Продукты, отсортированные по цене в порядке убывания:",
                            sortedProducts.stream().map(Product::toString).collect(Collectors.joining(System.lineSeparator())),
                            "",
                            "Общая стоимость продуктов: " + totalCost
                    )
                    .collect(Collectors.toList());

            String[] linesArray = lines.toArray(new String[0]);
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}