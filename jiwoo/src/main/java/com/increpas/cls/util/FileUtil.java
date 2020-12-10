package com.increpas.cls.util;

import java.io.File;

/* 
 *  이클래스는 파일 업로드에 필요한 기능을 처리하기 위해 만든 유틸리티 적인 클래스이다.
 *  @author jiwoo
 *  @since 2020.12.10
 	@verion v.1.0
 */
public class FileUtil {
	/*
	 	파일 이름이 중복되면 덮어쓰기를 하게 된다.
	 	따라서 혹시 같은 이름의 파일이 존재하면
	 	파일이름을 바꿔서 저장할 필요가 있다.
	 	따라서 같은 이름의 파일이 존재하면 파일의 이름을 바꿔주는 함수를
	 	만들어주어야 함
	 */
	public static String rename(String path, String oldName) {
		/*
		 	혹시 같은 이름의 파일이 존재하면  (번호)를 붙여서 이름을 바꾸는 형식으로 조치하겠다
		 	
		 	예]
		 		sample.txt ---> sample(1).txt ----> sample(2).txt 
		 */
		int count = 0; // 뒤에 붙일 번호를 기억할 변수
		String tmpName = oldName; // 현재 이름을 기억할 변수
		File file = new File(path, oldName);
		while(file.exists()) {
			//같은 이름이 존재하는 경우가 발생하면 이름을 바꿔야한다.
			count++;
			// .을 기준으로 앞의 내용과 뒤의 내용을 분리한다.
			int len = tmpName.lastIndexOf('.');
			String tmp1 = tmpName.substring(0, len);
			String tmp2 = tmpName.substring(len+1);
			
			//분리된 것에 필요한 번호를 붙여서 다시 합친다.
			oldName = tmp1 + "(" + count + ")." + tmp2;
			
			//위 이름의 파일이 존재하는지 확인을 해봐야한다.
			file = new File(path, oldName);
		}
		
		return oldName; //최종 저장 이름
	}
}
