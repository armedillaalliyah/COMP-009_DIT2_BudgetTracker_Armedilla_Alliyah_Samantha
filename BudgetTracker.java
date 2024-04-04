package COMP009;

import java.util.HashMap;
import java.util.Map;

public class BudgetTracker {
	private Map<String, Double> expenses;

    public BudgetTracker() {
        this.expenses = new HashMap<>();
    }

    public void addExpense(String category, double amount) {
        if (expenses.containsKey(category)) {
            double currentAmount = expenses.get(category);
            expenses.put(category, currentAmount + amount);
        } else {
            expenses.put(category, amount);
        }
    }

    public double getTotalExpense() {
        double total = 0.0;
        for (double amount : expenses.values()) {
            total += amount;
        }
        return total;
    }

    public double getCategoryExpense(String category) {
        return expenses.getOrDefault(category, 0.0);
    }

    public void printExpenses() {
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BudgetTracker tracker = new BudgetTracker();
        
        tracker.addExpense("Food", 1000);
        tracker.addExpense("Transportation", 500);
        tracker.addExpense("Food", 300);
        tracker.addExpense("Utilities", 200);
        
        System.out.println("Total Expenses: " + tracker.getTotalExpense());
        System.out.println("\nCategory-wise Expenses:");
        tracker.printExpenses();
    }
}
