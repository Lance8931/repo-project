package com.siping.web.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil{

    public static String uploadRepairImg(String path,Integer pkey, MultipartFile file) throws IOException, SQLException {
        String imgPath = "";
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        String photoPath = path+"\\"+ pkey + fileSuffix;
        byte[] bytes = file.getBytes();
        FileOutputStream fos = new FileOutputStream(photoPath);
        fos.write(bytes);
        fos.close();
        imgPath = "/resources/userFile/img/repair/"+pkey+fileSuffix;
        return imgPath;
    }

}
