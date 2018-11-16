package datastreaming.server.controller.streaming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/api/stream")
public class StreamingController {

    @GetMapping("/test.m3u8")
    public void playAudio(HttpServletRequest request, HttpServletResponse response){
        File file = new File("C:\\Users\\pawma\\IdeaProjects\\data-streaming-server\\testdata\\music\\Metallica\\Kill 'Em All\\Seek & Destroy\\seek_.m3u8");
        FileInputStream fis;
        byte[] buffer=null;
        try {
            System.out.println("Download manifest");
            fis = new FileInputStream(file);
            buffer= new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Download manifest File Not Found");
        } catch (IOException e) {
            System.out.println("Download manifest IOException");
        }
        response.setContentType("application/x-mpegURL");
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            response.getOutputStream().write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/test/{id}")
    public void playAudio1(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id){
        File file = new File("C:\\Users\\pawma\\Desktop\\testmusic\\testdata\\music\\Metallica\\Kill 'Em All\\Seek & Destroy\\seek_\"+ id +\".ts");
        FileInputStream fis;
        byte[] buffer=null;
        try {
            System.out.println("Download segment " + id);
            fis = new FileInputStream(file);
            buffer= new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Download segment " + id + "File Not Found");
        } catch (IOException e) {
            System.out.println("Download segment " + id + "IOException");
        }
        response.setContentType("video/MP2T");
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            response.getOutputStream().write(buffer);
        } catch (IOException e) {
            System.out.println(id);
        }

    }
}
