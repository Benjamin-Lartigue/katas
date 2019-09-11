import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

public class RPNCalculator {
    private Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    public RPNCalculator() {
        this.operations.put("+", (op1, op2) -> op1 + op2);
        this.operations.put("-", (op1, op2) -> op2 - op1);
        this.operations.put("*", (op1, op2) -> op1 * op2);
        this.operations.put("/", (op1, op2) -> op2 / op1);
    }

    public String send(String expression) {
        Deque<Integer> operands = new LinkedList<Integer>();
        for (String token : expression.split(" ")) {
            if (operations.containsKey(token)) {
                operands.push(operations.get(token).apply(operands.pop(), operands.pop()));
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.isEmpty() || operands.size() > 1 ? expression : Integer.toString(operands.pop());
    }
}
