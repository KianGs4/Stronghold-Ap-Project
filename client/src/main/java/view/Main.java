package view;

import controller.GameControllers.GameController;
import controller.GameControllers.GraphicsController;
import controller.GameControllers.SelectedBuildingController;
import controller.MapControllers.BuildingPlacementController;
import controller.UserControllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ConstantManager;
import model.Game.Game;
import model.Map.Map;
import model.Map.MapManager;
import model.Stronghold;
import model.User.Player;
import model.chatRoom.Chat;
import model.chatRoom.ChatManager;
import model.chatRoom.Message;
import model.enums.User.Color;
import view.GameMenus.GraphicGameMenu;
import view.MapMenus.dropBuildingMenu.GraphicBuildingPlacementMenu;
import view.UserMenus.LoginMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main extends Application {
    public static Stage mainStage;


//    @Override
//    public void start(Stage stage) throws Exception {
//        LoginMenu.setLoginController(new LoginController());
//        mainStage = stage;
//        new LoginMenu().start(stage);
//    }


    @Override
    public void start(Stage stage) throws Exception {
        HashMap<Color, Player> players = new HashMap<>();
        players.put(Color.RED, new Player(Stronghold.getInstance().getUser("ayeen")));
        players.put(Color.BLUE, new Player(Stronghold.getInstance().getUser("someone")));
        Map map = MapManager.load("1001");
        Game game = new Game(map, players, true);
        GameController gameController = new GameController(Stronghold.getInstance().getUser("ayeen"), game);
        GraphicGameMenu.setGameController(gameController);
        GraphicGameMenu graphicGameMenu = new GraphicGameMenu();
        GraphicGameMenu.setGraphicsController(new GraphicsController(gameController, game, graphicGameMenu));
        GraphicBuildingPlacementMenu.setController(new BuildingPlacementController(game.getCurrentPlayer(), map, true));
        SelectedBuildingController.setIsModifiable(true);
        mainStage = stage;
        graphicGameMenu.start(stage);
    }
}
