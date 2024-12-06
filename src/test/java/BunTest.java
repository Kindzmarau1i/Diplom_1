import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Хлеб ржаной", 15F);

    @Test
    public void getNameTest() {
        Assert.assertEquals("Хлеб ржаной", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(15F, bun.getPrice(), 0F);
    }
}
