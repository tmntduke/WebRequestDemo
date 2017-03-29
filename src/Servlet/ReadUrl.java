package Servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tmnt on 2017/2/8.
 */
public class ReadUrl {

    List<FileInfo> list = new ArrayList<>();

    public String getUrl() {
        String path = "G:\\image";

        File file = new File(path);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(getAllFilesName(file));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return s;

    }

    private List<FileInfo> getAllFilesName(File file) {

        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                getAllFilesName(files[i]);

            } else {

                FileInfo info = new FileInfo(files[i].getName(), files[i].getPath());
                list.add(info);

//                stringBuffer.append("{")
//                        .append("\"name\"")
//                        .append(":")
//                        .append("\"")
//                        .append(files[i].getName())
//                        .append("\"")
//                        .append(",")
//                        .append("\"path\"")
//                        .append(":")
//                        .append("\"")
//                        .append(files[i].getPath())
//                        .append("\"")
//                        .append("}")
//                        .append(",");
            }

        }

        return list;

    }

}
