package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Comment;
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
		return "jsp/ajaxmain";
	}
	@RequestMapping(value="/ajax.do", method=RequestMethod.POST)
	public String handleStep(HttpServletRequest request, Model model) {
		commentService.ajaxSelect(request, model);
		return "jsp/ajaxhtml";
	}
}
