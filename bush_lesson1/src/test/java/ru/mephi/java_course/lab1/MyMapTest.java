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


    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
    }

    @Before
    public void setUp() {
        MapEntry[] mapEntries = new MapEntry[]{ new MapEntry(2, "Java"),
                new MapEntry(1, "hello")};
        map = new MyMap(mapEntries);

    }//выполняется до каждого теста

    @Test
    public void whenGetMapSize() {
        assertThat("The size should be: " + is(2), map.size(), is(2));
    }

    @Test
    public void whenCheckIfMapIsEmpty() {
        assertThat("The map is not empty ", map.isEmpty(), is(false));
        map.remove(1);
        map.remove(2);
        assertThat("The map is  empty ", map.isEmpty(), is(true));
    }

    @Test
    public void whenContainsKey() {
        assertThat("The map contains key 2", map.keyContains(2), is(true));
        assertThat("The map does not contain key 4 ", map.keyContains(4), is(false));
        map.put(null, "java");
        assertThat("Map contains null key", map.keyContains(null), is(true));

    }

    @Test
    public void whenGetMapKeys() {
        assertThat("The size of keys list should be: " + is(2), map.getKeys().size(), is(2));
        assertThat("Keys list is wrong", map.getKeys().toString(), is("2\n1\n"));
    }

    @Test
    public void whenGetMapValues() {
        assertThat("The size of values should be " + is(2), map.getValues().size(), is(2));
        assertThat("Values list is wrong ", map.getValues().toString(), is("Java\nhello\n"));
    }

    @Test
    public void whenGetMapEntries() {
        assertThat("The size of entries should be " + is(2), map.getEntries().size(), is(2));
        assertThat("Entries list is wrong", map.getEntries().toString(), is("[ 2: Java ]\n[ 1: hello ]\n"));
    }


    @Test
    public void whenGetValueByKey() {
        assertThat("The value should be: " + is("Java"), map.get(2), is("Java"));
        assertThat("The value should be: null)", map.get("hello"), is(nullValue()));
        assertThat("The value should be: null", map.get("null"), is(nullValue()));
    }

    @Test
    public void whenGetValueByKeyWithDefault() {
        assertThat("The value should be: " + is("Java"), map.get(2, "hi!"), is("Java"));
        assertThat("The value should be: " + is("hi!"), map.get(4, "hi!"), is("hi!"));

    }


    @Test
    public void whenPutValue() {
        map.put("java-bro", "Scala");
        assertThat("The value should be: " + is("Scala"), map.get("java-bro"), is("Scala"));
        map.put("java-bro", "Kotlin");
        assertThat("The value should be: " + is("Kotlin"), map.get("java-bro"), is("Kotlin"));
        map.put("java-bro", null);
        assertThat("The value should be: null", map.get("java-bro"), is(nullValue()));
        map.put(null, "java");
        assertThat("The value should be: java", map.get(null), is("java"));
        map.put(null,"java");
        map.put(null,"java");
        System.out.println(map.toString());
        assertThat("The size should be 4", map.size(),is(4));

    }

    @Test
    public void whenRemoveValue() {
        assertThat("The deleted value should be: null", map.remove(2), is("Java"));
        assertThat("The new size of list should be:" + is(1), map.size(), is(1));
        assertThat("Can't delete not existing value", map.remove("WORLD"), is(nullValue()));
        map.put(null, "java");
        assertThat("The deleted value should be: java", map.remove(null), is("java"));

    }
    @Test
    public void whenAddDuplicateKey(){
        map.put("newKey","newValue");
        assertThat("The size should be 3", map.size(), is(3));
        map.put("newKey","newValue");
        assertThat("The size should be 3", map.size(), is(3));
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
