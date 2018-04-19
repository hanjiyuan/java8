package com.ccb.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ReduceImgTest {
    /**
     * 指定图片宽度和高度和压缩比例对图片进行压缩
     * 
     * @param imgsrc
     *            源图片地址
     * @param imgdist
     *            目标图片地址
     * @param widthdist
     *            压缩后图片的宽度
     * @param heightdist
     *            压缩后图片的高度
     * @param quality
     *            压缩算法
     */
    public static void reduceImg(String imgsrc, String imgdist, int widthdist, int heightdist, int quality) {
        try {
            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
           
            // 开始读取文件并进行压缩
            Image src = ImageIO.read(srcfile);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

            //绘制图像  getScaledInstance表示创建此图像的缩放版本，返回一个新的缩放版本Image,按指定的width,height呈现图像
            //Image.SCALE_SMOOTH,选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, quality), 0, 0, null);

            //创建文件输出流
            FileOutputStream out = new FileOutputStream(imgdist);
            //将图片按JPEG压缩，保存到out中
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            //关闭文件输出流
            out.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }

    /**
     * 获取图片宽度和高度
     * 
     * @param 图片路径
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] =src.getWidth(null); // 得到源图片宽
            result[1] =src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        
        File srcfile = new File("e://test//1.jpg"); 
        int width = getImgWidthHeight(srcfile)[0];
        int height = getImgWidthHeight(srcfile)[1];
        
        long start = System.currentTimeMillis();
        reduceImg("e://test//1.jpg", "e://test//SCALE_FAST.jpg", width, height, Image.SCALE_FAST);
        long time = System.currentTimeMillis() - start;
        System.out.println("Image.SCALE_FAST:" + time);
        
        start = System.currentTimeMillis();
        reduceImg("e://test//1.jpg", "e://test//SCALE_DEFAULT.jpg", width, height, Image.SCALE_DEFAULT);
        time = System.currentTimeMillis() - start;
        System.out.println("Image.SCALE_DEFAULT:" + time);
        
        start = System.currentTimeMillis();
        reduceImg("e://test//1.jpg", "e://test//SCALE_AREA_AVERAGING.jpg", width, height, Image.SCALE_AREA_AVERAGING);
        time = System.currentTimeMillis() - start;
        System.out.println("Image.SCALE_AREA_AVERAGING:" + time);
        
        start = System.currentTimeMillis();
        reduceImg("e://test//1.jpg", "e://test//SCALE_REPLICATE.jpg", width, height, Image.SCALE_REPLICATE);
        time = System.currentTimeMillis() - start;
        System.out.println("Image.SCALE_REPLICATE:" + time);
        
        start = System.currentTimeMillis();
        reduceImg("e://test//1.jpg", "e://test//SCALE_SMOOTH.jpg", width, height, Image.SCALE_SMOOTH);
        time = System.currentTimeMillis() - start;
        System.out.println("Image.SCALE_SMOOTH:" + time);
    }
}
