package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void get(String name, int amount) {
        if (!Storage.fruits.containsKey(name)) {
            throw new RuntimeException(name + " are not currently on sale.");
        }

        int currentAmount = Storage.fruits.get(name);

        if (currentAmount >= amount) {
            Storage.fruits.put(name, currentAmount - amount);
        }
    }
}
