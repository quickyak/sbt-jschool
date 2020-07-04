package video.net;


import java.io.IOException;
import java.sql.SQLException;

public class MainInet {
    public static void main(String[] args) throws IOException, SQLException {
        DBConnect youtube_info = new DBConnect( );
        System.out.println(youtube_info.getYouTubeTitle());
        System.out.println(youtube_info.getYouTubeDescription());
//        youtube_info.getyoutubeitemfull_details();
    }

}
