
import java.util.Stack;

class StockSpan {
    
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // To store span values
        Stack<Integer> stack = new Stack<>(); // Stores indices of prices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and current price is higher
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span: If stack is empty, all previous prices are smaller
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        // Print result
        System.out.print("Stock Span: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

