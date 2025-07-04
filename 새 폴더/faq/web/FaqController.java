/**
 * 
 */
package egovframework.example.faq.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqService;
import lombok.extern.log4j.Log4j2;

/**
 * @author user
 *
 */
@Log4j2
@Controller
public class FaqController {
	@Autowired
	private FaqService faqService;

	@GetMapping("/faq/faq.do")
	public String selectFaqList(@ModelAttribute Criteria criteria, Model model) {

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());


		List<?> faqs = faqService.selectFaqList(criteria);
		log.info("test : " + faqs);
		model.addAttribute("faqs", faqs);

		return "faq/faq_all";
	}
	


}
