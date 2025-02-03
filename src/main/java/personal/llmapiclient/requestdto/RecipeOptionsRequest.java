package personal.llmapiclient.requestdto;

import lombok.Getter;

import java.util.List;

@Getter
public class RecipeOptionsRequest extends AbstractOptionsRequest {
    private List<String> mealType;
    private List<String> cuisineType;
    private List<String> ingredients;
    private List<String> cookingUtensils;
    private List<String> cookingTime;


    private RecipeOptionsRequest(
            List<String> mealType, List<String> cuisineType, List<String> ingredients,
            List<String> cookingUtensils, List<String> cookingTime
    ) {
        this.mealType = mealType;
        this.cuisineType = cuisineType;
        this.ingredients = ingredients;
        this.cookingUtensils = cookingUtensils;
        this.cookingTime = cookingTime;
    }

    public static RecipeOptionsRequest of(
            String mealType, String cuisineType, List<String> ingredients,
            List<String> cookingUtensils, String cookingTime
    ) {
        return new RecipeOptionsRequest(
                List.of(mealType), List.of(cuisineType), ingredients, cookingUtensils, List.of(cookingTime)
        );
    }
}
