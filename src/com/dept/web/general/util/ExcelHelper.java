package com.dept.web.general.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;

public class ExcelHelper {

	public static final String UID="serialVersionUID"; 
	private static Logger logger = Logger.getLogger(ExcelHelper.class);
	
	public static void writeExcel(String file,List list,Class clazz) throws Exception {
		Field[] fields=clazz.getDeclaredFields();
		List flist=new ArrayList();
		for(int i=0;i<fields.length;i++){
			if(fields[i].getName().equals(UID)){
				continue;
			}
			flist.add(fields[i].getName());
		}
		writeExcel(file,list,clazz,flist,null);
	}
	
	public static void writeExcel(String file,List list,Class clazz,List<String> fields,List<String> titles) throws Exception {
		OutputStream os=getOutputStream(file);
		jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
		jxl.write.WritableSheet ws = wwb.createSheet("Sheet1", 0);
		jxl.write.Label label=null;
		int start=0;
		if(titles!=null&&titles.size()>0){
			for(int j=0;j<titles.size();j++){ 
				label=new jxl.write.Label(j,0,titles.get(j));
				ws.addCell(label);
			}
			start++;
		}
		for(int i=start;i<list.size()+start;i++){
			Object o=list.get(i-start);
			if(o==null){
				continue;
			}
			for(int j=0;j<fields.size();j++){
				String value="";
				if("serialVersionUID".equals(fields.get(j))){
					continue;
				}
				try {
					value=ReflectUtils.invokeGetMethod(clazz, o, fields.get(j)).toString();
					/** 状态用汉字 */
					if(fields.get(j)!=null&&fields.get(j).equals("status")){
	
						if(value.equals("0")){
							value="失败";
						}else if(value.equals("1")){
							value="成功";
						}
					}
					
					/** 实名认证状态 */
					if(fields.get(j)!=null&&fields.get(j).equals("realVerifyStatus")){
	
						if("0".equals(value)){
							value="未认证";
						}else if("1".equals(value)){
							value="已认证";
						}else if("2".equals(value)){
							value="待审核";
						}
					}
					
					/** 红包状态 */ 
					if(fields.get(j)!=null&&fields.get(j).equals("hongbaostatus")){
	
						if(value.equals("0")){
							value="未使用";
						}else if(value.equals("1")){
							value="已使用";
						}else if(value.equals("2")){
							value="已过期";
						}else if(value.equals("3")){
							value="投标成功冻结";
						}
					}
					
					/** 投标状态 */ 
					if(fields.get(j)!=null&&fields.get(j).equals("tenderstatus")){
	
						if(value.equals("0")){
							value="投标新建";
						}else if(value.equals("1")){
							value="投标成功";
						}else if(value.equals("2")){
							value="投标放款成功";
						}else if(value.equals("3")){
							value="投标还款成功";
						}else if(value.equals("4")){
							value="投标待放款";
						}else if(value.equals("9")){
							value="投标失败";
						}
					}
					
					/** 资金操作类型 */ 
					if(fields.get(j)!=null&&fields.get(j).equals("operatetype")){
	
						if(value.equals("1")){
							value="充值成功";
						}else if(value.equals("5")){
							value="提现成功";
						}else if(value.equals("6")){
							value="提现失败";
						}else if(value.equals("7")){
							value="线下充值成功";
						}else if(value.equals("12")){
							value="线下扣款成功";
						}else if(value.equals("14")){
							value = "分配账号扣除保证金";
				    	}else if(value.equals("15")){
				    		value = "追加保证金扣除";
				    	}else if(value.equals("16")){
							value="借款入账扣除冻结资金,生成待收记录";
						}else if(value.equals("22")){
							value="退回保证金";
						}else if(value.equals("30")){
							value = "还款扣除平台服务费";
				    	}else if(value.equals("31")){
							value="投资成功";
						}else if(value.equals("32")){
							value="投资成功后奖励";
						}else if(value.equals("33")){
							value="借款入账";
						}else if(value.equals("34")){
							value="借款入账扣除奖励";
						}else if(value.equals("35")){
							value="网站垫付扣除罚息";
						}else if(value.equals("36")){
							value="还款扣除本金";
						}else if(value.equals("37")){
							value="还款扣除利息";
						}else if(value.equals("38")){
							value="还款扣除逾期利息";
						}else if(value.equals("39")){
							value="还款归还本金";
						}else if(value.equals("40")){
							value="还款归还利息";
						}else if(value.equals("41")){
							value="还款归还利息管理费";
						}else if(value.equals("42")){
							value="还款归还逾期利息";
						}else if(value.equals("43")){
							value="流标解冻资金";
						}else if(value.equals("44")){
							value="追加保证金拒绝";
						}else if(value.equals("56")){
							value = "复审不通过,归还本金";
				    	}
					}
					
					/** 红包类型 */
					if(fields.get(j)!=null&&fields.get(j).equals("type")){
	
						if(value.equals("1")){
							value="注册送红包";
						}else if(value.equals("2")){
							value="邀请推荐送红包";
						}else if(value.equals("3")){
							value="投资送红包";
						}else if(value.equals("4")){
							value="兑换红包";
						}
					}
					
					/** 是否天标 */
					if(fields.get(j)!=null&&fields.get(j).equals("isday")){
	
						if("0".equals(value)){
							value="否";
						}else if("1".equals(value)){
							value="是";
						}
					}
					
					/** 还款方式 */
					if(fields.get(j)!=null&&fields.get(j).equals("repaymentStyle")){
	
						if("2".equals(value)){
							value="到期还本付息";
						}
					}
					
					/** 投资状态 */
					if(fields.get(j)!=null&&fields.get(j).equals("tStatus")){
						if("0".equals(value)){
							value="未投资";
						}else{
							value="已投资";
						}
					}
				} catch (Exception e) {
					
				}
				if(fields.get(j)!=null&&isTime(fields.get(j))){
					if(value.isEmpty()){
						value="";
					}else{
						value=DateUtils.dateStr2(value, "yyyy-MM-dd HH:mm:ss");
					}
				}
				
				label=new jxl.write.Label(j,i, value); 
				ws.addCell(label);
			}
		}
		wwb.write();
		wwb.close();
	}
	
