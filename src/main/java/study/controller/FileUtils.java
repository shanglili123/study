package study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static void write(InputStream ins , OutputStream os) throws IOException {
        byte[] buff = new byte[1024];
        int i = ins.read(buff);
        while (i != -1) {
            os.write(buff, 0, i);
            i = ins.read(buff);

        }
        os.flush();
    }
    public static void close(InputStream ins , OutputStream os){
        if(ins != null){
            try {
                ins.close();
            } catch (IOException e) {
                log.error("in io close fail");
            }
        }
        if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                log.error("out io close fail");
            }
        }
    }
}
