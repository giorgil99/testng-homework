import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class LocalTestTransformer implements IAnnotationTransformer {
    public static int disableNumber= 0 ;
    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        List<String> groupNames = Arrays.asList(annotation.getGroups());

        if (groupNames.contains("DisabledGroup")) {
//            System.out.println(disableNumber);
//            System.out.println("Disabled the group");
//            disableNumber++;
            annotation.setEnabled(false);


        }
    }
}
