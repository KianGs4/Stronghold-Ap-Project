package view.GameMenus;

import controller.GameControllers.TradeController;
import utils.SignupAndLoginUtils;
import view.Menu;
import view.enums.commands.TradeMenuCommand;
import view.enums.messages.TradeMenuMessage;

import java.util.HashMap;
import java.util.regex.Matcher;

public class TradeMenu {
    TradeController tradeController;

    public TradeMenu(TradeController tradeController) {
        this.tradeController = tradeController;
    }

    public String run() {
        String nextCommand;
        Matcher matcher;
        while (true) {
            nextCommand = Menu.getScanner().nextLine();
            TradeMenuCommand typeOfCommand = TradeMenuCommand.getCommand(nextCommand);
            if (typeOfCommand == null) {
                TradeMenuMessage.INVALID_COMMAND.printMessage();
                continue;
            }
            matcher = TradeMenuCommand.getMatcher(nextCommand, typeOfCommand);
            switch (typeOfCommand){
                case REQUEST:
                    requestRun(matcher);
                case BACK:
                    return "back";
            }
        }
    }

    private void requestRun(Matcher matcher) {
        HashMap<String, String> inputs = SignupAndLoginUtils.getInputs(matcher,TradeMenuCommand.REQUEST.getRegex());
        tradeController.request(inputs).printMessage();
    }
}
