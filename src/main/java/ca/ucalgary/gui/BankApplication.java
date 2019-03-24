package ca.ucalgary.gui;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.RepositoryService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankApplication extends Application {
    private RepositoryService repositoryService = new RepositoryService();
    private static Customer customer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        repositoryService.restoreAllRepositories();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bank-theme.fxml"));
        Parent content = (Parent)fxmlLoader.load();
        Scene bankScene = new Scene(content);
        primaryStage.setScene(bankScene);
        BankApplicationController bankController = fxmlLoader.<BankApplicationController>getController();
        bankController.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        repositoryService.saveAllRepositories();
        super.stop();
    }

    public static void setCustomer(Customer c){
        customer = c;
    }

    public static Customer getCustomer() {
        return customer;
    }
}
