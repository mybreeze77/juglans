package com.juglans.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.stream.IntStream;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Use CSV file as data provider source.
 * This only supports primitive type.
 * @author Junlong Wu
 *
 */
public class CSVDataProvider implements Iterator<Object> {

    private CSVReader reader;
    private String[] last;
    private Class<?>[] clazzes;
    private Converter[] converters;

    private CSVDataProvider() {}

    private CSVDataProvider(Class<?> clazz, Method method, String csvFilePath) {
        InputStream is = clazz.getClassLoader().getResourceAsStream(csvFilePath);
        InputStreamReader isr = new InputStreamReader(is);
        reader = new CSVReader(isr);
        clazzes = method.getParameterTypes();
        int len = clazzes.length;
        converters = new Converter[len];

        IntStream.range(0, len).forEach(
                i -> converters[i] = ConvertUtils.lookup(clazzes[i]));

    }

    public static Iterator<Object> getDataProvider(Method method) {
        return getInstance(method.getDeclaringClass(), method);
    }

    public static Iterator<Object> getInstance(Class<?> clazz, Method method) {
        String path = clazz.getName().replace('.', '/');
        String filePath = path + "." + method.getName() + ".csv";
        return new CSVDataProvider(clazz, method, filePath);
    }

    public static Iterator<Object> getInstance(Class<?> clazz, Method method, String csvFilePath) {
        return new CSVDataProvider(clazz, method, csvFilePath);
    }

    public boolean hasNext() {
        return (getNextLine() != null);
    }

    private String[] getNextLine() {
        if (last == null) {
            try {
                last = reader.readNext();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return last;
    }

    public Object next() {
        String[] next = last != null ? last : getNextLine();
        last = null;
        Object[] objects = parseLine(next);
        return objects;
    }

    private Object[] parseLine(String[] values) {
        int len = values.length;
        Object[] objects = new Object[len];

        IntStream.range(0, len).forEach(
                i -> objects[i] = converters[i].convert(clazzes[i], values[i]));

        return objects;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
