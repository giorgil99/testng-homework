import org.testng.annotations.Factory;

public class FactoryClass {

// Implement same scenario using @Factory
    @Factory
    public Object[] setData() {
        Object[] result = new Object[3];
        for ( int i = 0; i <3; i++) {
            result[i] = new FactoryTest(i);
        }
        return result;
    }
}
