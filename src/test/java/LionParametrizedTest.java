import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    @Mock
    Feline feline;
    private final boolean haveMane;
    private final String sex;

    public LionParametrizedTest(boolean haveMane, String sex) throws Exception {
        this.haveMane = haveMane;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                { true, "Самец"},
                { false, "Самка"},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Lion lionSpy  = Mockito.spy(lion);
        lionSpy.doesHaveMane();
        Assert.assertEquals(haveMane, lionSpy.doesHaveMane());
    }
}