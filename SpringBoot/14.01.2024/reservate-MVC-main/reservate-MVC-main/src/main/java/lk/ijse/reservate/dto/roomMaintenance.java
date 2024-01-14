package lk.ijse.reservate.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class roomMaintenance {
    private String RoomMaintenanceId;
    private String Date;
    private String startTime;
    private String EndTime;
    private String RoomNumber;
}
