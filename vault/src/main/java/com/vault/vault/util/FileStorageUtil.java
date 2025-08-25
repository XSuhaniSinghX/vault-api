package com.vault.vault.util;
import java.io.File;
import java.io.IOException;

//1-th and last class for now
// This utility class provides methods for saving and loading objects to and from files using Jackson's Object
//damn! i know springboot 
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileStorageUtil {
    static ObjectMapper mapper = new ObjectMapper();

    public static void save(String path, Object obj) {
        try {
            new File(path).getParentFile().mkdirs();
            mapper.writeValue(new File(path), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T load(String path, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(path),clazz);}
}