import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    Lion lion = new Lion("Самец", feline);
    Lion lionSpy  = Mockito.spy(lion);

    public LionTest() throws Exception {
    }

    @Test
    public void exceptionInConstructorTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Exception", feline);
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion localLion = new Lion("Самец", feline);
        localLion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), localLion.getFood());
    }

    @Test
    public void getKittensTest() throws Exception {
        lionSpy.getKittens();
        Mockito.verify(lionSpy, Mockito.times(1)).getKittens();
        Assert.assertEquals(1, lionSpy.getKittens());
    }
}