package com.increpas.cls.service;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.util.FileUtil;
import com.increpas.cls.vo.FileVO;

public class BoardService {
	@Autowired
	BoardDao bDao;
	
	//파일 업로드를 처리할 함수
	public ArrayList<FileVO> saveProc(MultipartFile[] file) {
		//저장 이름을 기억할 변수
		String[] snames = new String[file.length]; 
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		
		//저장 경로 지정...
		String path = this.getClass().getResource("").getPath()	;
//		req.getSession().getServletContext().getRealPath("WEB-INF/resources/img/upload");
//		System.out.println(path.substring(0, path.indexOf("/classes")) + "/resources/img/upload");
		path = path.substring(0, path.indexOf("/classes")) + "/resources/img/upload/";
		
		for(int i = 0 ; i < file.length; i++) {
			FileVO fVO = new FileVO	();
			String oriName = file[i].getOriginalFilename();
			//만약 파일이 업로드 되지 않는 작업이라면 이 파일은 지나가야 한다.
			if(oriName == null) {
				snames[i] = "";
				continue;
			}
			//같은 이름의 파일이 존재하는지 검사한다.
			String savename = FileUtil.rename(path, oriName);
			//저장이름이 생겼으니 변수에 기억시킨다.
			snames[i] = savename;
			//이제 임시로 업로드된 파일을 실제 저장경로에 저장을 해야한다.
			//그리고 이 이름은 데이터베이스에 등록할때 사용해야한다.
			try {
				File tmp = new File(path, savename);
				fVO.setOriname(oriName);
				fVO.setSavename(savename);
				fVO.setLen(tmp.length());
				fVO.setDir("/img/upload/");
				
				list.add(fVO);
				file[i].transferTo(tmp); //실제 저장 경로에 저장해주는 함수
			}catch(Exception e) {
				System.out.println("### 파일 저장 에러 ###");
			}
		}
		return list;
	}
}
