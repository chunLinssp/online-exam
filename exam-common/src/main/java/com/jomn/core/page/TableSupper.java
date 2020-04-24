package com.jomn.core.page;

import com.github.pagehelper.PageHelper;
import com.jomn.utlis.ServletUtlis;
import com.jomn.utlis.StringUtils;

public class TableSupper {

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(Integer.parseInt(ServletUtlis.getRequest().getParameter("pageNumber")));
        pageDomain.setPageSize(Integer.parseInt(ServletUtlis.getRequest().getParameter("pageSize")));
        String sort = ServletUtlis.getRequest().getParameter("sort");
        if(StringUtils.isNotNull(sort)) {
            String sortOrder = ServletUtlis.getRequest().getParameter("sortOrder");
            sort = StringUtils.toUnderScoreCase(sort);
            String orderByColumn = sort + " " + sortOrder;
            pageDomain.setOrderByColumn(orderByColumn);
        }else {
            pageDomain.setOrderByColumn(null);
        }
        return pageDomain;
    }


}
