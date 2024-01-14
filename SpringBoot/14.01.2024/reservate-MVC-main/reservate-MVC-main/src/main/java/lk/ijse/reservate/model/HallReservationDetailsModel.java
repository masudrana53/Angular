package lk.ijse.reservate.model;

import lk.ijse.reservate.dto.HallReservationDetails;
import lk.ijse.reservate.dto.RoomReservationDetails;
import lk.ijse.reservate.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallReservationDetailsModel {

    public static List<HallReservationDetails> getAll() throws SQLException {

        String sql = "SELECT * FROM HallReservationDetails";

        List<HallReservationDetails> data = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            data.add(new HallReservationDetails(
                    resultSet.getString(1),
                    resultSet.getString(2)
            ));
        }
        return data;
    }


    public static boolean save(String hallReservationId, String hallNumber) throws SQLException {
        String sql ="INSERT INTO HallReservationDetails(HallReservationId, HallNumber) VALUES(?, ?)";
        return CrudUtil.execute(sql, hallReservationId, hallNumber);
    }

    public static boolean remove(String hallNumber) throws SQLException {
        String sql = "DELETE FROM HallReservationDetails WHERE HallNumber = ?";
        return CrudUtil.execute(sql, hallNumber);
    }

    public static boolean removeH(String hallReservationId) throws SQLException {
        String sql = "DELETE FROM HallReservationDetails WHERE HallReservationId = ?";
        return CrudUtil.execute(sql, hallReservationId);
    }

    public static HallReservationDetails setFields(String hallnumber) throws SQLException {
        String sql = "SELECT * FROM HallReservationDetails WHERE HallNumber = ?";
        ResultSet resultSet = CrudUtil.execute(sql, hallnumber);
        if (resultSet.next()) {
            String hallReservationId = resultSet.getString(1);
            String HallNumber = resultSet.getString(2);
            return new HallReservationDetails(hallReservationId, HallNumber);
        }
        return null;
    }

    public static String getHall(String value) throws SQLException {
        String hallId;
        String sql = "SELECT * FROM HallReservationDetails WHERE HallReservationId = ?";
        ResultSet resultSet =CrudUtil.execute(sql, value);
        if (resultSet.next()){
            hallId= resultSet.getString("HallNumber");
            return hallId;
        }
        return null;
    }
}
