import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

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
        Lion localLion = new Lion("Самец", feline);
        localLion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion localLion = new Lion("Самец", feline);
        localLion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
}