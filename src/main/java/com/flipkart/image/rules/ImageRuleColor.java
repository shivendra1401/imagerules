package com.flipkart.image.rules;import org.im4java.core.*;import java.io.*;/** * Created by shivendra.singh on 10/07/14. */public class ImageRuleColor implements ImageRule<Boolean,String,String> {    @Override    public Boolean validate(String image,String color) throws InterruptedException, IOException, IM4JavaException {        File histogram = getHistogram(image);        String line;        FileReader fis= new FileReader(histogram);        BufferedReader bis= new BufferedReader(fis);        while((line=bis.readLine())!= null)        {            int index= line.indexOf("#");            String color2=line.substring(index,index+7);            System.out.println(color2);            Boolean bool = isColorSimilar(color, color2);                    }        return null;    }    private Boolean isColorSimilar(String color, String color2) throws InterruptedException, IOException, IM4JavaException {        CompareCmd compare=new CompareCmd();        //compare.setCommand("compare");        IMOperation op = new IMOperation();       // op.fuzz(30.0);        //op.metric("AE");        op.addImage();        op.addImage();        op.addImage();        //compare.run(op,"xc:green","xc:brown","null:");        compare.run(op,"/Users/shivendra.singh/Downloads/bag_frame1.jpg","/Users/shivendra.singh/Downloads/bag_frame1.gif","/Users/shivendra.singh/Downloads/compare_lossy_jpeg.gif");        return null;    }    private File getHistogram(String image) throws IOException, InterruptedException, IM4JavaException {        PrintStream console = System.out;        File file = new File("tmp.txt");        FileOutputStream fos = new FileOutputStream(file);        PrintStream ps = new PrintStream(fos);        System.setOut(ps);        ConvertCmd cmd= new ConvertCmd();        //ImageCommand cmd=new ImageCommand();        //cmd.setCommand("convert");        IMOperation op = new IMOperation();        op.addImage();        op.colors(16);        op.depth(8);        op.format("%c");        op.addImage();        cmd.run(op,image,"histogram:info:");        System.setOut(console);        return file;    }}