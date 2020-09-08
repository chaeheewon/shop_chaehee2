package com.shop.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.shop.vo.BlogVO;

@Repository
public class BlogListDAOImpl implements BlogListDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	//blog리스트 조회
	@Override
	public List<BlogVO> blogList() throws Exception {
		List<BlogVO> rtnBlogList = sqlSession.selectList("Blog.blogList");
		return rtnBlogList;
	}
	
	//blog detail 
	@Override
	public BlogVO readBlogDetail(int bid) throws Exception {
		BlogVO rtnBvo = sqlSession.selectOne("Blog.readDetail", bid);
		return rtnBvo;
	}
}
