package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Aca;
import model.Bca;
import model.Comment;
import model.Member2;
import service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String handleStep1(Model model) {
		model.addAttribute("comment", new Comment());
		return "jsp/comment_form";
	}
	@RequestMapping(value="/comment_insert", method=RequestMethod.POST)
	public String handleStep1(Comment comment, Model model) {
		Integer result = commentService.insertComment(comment);
		if(result > 0) {
			model.addAttribute("comment", comment);
			return "jsp/comment_insert";
		}else {
			return "redirect:/form.do";
		}
		
	}
	@RequestMapping(value="/comment_select", method=RequestMethod.POST)
	public String handleStep2(Comment comment, Model model) {
		System.out.println("controller" + comment.getCommentNo());
		List<Comment> result = commentService.selectComment(comment);
		if(result != null) {
			model.addAttribute("result", result);
			return "jsp/comment_select";
		}else {
			return "redirect:/form.do";
		}
		
	}
	@RequestMapping(value="/comment_update", method=RequestMethod.POST)
	public String handleStep3(Comment comment, Model model) {
		System.out.println("controller" + comment.getCommentNo());
		System.out.println("controller" + comment.getUserId());
		Integer result = commentService.updateComment(comment);
		if(result > 0) {
			model.addAttribute("comment", comment);
			return "jsp/comment_update";
		}else {
			return "redirect:/form.do";
		}
	}
	@RequestMapping(value="/comment_delete", method=RequestMethod.POST)
	public String handleStep4(Comment comment, Model model) {
		System.out.println("controller" + comment.getCommentNo());
		Integer result = commentService.deleteComment(comment.getCommentNo());
		model.addAttribute("result", result);
		return "jsp/comment_delete";
	}
	@RequestMapping(value="/ajax.do", method=RequestMethod.GET)
	public String Ajaxmain(Model model) {
		return "ajax/ajaxmain";
	}
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
	public String Ajaxmain1(Model model) {
		return "ajax/ajaxmain1";
	}
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	public String Ajaxmain2(Model model) {
		return "ajax/ajaxmain2";
	}
	@RequestMapping(value="/ajax.do", method=RequestMethod.POST)
	public String handleStep(HttpServletRequest request, Model model) {
		System.out.println("1");
		System.out.println(request.getParameter("n"));
		commentService.ajaxSelect(request, model);
		return "ajax/ajaxhtml";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(Model model) {
		return "login/loginForm";
	}
	@RequestMapping(value="/login_pro.do", method=RequestMethod.POST)
	public String loginPro(Member2 member, Model model) {
		System.out.println("controller"+member.getIID());
		System.out.println("controller"+member.getPASSWD());
		commentService.memberSelect(member, model);
		return "login/loginPro";
	}
	@RequestMapping(value="/domino.do", method=RequestMethod.GET)
	public String domino(Model model) {
		commentService.dominoSelectA(model);
		return "domino/dominomain";
	}
	@RequestMapping(value="/bca.do", method=RequestMethod.POST)
	public String dominoBca(Aca aca, Model model){
		System.out.println("controller2 "+aca.getAnum());
		System.out.println("controller2 "+aca.getAname());
		commentService.dominoSelectB(aca, model);
		return "domino/bca";
	}
	@RequestMapping(value="/cca.do", method=RequestMethod.POST)
	public String dominoCca(Bca bca, Model model) {
		System.out.println("controller3 "+bca.getBnum());
		System.out.println("controller3 "+bca.getBname());
		commentService.dominoSelectC(bca, model);
		return "domino/cca";
	}
}
