//package com.mycompany.word.readdirectoy;
//
//import java.io.File;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DirectoyreaderImpl implements Directoyreader {
//
//    private String filepath = "/tmp";
//
//    //private ClassPathXmlApplicationContext ctx;
//    //public DirectoyreaderImpl() {
//    //    ctx = new ClassPathXmlApplicationContext("application-context.xml");
//    //    filepath = ((Path) ctx.getBean("path")).getFilepath();
//    //}
//    @Override
//    public String showFiles() {
//
//        StringBuilder builder = new StringBuilder();
//        File file = new File(filepath);
//        File[] listOfFiles = file.listFiles();
//
//        for (File fileOfList : listOfFiles) {
//            if (fileOfList.isFile()) {
//                builder.append(fileOfList.getName() + "\n");
//            }
//        }
//        return builder.toString();
//    }
//
//}
