package com.lp.bos.web.action;

import com.lp.bos.model.Region;
import com.lp.bos.model.Subarea;
import com.lp.bos.service.SubareaService;
import com.lp.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class SubareaAction extends BaseAction<Subarea>{

    @Autowired
    private SubareaService subareaService;
    @Override
    public String save() {
//        System.out.println("数据1:" + getModel());
//        System.out.println("数据1:" + getModel().getRegion());

        //调用service
        subareaService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() throws IOException {
        return null;
    }

    @Override
    public String list() {
        return null;
    }

    public void pageQuery() throws IOException {
        pb.setCurrentPage(page);
        pb.setPageSize(rows);

        //添加查询的条件
        DetachedCriteria dc = pb.getDetachedCriteria();//Subarea
        String addresskey = getModel().getAddresskey();
        if(!StringUtils.isEmpty(addresskey)){
            dc.add(Restrictions.like("addresskey","%" + addresskey +"%"));
        }

        Region region = getModel().getRegion();
        if(region != null){
            String province = region.getProvince();
            String city = region.getCity();
            String district = region.getDistrict();
            dc.createAlias("region","r");//创建一个别名

            if(!StringUtils.isEmpty(province)){
                dc.add(Restrictions.like("r.province","%" + province + "%"));
            }

            if(!StringUtils.isEmpty(city)){
                dc.add(Restrictions.like("r.city","%" + city + "%"));
            }

            if(!StringUtils.isEmpty(district)){
                dc.add(Restrictions.like("r.district","%" + district + "%"));
            }
        }
        //2.调用service,参数里传一个PageBean
        subareaService.pageQuery(pb);
        /**
         * 注意：获取数据时候，把分区Subarea的Region的加载方式设置为即时加载
         */
        //3.返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","subareas"});

    }

    //导出表格
    public void exportExcel() throws IOException {
        //1.创建workbook【相当于xls文件】
        HSSFWorkbook workbook = new HSSFWorkbook();

        //2.创建sheet
        HSSFSheet sheet = workbook.createSheet("分区数据");

        //3.创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("分区编码");
        row.createCell(1).setCellValue("区域编码");
        row.createCell(2).setCellValue("关键字");
        row.createCell(3).setCellValue("省市区");

        //4.查询数据
        List<Subarea> subareas = subareaService.findAll();
        for (Subarea s : subareas) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(s.getId());
            row.createCell(1).setCellValue(s.getRegion().getProvince());
            row.createCell(2).setCellValue(s.getRegion().getCity());
            row.createCell(3).setCellValue(s.getRegion().getDistrict());
        }

        //5.相应【输出流】
        HttpServletResponse response = ServletActionContext.getResponse();
        //设置响应头
        String fileName = URLEncoder.encode("分区数据.xls","utf-8");
        response.setHeader("Content-Disposition","attachment;filename=" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        System.out.println(contentType);
        response.setContentType(contentType);
        //response.setContentType("application/octet-stream");

        OutputStream os = response.getOutputStream();
        workbook.write(os);
    }

    public void listJson() throws IOException {
        //未绑定的分区数据【也就是这个分区没有指定一个员工负责】
        List<Subarea> list = subareaService.findAllWithUnbind();
        responseJson(list,new String[]{"decidedzone","region"});
    }
}
