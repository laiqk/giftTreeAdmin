package com.dept.web.general.util;

public class StatusUtils {

    /**
     * 获取标状态名称
     * @Title: getBorrowStatusName 
     * @Description: TODO
     * @param @param status
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getBorrowStatusName(int status){
        
        switch (status) {
        case 0:
            return "等待初审";
        case 1:
            return "募集中";
        case 2:
            return "满标待审";
        case 3:
            return "复审通过"; 
        case 5:
            return "还款中";
        case 6:
            return "已还款"; 
        case 7:
            return "已过期";
        case 11:
            return "已完成";
        case 20:
            return "代还中";
        case 41:
            return "初审不通过"; 
        case 42:
            return "复审不通过";   
        case 43:
            return "复审不通过";//复审不通过处理成功
        default:
            break;
        }
        return null;
    }
    
    /**
     * 获取理财产品名字
     * @Title: getBorrowTypeName 
     * @Description: TODO
     * @param @param type
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getBorrowTypeName(int type){
        
        if(type==1){
            return "新手标";
        }else if(type==2){
            return "供应融";
        }else if(type==3){
        	return "保理融";
        }else if(type==4){
        	return "企业融";
        }else if(type==0){
        	return "体验标";
        }else if(type==5){
        	return "余额融";
        }else{
            return "未知";
        }
        
    }
    
    /**
     * 还款方式
     * @Title: getBorrowRepaymentStyle 
     * @Description: TODO
     * @param @param type
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getBorrowRepaymentStyle(int type){
        
        switch (type) {
        case 1:
            return "等额本息";
        case 2:
            return "到期还本还息";   
        case 3:
            return "按月付息到期还本";               
        default:
            break;
        }
        return null;
    }
    
    /**
     * 还款方式
     * @Title: getBorrowRepaymentStyle 
     * @Description: TODO
     * @param @param type
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getBorrowRepaymentStyle2(String type){
        
       if(type==null||type.equals("")){
    	   return "";
       }else if("1".equals(type)){
    	   return "等额本息";
       }
       else if("2".equals(type)){
    	   return "到期还本还息"; 
       }
       else if("3".equals(type)){
    	   return "按月付息到期还本";
       }
        return "";
    }
    
    /**
     * 借款用途
     * @Title: getBorrowUse 
     * @Description: TODO
     * @param @param type
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getBorrowUse(int type){
        
        switch (type) {
        case 1:
            return "车贷";
        case 2:
            return "房贷";              
        default:
            return "其他"; 
        }
    }
    
    /**
     * 还款状态
     * @Title: getRepaymentStatus 
     * @Description: TODO
     * @param @param type
     * @param @return 设定文件 
     * @return String 返回类型 
     * @throws
     */
    public static String getRepaymentStatus(int type){
        
        switch (type) {
        case 0:
            return "未还款";
        case 1:
            return "已还款";
        case 2:
            return "逾期"; 
        case 9:
            return "等待还款";             
        default:
            return "错误状态"; 
        }
    }  
}
