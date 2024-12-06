import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 20F);

    @Test
    public void getPriceTest() {
        Assert.assertEquals(20F, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Сырный", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
