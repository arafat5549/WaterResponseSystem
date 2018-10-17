package com.jqmkj.WaterResponseSystem.util;

import java.io.*;

public class JavaBeanColumnHelper {

    public static void main(String[] args) {
        try {
            File file = new File("D:/aaa.txt");
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),"gbk");
            BufferedReader br = new BufferedReader(read);
            String txtLine = null;
            while ((txtLine = br.readLine()) != null) {
                /**
                 * 实时数据
                 */
               /* System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Rtd\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Rtd;  //"+txtLine.substring(7));
                System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Flag\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Flag;");
*/
                /**
                 * 分钟，小时，日数据
                 */
              /*  System.out.println("@Column(length=12,name=\""+txtLine.substring(0,6)+"_Cou\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Cou;  //"+txtLine.substring(7));
                System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Min\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Min;");
                System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Avg\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Avg;");
                System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Max\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Max;");
                System.out.println("@Column(length=8,name=\""+txtLine.substring(0,6)+"_Flag\")");
                System.out.println("private String "+ txtLine.substring(0,6)+"_Flag;");*/



            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



