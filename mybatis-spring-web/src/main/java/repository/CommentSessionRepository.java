package repository;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Comment;

@Repository
public class CommentSessionRepository extends AbstractRepository{
	private final String namespace = "repository.mapper.CommentMapper";
	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertComment";
		try {
			System.out.println("Repository" + comment.getCommentNo());
			System.out.println("Repository" + comment.getUserId());
			comment.setRegDate(Calendar.getInstance().getTime()); // 캘린더라는 클래스에서 객체를 생성해 날짜 값을 저장해준다.
			Integer result = sqlSession.insert(statement, comment);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally {
			sqlSession.close();
		}
	}
	public List<Comment> selectCommentByCondition(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("Repository" + comment.getCommentNo());
			String statement = namespace + ".selectCommentByCondition";
			return sqlSession.selectList(statement, comment);
		}finally {
			sqlSession.close();
		}
	}
	public Integer updateComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".updateComment";
		try {
			System.out.println("Repository" + comment.getCommentNo());
			System.out.println("Repository" + comment.getUserId());
			Integer result = sqlSession.update(statement, comment);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally {
			sqlSession.close();
		}
	}
	public Integer deleteComment(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		/*String statement = namespace + ".deleteComment";*/
		try {
			System.out.println("Repository" + commentNo);
			Integer result = sqlSession.delete(String.format("%s.deleteComment", namespace), commentNo);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally {
			sqlSession.close();
		}
	}
	public List ajaxSelect(Long result) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		if(result == 1) {
		statement = namespace + ".ajaxSelect";
		}else if(result == 2) {
			statement = namespace + ".ajaxSelect1";
		}
		try {
			System.out.println("Repository"+ result);
			return sqlSession.selectList(statement);
		}finally {
			sqlSession.close();
		}
	}
}
