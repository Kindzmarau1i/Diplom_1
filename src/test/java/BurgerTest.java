import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        Mockito.when(bun.getName()).thenReturn("Black bread");
        Mockito.when(bun.getPrice()).thenReturn(15F);
        bun = new Bun(bun.getName(), bun.getPrice());
        burger.setBuns(bun);
        Assert.assertEquals(burger.getBun(), bun);
    }

    @Test
    public void addIngredientTest() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Meat");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        ingredient = new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.getIngredients(), List.of(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Meat");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        ingredient = new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void moveIngredientTest() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Meat");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        ingredient = new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 0);
        Assert.assertEquals(burger.ingredients.size(), 2);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(15F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Burger filledBurger = new Burger(bun, List.of(ingredient));
        Assert.assertEquals(130, filledBurger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Black bread");
        Mockito.when(bun.getPrice()).thenReturn(15F);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Meat");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        Burger filledBurger = new Burger(bun, List.of(ingredient));

        String expected = "(==== Black bread ====)\r\n= filling Meat =\r\n(==== Black bread ====)\r\n\r\nPrice: 130,000000\r\n";

        Assert.assertEquals(filledBurger.getReceipt(), expected);
    }
}
