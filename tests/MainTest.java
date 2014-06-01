import edu.dio.lesson7.ResourceDelegator;
import edu.dio.lesson7.ResourceForDelegation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MainTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void creationTest() throws Exception {
        Assert.assertNotNull(new ResourceDelegator(new ResourceForDelegation()));
    }
    @Test
    public void callMethod1Test() throws Exception {

        ResourceForDelegation resourceForDelegation = Mockito.mock(ResourceForDelegation.class);
        ResourceDelegator delegator = new ResourceDelegator(resourceForDelegation);

        delegator.method1();
        Mockito.verify(resourceForDelegation).method1();
    }
    @Test
    public void callMethod3Test() throws Exception {
        ResourceForDelegation resource = Mockito.mock(ResourceForDelegation.class);
        ResourceDelegator delegator = new ResourceDelegator(resource);

        delegator.method3("Some String");
        Mockito.verify(resource).method3("Some String");

        delegator.method3("Some Other String");
        Mockito.verify(resource, Mockito.times(2)).method3(Mockito.anyString());
    }

    @Test
    public void callMethod3TestCaptor() throws Exception {
        ResourceForDelegation resourceForDelegation = Mockito.mock(ResourceForDelegation.class);
        ResourceDelegator resourceDelegator = new ResourceDelegator(resourceForDelegation);

        ArgumentCaptor<String> arg=ArgumentCaptor.forClass(String.class);

        resourceDelegator.method3("Hello1");
        resourceDelegator.method3("Hello2");

        Mockito.verify(resourceForDelegation, Mockito.atLeastOnce()).method3(arg.capture());
        Assert.assertEquals("Hello2", arg.getValue());
    }

    @Test
    public void callMethodsTest() throws Exception {
        ResourceForDelegation resourceForDelegation = Mockito.mock(ResourceForDelegation.class);
        ResourceDelegator resourceDelegator = Mockito.spy(new ResourceDelegator(resourceForDelegation));

        Mockito.when(resourceDelegator.method4("name")).thenReturn("noname");
        Mockito.when(resourceDelegator.method4("othername")).thenReturn("nonameagain");

        Assert.assertEquals("noname", resourceDelegator.method4("name"));
        Assert.assertEquals("nonameagain", resourceDelegator.method4("othername"));

        Mockito.verify(resourceForDelegation, Mockito.times(2)).method4(Mockito.anyString());
        Mockito.verify(resourceForDelegation, Mockito.atLeastOnce()).method4(Mockito.anyString());
        Mockito.verify(resourceDelegator, Mockito.never()).method1();
        Mockito.verify(resourceForDelegation, Mockito.never()).method5();
        Mockito.verify(resourceDelegator, Mockito.never()).method3(Mockito.anyString());

        Mockito.doReturn("somespecificname").when(resourceDelegator).method4(Mockito.anyString());
        Assert.assertEquals("somespecificname", resourceDelegator.method4("name"));
        Assert.assertEquals("somespecificname", resourceDelegator.method4("unknownname"));

    }
}