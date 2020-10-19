import org.junit.*;

public class TestReference{
    private Reference r1 ;

    @Before
    public void init(){
        r1 = new Reference("azertyuiop","first","blabla",346);
    }

    @Test(expected = IllegalArgumentException.class)
    public void referenceNullName() {
        Reference ref = new Reference(null,null, "description", 43);
    }

    @Test
    public void getIdTest(){
        Assert.assertEquals("azertyuiop",r1.getId());
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("first",r1.getName());
    }

    @Test
    public void getDescriptionTest(){
        Assert.assertEquals("blabla",r1.getDescription());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(346,r1.getPrice());
    }
}
