package lk.ijse.reservate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.reservate.dto.Hall;
import lk.ijse.reservate.dto.MealPlans;
import lk.ijse.reservate.model.HallModel;
import lk.ijse.reservate.model.MealPlansModel;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class halls_form_Controller {

    @FXML
    private AnchorPane reservationPane;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtHallNumber;

    @FXML
    private JFXComboBox<String> cmbStatus;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdatehall;
    @FXML
    private  JFXComboBox<String> cmbHallType;

    public void initialize(){
        generateNextId();
        setStatus();
        setType();
    }

    private void setType() {
        ObservableList<String> data = FXCollections.observableArrayList(
                "A/C",
                "Non A/C"
        );
        cmbHallType.setItems(data);
    }

    private void generateNextId() {
        try {
            String nextId = HallModel.generateNextId();
            txtHallNumber.setText(nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setStatus(){
        ObservableList<String> data = FXCollections.observableArrayList(
                "Available",
                "Under Maintenance"
        );
        cmbStatus.setItems(data);
    }

    @FXML
    void btnAddHallOnAction(ActionEvent event) {

        String HallNumber =txtHallNumber.getText();
        String HallType = cmbHallType.getValue();
        String Price=txtPrice.getText();
        String HallStatus  = String.valueOf(cmbStatus.getValue());
        boolean isMatch = Pattern.compile("^\\d+(\\.\\d{1,2})?$").matcher(Price).matches();

        if (isMatch){
            txtPrice.setStyle("-fx-text-fill: black");
            if (HallNumber.isEmpty() || HallType.isEmpty() || Price.isEmpty() || HallStatus. isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Cannot pass empty values!").show();
            }else{
                try{
                    boolean isSaved = HallModel.save(HallNumber, HallType, Price, HallStatus);
                    if(isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "Hall Added!").show();
                    }
                }catch(Exception e){
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid Data :/").show();
            txtPrice.setStyle("-fx-text-fill: red");
            txtPrice.setText(Price);
        }

    }

    public void btnUpdateHallOnAction(ActionEvent actionEvent) {
        String HallNumber =txtHallNumber.getText();
        String HallType = cmbHallType.getValue();
        String Price= txtPrice.getText();
        String HallStatus  = String.valueOf(cmbStatus.getValue());

        boolean isMatch = Pattern.compile("^\\d+(\\.\\d{1,2})?$").matcher(Price).matches();

        if (isMatch){
            txtPrice.setStyle("-fx-text-fill: black");
            if (HallNumber.isEmpty() || HallType.isEmpty() || Price.isEmpty() || HallStatus. isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Cannot pass empty values!").show();
            }else{
                try{
                    boolean isSaved = HallModel.update(HallNumber, HallType, Price, HallStatus);
                    if(isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "Hall Updated!").show();
                    }
                }catch(Exception e){
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Invalid Data :/").show();
            txtPrice.setStyle("-fx-text-fill: red");
            txtPrice.setText(Price);
        }

    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        String HallNumber =txtHallNumber.getText();
        try{
            boolean isSaved = HallModel.remove(HallNumber);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Hall Removed!").show();
            }
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }
    }

    public void txtHallNumberOnAction(ActionEvent actionEvent) {
        String HallNumber = txtHallNumber.getText();
        try {
            Hall hall = HallModel.setFields(HallNumber);
            if (hall != null)
            {
                txtHallNumber.setText(hall.getHallNumber());
                cmbHallType.setValue(hall.getHallType());
                txtPrice.setText(String.valueOf(hall.getPrice()));
                cmbStatus.setValue(hall.getStatus());

            } else {
                new Alert(Alert.AlertType.WARNING, "no Hall found :(").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "oops! something went wrong :(").show();
        }
    }
}
