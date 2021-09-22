package ru.mephi.java_course.lab1;

import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.rules.ExpectedException;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MyMapTest {
    private MyMap map;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
    }

    @Before
    public void setUp() throws Exception {
        MyMap.MapEntry[] mapEntries = new MyMap.MapEntry[]{new MyMap.MapEntry(2, "Java"),
                new MyMap.MapEntry(1, "hello")};
        map = new MyMap(mapEntries);

    }//выполняется до каждого теста

    @Test
    public void whenGetMapSize() {
        assertThat("The size should be: " + is(2), map.size(), is(2));
    }
    @Test
    public void whenCheckIfMapIsEmpty(){
        assertThat("The map is not empty ", map.isEmpty(), is(false));
    }
    @Test
    public void whenContainsKey() throws Exception {
        assertThat("The map contains key 2", map.keyContains(2), is(true));
        assertThat("The map does not contain key 4 ", map.keyContains(4), is(false));
    }
    //whenValues
    //whenEntries
    @Test
    public void whenGetMapKeys() throws Exception {
        assertThat("The size of keys list should be: " + is(2), map.getKeys().size(), is(2));
        assertThat("Keys list is wrong", map.getKeys().toString(), is("2\n1\n"));
    }
    @Test
    public void whenGetMapValues() throws  Exception{
        assertThat("The size of values should be "+is(2),map.getValues().size(),is(2));
        assertThat("Values list is wrong " , map.getValues().toString(), is("Java\nhello\n"));
    }
    @Test
    public void whenGetMapEntries() throws  Exception{
        assertThat("The size of entries should be "+is(2),map.getEntries().size(),is(2));
        assertThat("Entries list is wrong", map.getEntries().toString(), is("[ 2: Java ]\n[ 1: hello ]\n"));
    }


    @Test
    public void whenGetValueByKey() throws Exception {
        assertThat("The value should be: " + is("Java"), map.get(2), is("Java"));
        assertThat("The value should be: null)", map.get("hello"), is(nullValue()));
        thrown.expect(NullPointerException.class);
        map.get(null);
    }

    @Test
    public void whenGetValueByKeyWithDefault() throws Exception {
        assertThat("The value should be: " + is("Java"), map.get(2, "hi!"), is("Java"));
        assertThat("The value should be: " + is("hi!"), map.get(4, "hi!"), is("hi!"));
        thrown.expect(NullPointerException.class);
        map.get(null, "hi!");
        map.get(2, null);
    }


    @Test
    public void whenPutValue() throws Exception {
        map.put("java-bro", "Scala");
        assertThat("The value should be: " + is("Scala"), map.get("java-bro"), is("Scala"));
        map.put("java-bro", "Kotlin");
        assertThat("The value should be: " + is("Kotlin"), map.get("java-bro"), is("Kotlin"));
        thrown.expect(NullPointerException.class);
        map.put(null, "hello");
        map.put("go", null);
    }

    @Test
    public void whenRemoveValue() throws Exception {
        assertThat("The deleted value should be: null", map.remove(2), is("Java"));
        assertThat("The new size of list should be:" + is(1), map.size(), is(1));
        assertThat("Can't delete not existing value", map.remove("WORLD"), is(nullValue()));
        thrown.expect(NullPointerException.class);
        map.remove(null);
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
