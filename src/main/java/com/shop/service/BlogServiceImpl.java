package com.shop.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.shop.dao.BlogListDAO;
import com.shop.vo.BlogVO;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Inject
	private BlogListDAO bdao;
	
	// Blog 리스트 조회
	@Override
	public List<BlogVO> BList() throws Exception {
        List<BlogVO> list = new  ArrayList<BlogVO>();
		list = bdao.blogList();
		return list;
	}
	
	//Blog 상세조회
	@Override
	public BlogVO read(int bid) throws Exception {
		BlogVO rtnBvo = bdao.readBlogDetail(bid);
		return rtnBvo;
	}
}
