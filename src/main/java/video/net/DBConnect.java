package video.net;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import duck.reg.pack.Auth;
import duck.reg.pack.PropLoad;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;

//import com.google.api.client.util.Lists;

public class DBConnect {
    private String idYoutubeVideo;

    public DBConnect() {
        this.idYoutubeVideo = getIdYoutubeVideoDefault();
    }

    public DBConnect(String idYoutubeVideo) {
        this.idYoutubeVideo = idYoutubeVideo;
    }

    public String getIdYoutubeVideoDefault() {
        return  "BQidh8H0fMo";
    }

    private String getIdYoutubeVideo() {
        // add list of video IDs here
//        return "BQidh8H0fMo";
        return this.idYoutubeVideo;
    }

    public void setIdYoutubeVideo(String idYoutubeVideo) {
        this.idYoutubeVideo = idYoutubeVideo;
    }

    private String getApiKey() {
        // you can get it from https://console.cloud.google.com/apis/credentials
        return PropLoad.getYoutubeApi();
    }

    public String getYouTubeDescription() throws SQLException, IOException{
        return getYouTubeSnippet("description");
    }

    public String getYouTubeTitle() throws SQLException, IOException{
        return getYouTubeSnippet("title");
    }


    public String getYouTubeSnippet(String fieldName) throws SQLException, IOException{
        String result = "";
        try {

            // This OAuth 2.0 access scope allows for full read/write access to the
            // authenticated user's account.
//            List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");
//            Credential credential = Auth.authorize(scopes, "updatevideo");


//            YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
            YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, request -> {
            }).setApplicationName("APP_ID").build();

//            String apiKey = "Your Private Api Key"; // you can get it from https://console.cloud.google.com/apis/credentials
            String apiKey = getApiKey(); // you can get it from https://console.cloud.google.com/apis/credentials

//            YouTube.Videos.List listVideosRequest = youtube.videos().list("statistics");

            //Resource representation -  https://developers.google.com/youtube/v3/docs/videos#resource

            //How to use the part parameter - https://developers.google.com/youtube/v3/getting-started#part
            //How to use the fields parameter - https://developers.google.com/youtube/v3/getting-started#fields
            //snippet.description
//           part == "snippet,contentDetails"

            YouTube.Videos.List listVideosRequest = youtube.videos().list("snippet");

            listVideosRequest.setId(getIdYoutubeVideo()); // add list of video IDs here
            listVideosRequest.setKey(apiKey);
            VideoListResponse listResponse = listVideosRequest.execute();

            Video video = listResponse.getItems().get(0);

            VideoSnippet videoSnippet = video.getSnippet();
//            videoSnippet.setTitle();
//            videoSnippet.setDescription();

            switch (fieldName) {
                case "description":
                    result = videoSnippet.getDescription();
                    break;

                case "title":
                    //2020-07-02 - JS1 Евгений Чернов - 22 лекция
                    result = videoSnippet.getTitle();

// ------------------------
//                    // Prompt the user to enter a keyword tag to add to the video.
//                    String tag = getTagFromUser();
//
//                    // Preserve any tags already associated with the video. If the
//                    // video does not have any tags, create a new array. Append the
//                    // provided tag to the list of tags associated with the video.
//                    List<String> tags = videoSnippet.getTags();
//                    if (tags == null) {
//                        tags = new ArrayList<String>(1);
//                        videoSnippet.setTags(tags);
//                    }
//                    tags.add(tag);
//
//                    //Set n Update from https://coderoad.ru/40256970/Java-YouTube-API-setPublishAt-на-видео-приводит-к-400-плохой-запрос
//                    videoSnippet.setTitle("2020-07-02 - JS1 Евгений Чернов - 22TUpd");
//                    YouTube.Videos.Update updateVideosRequest =youtube.videos().update("snippet",  video);
////                    YouTube.Videos.Update updateVideosRequest =youtube.videos().update("snippet,status", video);
////                    updateVideosRequest.execute();
//                    Video videoResponse = updateVideosRequest.execute();

                    // Call the YouTube Data API's youtube.videos.list method to
                    // retrieve the resource that represents the specified video.
//                    YouTube.Videos.List listVideosRequestNew = youtube.videos().list("snippet").setId(videoId);
//                    VideoListResponse listResponse = listVideosRequest.execute();




                    break;

                default:
//                    result = null;
                    //Нет такого пункта ...
                    //? может в ENUM переделать ? description title
                    // или бросить исключение
                    break;
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            return result;
        }
    }

    /*
     * Prompt the user to enter a keyword tag.
     */
    private static String getTagFromUser() throws IOException {

//        String keyword = "";
//
//        System.out.print("Please enter a tag for your video: ");
//        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
//        keyword = bReader.readLine();
//
//        if (keyword.length() < 1) {
//            // If the user doesn't enter a tag, use the default value "New Tag."
//            keyword = "New Tag";
//        }
        return "Java";
    }

    public String getYouTubeStatistics() throws SQLException, IOException{
        try {
            YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("APP_ID").build();

            String apiKey =  getApiKey();

            YouTube.Videos.List listVideosRequest = youtube.videos().list("statistics");

//            YouTube.Videos.List listVideosRequest = youtube.videos().list("snippet,contentDetails");

            //full list https://developers.google.com/youtube/v3/getting-started#quota
            // https://developers.google.com/youtube/v3/docs/videos#resource
//            https://developers.google.com/youtube/v3/getting-started#quota


            listVideosRequest.setId(getIdYoutubeVideo()); // add list of video IDs here


            listVideosRequest.setKey(apiKey);
            VideoListResponse listResponse = listVideosRequest.execute();

            Video video = listResponse.getItems().get(0);

//            statistics
            BigInteger viewCount = video.getStatistics().getViewCount();

//            statistics
            BigInteger Likes = video.getStatistics().getLikeCount();
            BigInteger DisLikes = video.getStatistics().getDislikeCount();
            BigInteger Comments = video.getStatistics().getCommentCount();
            System.out.println("[View Count] " + viewCount);
            System.out.println("[Likes] " + Likes);
            System.out.println("[Dislikes] " + DisLikes);
            System.out.println("[Comments] " + Comments);

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}