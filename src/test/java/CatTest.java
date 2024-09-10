import com.example.Cat;
import com.example.Feline;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Spy
    Cat cat = new Cat(feline);

    @Test
    public void getSoundTest() {
        cat.getSound();
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}