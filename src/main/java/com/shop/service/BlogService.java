package com.shop.service;

import java.util.List;
import com.shop.vo.BlogVO;

public interface BlogService {
	public List<BlogVO> BList() throws Exception;
	public BlogVO read(int bid) throws Exception;
}
