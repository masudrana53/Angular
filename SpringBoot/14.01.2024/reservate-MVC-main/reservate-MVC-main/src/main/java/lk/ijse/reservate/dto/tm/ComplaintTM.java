package lk.ijse.reservate.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComplaintTM {
    private String ComplaintID;
    private String Date;
    private String time;
    private String guestid;
    private String mealorderid;
    private String hallreservationid;
    private String roomreservationid;
    private String description;
}
