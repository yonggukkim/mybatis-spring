package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import model.Comment;
import model.Member;
import repository.CommentSessionRepository;

@Service
public class CommentService {
	@Autowired
	private CommentSessionRepository commentRepository;

	public Integer insertComment(Comment comment) {
		// 디버깅코드
		System.out.println("service"+ comment.getCommentNo());
		System.out.println("service"+ comment.getUserId());
		
		return commentRepository.insertComment(comment);
	}
	public List<Comment> selectComment(Comment comment) {
		System.out.println("service" + comment.getCommentNo());
		return commentRepository.selectCommentByCondition(comment);
	}
	public Integer updateComment(Comment comment) {
		System.out.println("service"+ comment.getCommentNo());
		System.out.println("service"+ comment.getUserId());
		
		return commentRepository.updateComment(comment);
	}
	public Integer deleteComment(Long commentNo) {
		System.out.println("service"+ commentNo);
		
		return commentRepository.deleteComment(commentNo);
	}
	public void ajaxSelect(HttpServletRequest request, Model model) {
		Long result = Long.parseLong(request.getParameter("n"));
		System.out.println("service"+result);
		List list = commentRepository.ajaxSelect(result);
		model.addAttribute("list",list);
		model.addAttribute("result",result);
	}
	public void memberSelect(Member member, Model model) {
		System.out.println("service" + member.getIID());
		System.out.println("service" + member.getPASSWD());
		Member mb = commentRepository.memberSelect(member);
		int result = 0;
		if(mb != null) {
			if(!mb.getPASSWD().equals(member.getPASSWD())) {
				result = 2;
			}else {
				result = 4;
			}
		}else {
			result = 1;
		}
		model.addAttribute("result", result);
	}
}
