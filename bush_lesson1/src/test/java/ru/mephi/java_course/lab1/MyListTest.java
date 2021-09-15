package ru.mephi.java_course.lab1;

import org.junit.*;
import org.junit.rules.ExpectedException;
import ru.mephi.java_course.lab1.MyList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyListTest {
    private MyList list;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
    }

    @Before
    public void setUp() {
        Object[] testList1 = {"hello", "world!", "Java"};
        list = new MyList(testList1);
    }

    @Test
    public void whenGettingSize() {
        assertThat("Result is not equal to expected value: " + is(3), list.size(), is(3));
    }

    @Test
    public void whenAddSingleItem() throws Exception {
        list.add("mephi");
        assertThat("There is no element 'mephi'", list.contains("mephi"), is(true));
        assertThat("Size doesn't equal to expected value: " + is(4), list.size(), is(4));
        list.add("super", 3);
        assertThat("There is no element 'super'", list.contains("super"), is(true));
        assertThat("Size doesn't equal to expected value: " + is(5), list.size(), is(5));

        thrown.expect(NullPointerException.class);
        list.add(null);
        thrown.expect(IndexOutOfBoundsException.class);
        list.add("hi",-9);
    }

    @Test
    public void whenDeleteItem() throws Exception {
        list.remove(1);
        assertThat("There is an element 'world!': it is deleted", list.contains("world!"), is(false));
        assertThat("Size of list should be equal to expected value: " + is(2), list.size(), is(2));
        list.add("go");
        list.remove("go");
        assertThat("There is an element 'world!': it is deleted", list.contains("go"), is(false));
        assertThat("Size of list should be equal to expected value: " + is(2), list.size(), is(2));

        thrown.expect(ArrayIndexOutOfBoundsException.class);
        list.remove(100);

        thrown.expect(Exception.class);
        thrown.expectMessage("Can't remove not existing element!");
        list.remove("HELLO!");
    }

    @Test
    public void whenSetNewValue() throws Exception {
        list.set("programmer!", 1);
        assertThat("Size of list shouldn't change", list.size(), is(3));
        assertThat("The element with index " + 1 + "should have a new value: " + is("programmer!"), list.getByIndex(1), is("programmer!"));
        thrown.expect(NullPointerException.class);
        list.set(null,1);
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        list.set("hello",12);
    }

    @Test
    public void whenCheckingIfListIsEmpty() throws Exception {
        list = new MyList();
        assertThat("List is empty!", list.isEmpty(), is(true));
        list.add("JAVA");
        assertThat("List is not empty!", list.isEmpty(), is(false));
    }

    @Test
    public void whenContainsValue() throws Exception {
        assertThat("List contains value 'Java'", list.contains("Java"), is(true));
        assertThat("List doesn't contain value 'Kotlin'", list.contains("Kotlin"), is(false));
    }

    @Test
    public void whenGetItemByIndex() throws Exception {
        assertThat("Returned value should be 'Java'!", list.getByIndex(2), is("Java"));
        list.set("mind", 1);
        assertThat("Returned value should be 'mind'", list.getByIndex(1), is("mind"));

        thrown.expect(ArrayIndexOutOfBoundsException.class);
        list.getByIndex(-1);
    }

    @Test
    public void whenGetIndexOfValue(){
        assertThat("Returned index should be 2!", list.getIndexOf("Java"), is(2));
        assertThat("Returned index should be -1 because element does not exist!", list.getIndexOf("cat"), is(-1));
    }
    @Test
    public void whenMakeBigger(){
        assertThat("Initial size is equal to 3",list.size(),is(3));
        list.makeBigger();
        assertThat("New size is equal to 4",list.size(),is(4));
    }
    @After
    public void afterMethod() {
        System.out.println("OK");
    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }




}
