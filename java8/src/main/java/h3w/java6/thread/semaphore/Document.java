package h3w.java6.thread.semaphore;

public class Document {

    private String title;
    private String content;

    // 构造函数
    public Document(String t, String c) {
        this.title = t;
        this.content = c;
    }

    // 返回标题
    public String getTitle() {
        return this.title;
    }

    // 返回内容
    public String getContent() {
        return this.content;
    }
}
