package common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public abstract class Utils {

	/**
	 * 获取count个随机数
	 * 
	 * @param count
	 *            随机数个数
	 * @return
	 */
	public static String random(int count) {
		StringBuffer sb = new StringBuffer();
		String str = "0123456789";
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			int num = r.nextInt(str.length());
			sb.append(str.charAt(num));
			str = str.replace((str.charAt(num) + ""), "");
		}
		return sb.toString();
	}

	/**
	 * 生成随即密码
	 * 
	 * @param pwd_len
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}

	/**
	 * 根据信用积分获取信用图标
	 * 
	 * @param credit
	 * @return
	 */
	public static String getCreditGif(int credit) {
		if (credit < 4) {
			return null;
		}
		String gifName = null;

		if (credit >= 4 && credit <= 250) {
			if (credit >= 4 && credit <= 10) {
				gifName = "1_1";
			} else if (credit >= 11 && credit <= 40) {
				gifName = "1_2";
			} else if (credit >= 41 && credit <= 90) {
				gifName = "1_3";
			} else if (credit >= 91 && credit <= 150) {
				gifName = "1_4";
			} else {
				gifName = "1_5";
			}
		} else if (credit >= 251 && credit <= 10000) {
			if (credit >= 251 && credit <= 500) {
				gifName = "2_1";
			} else if (credit >= 501 && credit <= 1000) {
				gifName = "2_2";
			} else if (credit >= 1001 && credit <= 2000) {
				gifName = "2_3";
			} else if (credit >= 2001 && credit <= 5000) {
				gifName = "2_4";
			} else {
				gifName = "2_5";
			}
		} else if (credit >= 10001 && credit <= 500000) {
			if (credit >= 10001 && credit <= 20000) {
				gifName = "3_1";
			} else if (credit >= 20001 && credit <= 50000) {
				gifName = "3_2";
			} else if (credit >= 50001 && credit <= 100000) {
				gifName = "3_3";
			} else if (credit >= 100001 && credit <= 200000) {
				gifName = "3_4";
			} else {
				gifName = "3_5";
			}
		} else {
			if (credit >= 500001 && credit <= 1000000) {
				gifName = "4_1";
			} else if (credit >= 1000001 && credit <= 2000000) {
				gifName = "4_2";
			} else if (credit >= 2000001 && credit <= 5000000) {
				gifName = "4_3";
			} else if (credit >= 5000001 && credit <= 10000000) {
				gifName = "4_4";
			} else {
				gifName = "4_5";
			}
		}
		return gifName;

	}
	
	/**
	 * java截取中英文混合字符串 等宽显示
	 * @param text
	 * @param length
	 * @param endWith
	 * @return
	 */
	public static String subString(String text, int length, String endWith) {        
        int textLength = text.length();  
        int byteLength = 0;  
        StringBuffer returnStr =  new StringBuffer();  
        for(int i = 0; i<textLength && byteLength < length*2; i++){  
            String str_i = text.substring(i, i+1);   
            if(str_i.getBytes().length == 1){//英文  
                byteLength++;  
            }else{//中文  
                byteLength += 2 ;  
            }  
            returnStr.append(str_i);  
        }  
        try {  
            if(byteLength<text.getBytes("GBK").length){//getBytes("GBK")每个汉字长2，getBytes("UTF-8")每个汉字长度为3  
                returnStr.append(endWith);  
            }  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return returnStr.toString();  
    }  
	public static void main(String[] args) {  
        
       /* String text = "。发.。篇>所q阿s似hf的f＊*发千万s";  
        for(int i = 0; i< text.length();i++){  
            String s = subString(text,i+1,"...");  
            System.out.println(s+"--------------------------"+(i+1));  
        }  */
		String text= "abcdefg";
		
		System.out.println(subString(text, 3, "..."));
          
    } 
}
