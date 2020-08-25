package by.epamtc.shamuradova.information_handling.server.controller.command;

import by.epamtc.shamuradova.information_handling.server.controller.command.impl.MaxCountOfEqualWords;
import by.epamtc.shamuradova.information_handling.server.controller.command.impl.SortSentencesInAscendingOrder;
import by.epamtc.shamuradova.information_handling.server.controller.command.impl.SwapFirstAndLastWords;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<Integer, Command> repositoryOperation = new HashMap<>();

    public CommandProvider() {
        repositoryOperation.put(1, new MaxCountOfEqualWords());
        repositoryOperation.put(2, new SortSentencesInAscendingOrder());
        repositoryOperation.put(3, new SwapFirstAndLastWords());
    }

    public Command getCommandOperation(int numberCommand) {
        return getCommand(numberCommand);
    }

    private Command getCommand(int numberCommand) {
//        try {
//            command = repositoryOperation.get(numberCommand);
//        } catch (IllegalArgumentException | NullPointerException e) {
//            command = repositoryOperation.get(0);
//        } COЗДАТЬ КОММАНДУ ДЛЯ СЛУЧАЕВ НЕПРВИЛЬНОГО ВВОДА НОМЕРА ОПЕРАЦИ!!!!!!!!

//            if (numberCommand < 1 || numberCommand > 3) {
//                command = repositoryOperation.get(0);
//            }
        return repositoryOperation.get(numberCommand);

    }
}
