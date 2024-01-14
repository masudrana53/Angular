package lk.ijse.reservate.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class mealDetailsTM {
    private String PackageId;
    private String MealPlan;
    private String MealType;
    private String Description;
    private Double Price;
}
