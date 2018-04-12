package com.company;
import java.io.*;
public class C implements Serializable {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Txt txt,c_t = null;
            txt=new Txt();
            c_t=new Txt();
            try {
                c_t=(Txt)txt.deepClone();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("15031210101 软件工程一班 贾亚武");
            System.out.println("txt==copy_txt?");
            System.out.println(txt==c_t);
            System.out.println("txt.getAttachment==copy_Txt.getAttachment?");
            System.out.println(txt.getAttachment()==c_t.getAttachment());
            c_t.display();
            txt.display();
            c_t.getAttachment();
        }
        catch(Exception e) {
            System.out.println(e.toString()); }
    }
}
class Attachment implements Serializable{
    public void download()
    {
        System.out.println("下载附件");
    }
}
class Txt implements Serializable{
    private Attachment attachment=null;
    public Txt() {
        this.attachment=new Attachment();
    }
    public Object deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
        try {
            ByteArrayOutputStream bao=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bao);
            oos.writeObject(this);
            ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);
            return (ois.readObject());
        }
        catch(Exception e) {
            System.out.println(e.toString()); }
        return null;
    }
    public Attachment getAttachment() {
        if(this.attachment!=null)
            return this.attachment;
        return null;
    }
    public void display() {
        System.out.println("查看文本");
    }
}
