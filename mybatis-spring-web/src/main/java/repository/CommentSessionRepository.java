package repository;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Aca;
import model.Bca;
import model.Cca;
import model.Comment;
import model.Member2;

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
	public Member2 memberSelect(Member2 member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".memberSelect";
		System.out.println("Repository"+member.getIID());
		System.out.println("Repository"+member.getPASSWD());
		try {
		return sqlSession.selectOne(statement, member);
		}finally {
			sqlSession.close();
		}
	}
	public List<Aca> acaSelect() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".acaSelect";
		try {
			return sqlSession.selectList(statement);
		}finally {
			sqlSession.close();
		}
	}
	public List<Bca> bcaSelect(Aca aca) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".bcaSelect";
		System.out.println("Repository2 "+aca.getAnum());
		System.out.println("Repository2 "+aca.getAname());
		try {
			return sqlSession.selectList(statement, aca);
		}finally {
			sqlSession.close();
		}
	}
	public List<Cca> ccaSelect(Bca bca) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".ccaSelect";
		System.out.println("Repository3 "+bca.getBnum());
		System.out.println("Repository3 "+bca.getBname());
		try {
			return sqlSession.selectList(statement, bca);
		}finally {
			sqlSession.close();
		}
	}
}
