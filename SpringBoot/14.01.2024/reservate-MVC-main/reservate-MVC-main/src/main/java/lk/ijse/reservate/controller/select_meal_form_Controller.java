package lk.ijse.reservate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.reservate.dto.*;
import lk.ijse.reservate.dto.tm.mealDetailsTM;
import lk.ijse.reservate.model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class select_meal_form_Controller {

    @FXML
    private AnchorPane reservationPane;

    @FXML
    private JFXComboBox<String> cmbPackageId;

    @FXML
    private JFXComboBox<String> cmbGuestId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private JFXButton btnUpdateOrder;

    @FXML
    private JFXButton btnCancelOrder;

    @FXML
    private DatePicker date;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private TableView<mealDetailsTM> tblMealOrders;

    @FXML
    private TableColumn<?, ?> colPackageId;

    @FXML
    private TableColumn<?, ?> colMealPlan;

    @FXML
    private TableColumn<?, ?> colMealType;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;


    public void initialize(){
       loadGuestIds();
       loadPackageIds();
       generateNextId();
       date.setValue(LocalDate.now());
       setCellValueFactory();
       getall();
   }

    private void getall() {
        try {
            ObservableList<mealDetailsTM> obList = FXCollections.observableArrayList();


            List<MealPlans> list = MealPlansModel.getAll();



            for(MealPlans meal : list) {
                obList.add(new mealDetailsTM(
                        meal.getPackageId(),
                        meal.getMealPlan(),
                        meal.getMealType(),
                        meal.getDescription(),
                        meal.getPrice()
                ));
            }

            tblMealOrders.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Query error!").show();
        }
    }

    private void setCellValueFactory() {
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("PackageId"));
        colMealPlan.setCellValueFactory(new PropertyValueFactory<>("MealPlan"));
        colMealType.setCellValueFactory(new PropertyValueFactory<>("MealType"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }

    private void generateNextId() {
        try {
            String nextId = MealOrderModel.generateNextId();
            txtOrderId.setText(nextId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
        String OrderId = txtOrderId.getText();
        String GuestId = cmbGuestId.getValue();
        String PackageId = cmbPackageId.getValue();
        String Date = String.valueOf(date.getValue());
        String Qty    = txtQty.getText();

        boolean isMatch = Pattern.compile("^[0-9]+$").matcher(Qty).matches();
        if (isMatch){
            txtQty.setStyle("-fx-text-fill: black");
            if (OrderId.isEmpty() || GuestId.isEmpty() || PackageId.isEmpty() || Date.isEmpty() || Qty.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Cannot pass empty values!").show();
            }else{
                try{
                    boolean isSaved = MealOrderModel.Order(OrderId, GuestId, PackageId, Date, Qty,OrderId, PackageId);
                    if(isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "Meal Order Added!").show();
                    }
                }catch(Exception e){
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Invalid Data :/").show();
            txtQty.setStyle("-fx-text-fill: red");
        }

    }

   private void loadPackageIds() {
       try{
           List<String> packageIds = MealPlansModel.getIds();
           ObservableList<String> obList = FXCollections.observableArrayList();
           for(String pIds : packageIds){
               obList.add(pIds);
           }
           cmbPackageId.setItems(obList);
       }catch (SQLException e){
           e.printStackTrace();
           new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
       }
   }

   private void loadGuestIds() {
       try{
           List<String> gIds = GuestModel.getIds();
           ObservableList<String> obList = FXCollections.observableArrayList();
           for(String guestIds : gIds){
               obList.add(guestIds);
           }
           cmbGuestId.setItems(obList);
       }catch (SQLException e){
           e.printStackTrace();
           new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
       }
   }

    public void btnUpdateOrderOnAction(ActionEvent actionEvent) {
        String OrderId = txtOrderId.getText();
        String GuestId = cmbGuestId.getValue();
        String PackageId = cmbPackageId.getValue();
        String Date = String.valueOf(date.getValue());
        String Qty    = txtQty.getText();

        boolean isMatch = Pattern.compile("^[0-9]+$").matcher(Qty).matches();
        if (isMatch){
            txtQty.setStyle("-fx-text-fill: black");
            if (OrderId.isEmpty() || GuestId.isEmpty() || PackageId.isEmpty() || Date.isEmpty() || Qty.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Cannot pass empty values!").show();
            }else{
                try{
                    boolean isSaved = MealOrderModel.update(OrderId, GuestId, PackageId, Date, Qty);
                    if(isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "Meal Order Updated!").show();
                    }
                }catch(Exception e){
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Invalid Data :/").show();
            txtQty.setStyle("-fx-text-fill: red");
        }


    }

    public void btnCancelOrderOnAction(ActionEvent actionEvent) {
        String OrderId = txtOrderId.getText();
    try{
            boolean isSaved = MealOrderDetailsModel.remove(OrderId);
            try {
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Meal Order Removed!").show();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }

    }

    public void txtOrderIdOnAction(ActionEvent actionEvent) {
      String id = txtOrderId.getText();
       try {
          selectMeal meal= MealOrderModel.setFields(id);
           if (meal != null)
           {
               txtOrderId.setText(meal.getMealOrderId());
               cmbGuestId.setValue(meal.getGuestId());
               cmbPackageId.setValue(meal.getPackageId());
               date.setValue(LocalDate.parse(meal.getDate()));
               txtQty.setText(meal.getQty());
           } else {
               new Alert(Alert.AlertType.WARNING, "no Reservation found :(").show();
           }
       } catch (SQLException e) {
           new Alert(Alert.AlertType.ERROR, "oops! something went wrong :(").show();
       }




    }
}
