package com.jomn.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jomn.constant.api.ResultCode;
import com.jomn.core.page.PageDomain;
import com.jomn.core.page.TableDataInfo;
import com.jomn.core.page.TableSupper;
import com.jomn.utlis.ServletUtlis;
import com.jomn.utlis.StringUtils;
import com.jomn.web.core.vo.PageVo;

import java.util.List;

public class BaseController {

    /**
     * 请求分页
     */
    protected void startPage() {
        PageDomain pageDomain = TableSupper.getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if(StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            if(StringUtils.isNotNull(pageDomain.getOrderByColumn())) {
                PageHelper.startPage(pageNum,pageSize,pageDomain.getOrderByColumn());
            }else {
                PageHelper.startPage(pageNum,pageSize);
            }
        }
    }

    /**
     * 请求分页
     */
    protected void startPage(PageDomain pageDomain) {
        if(pageDomain != null) {
            Integer pageNum = pageDomain.getPageNum();
            Integer pageSize = pageDomain.getPageSize();
            String sort = pageDomain.getOrderByColumn();
            if(sort != null && sort.trim() != "") {
                String sortOrder = pageDomain.getIsAsc();
                sort = StringUtils.toUnderScoreCase(sort);
                String orderByColumn = sort + " " + sortOrder;
                pageDomain.setOrderByColumn(orderByColumn);
            }else {
                pageDomain.setOrderByColumn(null);
            }
            if(StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
                if(StringUtils.isNotNull(pageDomain.getOrderByColumn())) {
                    PageHelper.startPage(pageNum,pageSize,pageDomain.getOrderByColumn());
                }else {
                    PageHelper.startPage(pageNum,pageSize);
                }
            }
        }

    }







    /**
     * 返回table数据
     */
    public TableDataInfo getTableDataInfo(List<?> data) {
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setTotal(new PageInfo(data).getTotal());
        tableDataInfo.setRows(data);
        tableDataInfo.setResultCode(ResultCode.SUCCESS);
        return tableDataInfo;
    }

    /**
     * 封装pageVo
     */
    public PageVo getPageVo(List<?> data) {
        PageVo pageVo = new PageVo();
        pageVo.setTotal(new PageInfo(data).getTotal());
        pageVo.setData(data);
        pageVo.setResultCode(ResultCode.SUCCESS);
        return pageVo;
    }




}
