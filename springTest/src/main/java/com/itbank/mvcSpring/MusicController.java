package com.itbank.mvcSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {
	
	@Autowired
	@Qualifier("music")
	MusicDAO dao;
	
	//입력시 실행되는 부분
	@RequestMapping("insert")
	public String insert(MusicDTO dto, Model m){
		dao.insert(dto);
		
		//id가 자동생성이므로, 받은 name으로 검색하여 모델에 담아줌
		String name = dto.getName();
		m.addAttribute("dto", dao.select(name));
		
		return "inputView";
	}//end insert()
	
	//삭제시 실행되는 부분
	@RequestMapping("delete")
	public String insert(String input,Model m){
		if(input != null && input.trim() != ""){
			int id = Integer.parseInt(input);
			System.out.println(id);
			//삭제하기 전에 검색부터 수행해서 모델에 담아줌
			System.out.println(dao.select(id));
			m.addAttribute("dto",dao.select(id));
			
			//삭제 실행
			dao.delete(id);
		}
		return "deleteView";
	}//end delete()
}//end class{}

