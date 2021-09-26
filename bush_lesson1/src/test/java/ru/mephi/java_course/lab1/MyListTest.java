package ru.mephi.java_course.lab1;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MyListTest {
    private MyList list;



    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
    }

    @Before
    public void setUp() {
        Object[] testList1 = {"hello", "world!", "Java"};
        list = new MyList(testList1);
    }//выполняется до каждого теста

    @Test
    public void whenGettingSize() {
        assertThat("Result is not equal to expected value: " + is(3), list.size(), is(3));
    }

    @Test
    public void whenAddSingleItem()  {
        list.add("mephi");
        assertThat("There should be element 'mephi'", list.contains("mephi"), is(true));
        assertThat("Size doesn't equal to expected value: " + is(4), list.size(), is(4));
        list.add("super", 2);
        assertThat("There should be element 'super'", list.contains("super"), is(true));
        assertThat("Index of 'super' should be 2",list.indexOf("super"),is(2));
        assertThat("Size doesn't equal to expected value: " + is(5), list.size(), is(5));

    }

    @Test
    public void whenDeleteItem()  {
        list.remove(1);
        assertThat("There is an element 'world!': it is deleted", list.contains("world!"), is(false));
        assertThat("Size of list should be equal to expected value: " + is(2), list.size(), is(2));
        list.add("go");
        assertThat("There is no element with index 10",list.remove(10),is(nullValue()));
    }

    @Test
    public void whenSetNewValue()  {
        assertThat("The old value should be " + is("world!"), list.set("programmer!",1), is("world!"));
        assertThat("Size of list shouldn't change", list.size(), is(3));
        assertThat("Old value should be null because it's out of bounds ",list.set("kotlin",-20),is(nullValue()));
        assertThat("There should be a new element 'kotlin' ",list.contains("kotlin"),is(true));
    }

    @Test
    public void whenCheckingIfListIsEmpty()  {
        list = new MyList();
        assertThat("List is empty!", list.isEmpty(), is(true));
        list.add("JAVA");
        assertThat("List is not empty!", list.isEmpty(), is(false));
    }

    @Test
    public void whenContainsValue()  {
        assertThat("List contains value 'Java'", list.contains("Java"), is(true));
        assertThat("List doesn't contain value 'Kotlin'", list.contains("Kotlin"), is(false));

    }

    @Test
    public void whenGetItemByIndex()  {
        assertThat("Returned value should be 'Java'!", list.get(2), is("Java"));
        list.set("mind", 1);
        assertThat("Returned value should be 'mind'", list.get(1), is("mind"));

    }

    @Test
    public void whenGetIndexOfValue() {
        assertThat("Returned index should be 2!", list.indexOf("Java"), is(2));
        assertThat("Returned index should be -1 because element does not exist!", list.indexOf("cat"), is(-1));
        assertThat("Index of not existing value should be -1",list.indexOf("laba"),is(-1));
        assertThat("Index of null value is -1",list.indexOf(null),is(-1));
        list.add(null);
        assertThat("Index should be 3",list.indexOf(null),is(3));
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
    }//выполняется после каждого теста
    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }




}
