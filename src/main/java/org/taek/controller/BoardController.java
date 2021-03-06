package org.taek.controller;

import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.taek.domain.BoardVO;
import org.taek.domain.Criteria;
import org.taek.domain.PageMaker;
import org.taek.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject 
	BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void RegistGET(BoardVO board, Model model) throws Exception {
		logger.info("regist get .....");
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String RegistPOST(BoardVO board, RedirectAttributes attr) throws Exception {
		
		logger.info("regist post ... ");
		service.regist(board);
		
		attr.addFlashAttribute("result", "success");
		
		return "redirect:/board/listAll";
		
	}
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAllGET(Model model,  HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("listAll get ....");
		model.addAttribute("list",service.listAll());
		}
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno , 
						@ModelAttribute("cri") Criteria cri ,
						Model model) throws Exception {
		logger.info("read get ....");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, 
						Criteria cri,
						RedirectAttributes attr) throws Exception {
		logger.info("delete post ....");
		service.remove(bno);
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addFlashAttribute("result","success");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("modify get .....");
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO baord, RedirectAttributes attr) throws Exception {
		logger.info("modify post .....");
		service.modify(baord);
		
		attr.addAttribute("result","success");
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyPagindGET(@RequestParam("bno")int bno, 
								@ModelAttribute("cri") Criteria cri,
								Model model) throws Exception {
		logger.info("modifyPage get ....");
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPagingPOST(@RequestParam("bno")int bno, 
									BoardVO board,
									Criteria cri, RedirectAttributes attr) throws Exception {
		logger.info("modifyPage post");
		
		service.modify(board);
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addFlashAttribute("result","success");
		
		
		return "redirect:/board/listPage";	
	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET) 
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("listCri get ....");
		
		System.out.println(cri);
		
		model.addAttribute("list",service.listCriteria(cri));
	}
	@RequestMapping(value="/listPage", method=RequestMethod.GET) 
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		System.out.println("cri => "+cri);
		model.addAttribute("list",service.listCriteria(cri));
		
		logger.info(cri.toString());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
	}
}
