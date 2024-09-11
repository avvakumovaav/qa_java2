import com.example.Feline;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.Spy;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getKittensGreater1ReturnsCorrect() {
        feline.getKittens(10);
        Assert.assertEquals(10, feline.getKittens(10));
    }

    @Test
    public void getKittens1Returns1() {
        Assert.assertEquals(1, feline.getKittens(1));
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}