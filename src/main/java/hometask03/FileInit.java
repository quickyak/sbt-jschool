package hometask03;


public class FileInit {

    private String text;
    private String fileName;
    private String dirName;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getFullName() {
        String result = "";

        if ((!isNullOrEmpty(getDirName())) && (!isNullOrEmpty(getFileName()))) {
            result = getDirName() + "/" + getFileName(); //для Mac это так, может в других операционках и другой разделитель
        } else if (!isNullOrEmpty(getDirName())) {
            result = getDirName();
        } else if (!isNullOrEmpty(getFileName())) {
            result = getFileName();
        }
        return result;
    }

    private boolean isNullOrEmpty(String s) {
        return (s == null || s.isEmpty());
    }
}


