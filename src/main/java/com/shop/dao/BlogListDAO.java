package com.shop.dao;

import java.util.List;

import com.shop.vo.BlogVO;

public interface BlogListDAO {
	public List<BlogVO> blogList() throws Exception;
	public BlogVO readBlogDetail(int bid) throws Exception;
}
