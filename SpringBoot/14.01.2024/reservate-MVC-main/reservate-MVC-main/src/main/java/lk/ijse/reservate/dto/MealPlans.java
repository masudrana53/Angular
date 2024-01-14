package lk.ijse.reservate.dto;

import com.jfoenix.controls.JFXComboBox;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MealPlans {
    private String PackageId;
    private String MealPlan;
    private String MealType;
    private String Description;
    private Double Price;


}
