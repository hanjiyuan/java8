package samples;

import java.io.File;
import java.io.IOException;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;

/**
 * 断点续传下载用法示例
 *
 */
public class ImageSample {

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIvxjdjJS921VE";
    private static String accessKeySecret = "VtKISwV0y1G5hm3MgxXWZJw2vNSRfQ";
    private static String bucketName = "bucket-jgkk";
    private static String key = "jg/cloud/test/3.jpg";

    public static void main(String[] args) throws IOException {
        printAll();
    }

    public static void printAll() {
        System.out.printf("%-17s", "缩放");
        System.out.printf("%-17s", "裁剪");
        System.out.printf("%-17s", "旋转");
        System.out.printf("%-17s", "锐化");
        System.out.printf("%-17s", "水印");
        System.out.printf("%-17s", "格式转换");
        System.out.printf("%-17s", "图片信息");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            printLine();
        }
    }
    
    public static void printLine() {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            long t1 = System.currentTimeMillis();
            // 缩放
            String style = "image/resize,m_fixed,w_100,h_100";
            GetObjectRequest request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-resize.jpg"));

            long t2 = System.currentTimeMillis();
            System.out.printf("%-8d",(t2 - t1));
            // 裁剪
            style = "image/crop,w_100,h_100,x_100,y_100,r_1";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-crop.jpg"));
            long t3 = System.currentTimeMillis();
            System.out.printf("%-8d",(t3 - t2));
            // 旋转
            style = "image/rotate,0";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-rotate.jpg"));
            long t4 = System.currentTimeMillis();
            System.out.printf("%-8d",(t4 - t3));
            // 锐化
            style = "image/sharpen,100";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-sharpen.jpg"));
            long t5 = System.currentTimeMillis();
            System.out.printf("%-8d",(t5 - t4));
            // 水印
            style = "image/watermark,text_SGVsbG8g5Zu-54mH5pyN5YqhIQ";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-watermark.jpg"));
            long t6 = System.currentTimeMillis();
            System.out.printf("%-8d",(t6 - t5));
            // 格式转换
            style = "image/format,png";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-format.png"));
            long t7 = System.currentTimeMillis();
            System.out.printf("%-8d",(t7 - t6));
            // 图片信息
            style = "image/info";
            request = new GetObjectRequest(bucketName, key);
            request.setProcess(style);

            ossClient.getObject(request, new File("example-info.txt"));
            long t8 = System.currentTimeMillis();
            System.out.printf("%-8d",(t8 - t7));
            
            System.out.println();
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }
}