	public static List[] read(String xls) throws Exception {  
		List[] data=null; 
		File file=new File(xls);
		if(file.exists()){
			data=read(file);
		}
		return data;
	}
	
	public static List[] read(File file) throws Exception {  
		List[] data=null; 
        Workbook wb = null;  
        try {  
            wb = Workbook.getWorkbook(file);  
            if (wb != null) {  
                Sheet[] sheets = wb.getSheets();
                if (sheets != null && sheets.length >= 0) {  
                	int rows = sheets[0].getRows(); 
                	data=new List[rows]; 
                    for (int j=0;j<rows;j++) {  
                    	List<String> rowData=new ArrayList();
                        Cell[] cells = sheets[0].getRow(j);  
                        if (cells != null && cells.length != 0) { 
                            for (int k=0;k<cells.length;k++) {  
                                String cell = cells[k].getContents();
                                rowData.add(cell);
                            } 
                        }  
                        data[j]=rowData;
                    } 
                } 
            }  
        } catch (Exception e) {  
        	logger.info(e.getMessage());
        } finally {  
            wb.close();  
        }  
        return data;  
    }  
	
	
	private static boolean isTime(String field){
		String[] times=new String[]{"createdAt","addtime","repaymentYestime","repaymentTime","createdTime","expiredTime","useTime","realVerifyTime","endTime","loanTime","firstTenderTime","secondTenderTime"};
		boolean isTime=false;
		for(String s:times){
			if(s.equals(field)){
				isTime=true;
				break;
			}
		}
		return isTime;
	}
	
	public static OutputStream getOutputStream(String file) throws Exception{
		File f = new File(file);
		f.createNewFile();
		OutputStream os=new FileOutputStream(f);
		return os;
	}

}
