package lk.ijse.reservate.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String UserId;
    private String EmpId;
    private String UserName;
    private String Password;
}
