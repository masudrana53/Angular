package lk.ijse.reservate.model;
import lk.ijse.reservate.db.DBConnection;
import lk.ijse.reservate.dto.Employee;
import lk.ijse.reservate.dto.User;
import lk.ijse.reservate.util.CrudUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {




    public static String generateNextUserId() throws SQLException {
        String sql = "SELECT UserId FROM User ORDER BY UserId DESC LIMIT 1";

        ResultSet resultSet = CrudUtil.execute(sql);
        if(resultSet.next()) {
            return splitUserId(resultSet.getString(1));
        }
        return splitUserId(null);
    }

    public static String splitUserId(String currentOrderId) {
        if(currentOrderId != null) {
            int lastNum = Integer.parseInt(currentOrderId.substring(1));
            int newNum = lastNum + 1;
            String newId = String.format("U%04d", newNum);
            return newId;
        }
        return "U0001";
    }

    public static boolean save(String userId, String empId, String userName, String password) throws SQLException {
        String sql ="INSERT INTO User(UserID, EmpId, UserName, Password) VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, userId, empId, userName, password);
    }

    public static List<String> getIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT UserId FROM user";
        List<String> UserIds = new ArrayList<>();
        ResultSet resultSet=con.createStatement().executeQuery(sql);
        while(resultSet.next()){
            UserIds.add(resultSet.getString(1));
        }
        return UserIds;
    }

    public static boolean update(String userId, String empId, String userName, String password) throws SQLException {
        String sql= "UPDATE user SET EmpId = ?, UserName = ?, Password = ? WHERE UserID = ?";
        return CrudUtil.execute(sql, empId, userName, password, userId);
    }

    public static boolean remove(String userId) throws SQLException {
        String sql ="DELETE FROM user WHERE UserID = ?";
        return CrudUtil.execute(sql, userId);
    }

    public static User setFields(String userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE UserID = ?";
        ResultSet resultSet = CrudUtil.execute(sql, userId);

        if(resultSet.next()) {

            String UserId= resultSet.getString(1);
            String EmpId= resultSet.getString(2);
            String UserName= resultSet.getString(3);
            String Password= resultSet.getString(4);


            return new User(UserId, EmpId, UserName, Password);
        }
        return null;
    }

    public static boolean empCheck(String empId) throws SQLException {
        String sql = "SELECT * FROM USER WHERE EmpId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, empId);
        if (resultSet.next()){
            return false;
        }else{
            return true;
        }
    }

    public static boolean elegibleCheck(String userName, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE UserName = ?";
        ResultSet resultSet =CrudUtil.execute(sql, userName);
        if (resultSet.next()){
            String userN = resultSet.getString("UserName");
            String pass = resultSet.getString("Password");
            if ((userN.equals(userName)) &&(pass.equals(password)) ) {
                return true;
            }
        }
        return false;
    }

    public static boolean getValid(String userName) throws SQLException {
        String sql = "SELECT * FROM user WHERE UserName = ?";
        ResultSet resultSet = CrudUtil.execute(sql, userName);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    public static boolean RecoverUpdate(String userName, String password) throws SQLException {
        String sql = "UPDATE user SET Password = ? WHERE UserName = ?";
        return CrudUtil.execute(sql,password, userName );
    }
}
