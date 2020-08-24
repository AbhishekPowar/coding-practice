package design.usecase.businesshousegame.processor;

import design.usecase.businesshousegame.command.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandProcessor {

    private final static Map<String, Supplier<ICommand>> commandSupplierMap = new HashMap<>();

    static {
        commandSupplierMap.put("L", LotteryCommand::new);
        commandSupplierMap.put("H", HotelCommand::new);
        commandSupplierMap.put("J", JailCommand::new);
        commandSupplierMap.put("E", EmptyCommand::new);
    }

    public static List<ICommand> getCommandList(List<Integer> moves, String commandString) {
        List<ICommand> commandList = new ArrayList<>();
        final String[] commandCodes = commandString.split(",");

        int currStep = -1;

        for(int move: moves) {
            currStep += move;
            currStep %= commandCodes.length;
            commandList.add(commandSupplierMap.get(commandCodes[currStep]).get());
        }
        return commandList;
    }

    public static List<List<Integer>> getDiceMoves(String diceInput) {
        String[] diceMoveBatch = diceInput.split(" ");
        List<List<Integer>> movesBatchList = new ArrayList<>();

        for(String movesBatch: diceMoveBatch) {
            String[] moves = movesBatch.split(",");

            List<Integer> list =  Arrays.stream(moves)
                    .filter(CommandProcessor::isNumeric)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if(!list.isEmpty())
                movesBatchList.add(list);
        }

        int playerSize = movesBatchList.get(0).size();

        List<List<Integer>> playerMovesList = new ArrayList<>();

        for(int i=0; i<playerSize; i++)
            playerMovesList.add(new ArrayList<>());

        for(List<Integer> batch: movesBatchList) {
            for(int i=0; i<batch.size(); i++)
                playerMovesList.get(i).add(batch.get(i));
        }
        return playerMovesList;
    }

    private static boolean isNumeric(String number) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if(number == null || number.length() == 0)
            return false;
        return pattern.matcher(number).matches();
    }
}
