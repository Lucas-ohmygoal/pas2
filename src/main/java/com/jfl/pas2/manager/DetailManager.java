package com.jfl.pas2.manager;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.domain.Detail;
import com.jfl.pas2.domain.DetailExample;
import com.jfl.pas2.dto.product.ProductsDecreaseX1;
import com.jfl.pas2.dto.product.ProductsIncreaseX1;
import com.jfl.pas2.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author Bin Liu
 * @date 2021-08-11-9:37 PM
 */

@Component
public class DetailManager {

    @Autowired
    private DetailMapper detailMapper;

    /**
     * 写入库操作明细
     */
    public void writeInputOperationDetails(ProductsIncreaseX1 input, String operator){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Detail detail = new Detail();
        detail.setSerialNumber(input.getOperationSeries());
        detail.setProductId(input.getProductId());
        detail.setProductNumber(input.getNumber());
        detail.setWithCups(((input.getWithCups().equals("1")?"Y":"N")));
        detail.setWithSwitches(((input.getWithSwitches().equals("1")?"Y":"N")));
        detail.setWithCircles(((input.getWithCircles().equals("1")?"Y":"N")));
        detail.setOperatorName(operator);
        detail.setOperationDate(date.substring(0,8));
        detail.setOperationTime(date.substring(8,14));

        if (detailMapper.insertSelective(detail) < 0){
            throw new AppException(ErrorEnum.E00041, "写操作明细文件出错！");
        }
    }


    /**
     * 写出库操作明细
     */
    public void writeOutputOperationDetails(ProductsDecreaseX1 input, String operator){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Detail detail = new Detail();
        detail.setSerialNumber(input.getOperationSeries());
        detail.setProductId(input.getProductId());
        detail.setProductNumber(input.getNumber());
        detail.setWithCups(((input.getWithCups().equals("1")?"Y":"N")));
        detail.setWithSwitches(((input.getWithSwitches().equals("1")?"Y":"N")));
        detail.setWithCircles(((input.getWithCircles().equals("1")?"Y":"N")));
        detail.setOperatorName(operator);
        detail.setOperationDate(date.substring(0,8));
        detail.setOperationTime(date.substring(8,14));

        if (detailMapper.insertSelective(detail) < 0){
            throw new AppException(ErrorEnum.E00041, "写操作明细文件出错！");
        }
    }

    /**
     * 查询操作明细
     */
    public List<Detail> queryOperationDetail(String startDate, String endDate){
        DetailExample example = new DetailExample();
        example.createCriteria().andOperationDateBetween(startDate,endDate);
        List<Detail> details = detailMapper.selectByExample(example);
        if (details == null){
            throw new AppException(ErrorEnum.E00044,"查询操作明细文件出错");
        }
        return details;
    }

}
