package lk.ijse.reservate.model;

import lk.ijse.reservate.db.DBConnection;
import lk.ijse.reservate.dto.HallReservationDetails;
import lk.ijse.reservate.dto.RoomReservationDetails;
import lk.ijse.reservate.dto.roomReservation;
import lk.ijse.reservate.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomReservationDetailsModel {

    public static List<RoomReservationDetails> getAll() throws SQLException {

        String sql = "SELECT * FROM RoomReservationDetails";
        List<RoomReservationDetails> data = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            data.add(new RoomReservationDetails(
                    resultSet.getString(1),
                    resultSet.getString(2)
            ));
        }
        return data;
    }

    public static boolean save(String roomReservationId, String roomNumber) throws SQLException {
        String sql ="INSERT INTO RoomReservationDetails(RoomReservationId, RoomNumber) VALUES(?, ?)";
        return CrudUtil.execute(sql, roomReservationId, roomNumber);
    }

    public static boolean remove(String roomNumber) throws SQLException {
        String sql = "DELETE FROM RoomReservationDetails WHERE RoomReservationId = ?";
        return CrudUtil.execute(sql, roomNumber);
    }

    public static boolean removeR(String roomReservationId) throws SQLException {
        String sql = "DELETE FROM RoomReservationDetails WHERE RoomReservationId = ?";
        return CrudUtil.execute(sql, roomReservationId);
    }

    public static RoomReservationDetails setFields(String roomnumber) throws SQLException {
        String sql = "SELECT * FROM RoomReservationDetails WHERE RoomNumber = ?";
        ResultSet resultSet = CrudUtil.execute(sql, roomnumber);
        if (resultSet.next()) {
            String RoomReservationId = resultSet.getString(1);
            String RoomNumber = resultSet.getString(2);
            return new RoomReservationDetails(RoomReservationId, RoomNumber);
        }
        return null;
    }

    public static String getRoom(String value) throws SQLException {
        String roomId;
        String sql = "SELECT * FROM RoomReservationDetails WHERE RoomReservationId = ?";
        ResultSet resultSet =CrudUtil.execute(sql, value);
        if (resultSet.next()){
            roomId= resultSet.getString("RoomNumber");
            return roomId;
        }
        return null;
    }

}
