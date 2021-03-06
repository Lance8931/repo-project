package com.siping.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.siping.bean.ResultBean;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月22日下午3:25:33
 * @version 1.0
 */
public class ExcelOperate {

	public static SXSSFWorkbook initExcel(InputStream input,
			String originalFileName) throws Exception {
		Workbook wb = null;
		String fileSuffix = originalFileName.substring(
				originalFileName.lastIndexOf(".")).toLowerCase();
		boolean isE2007 = false; // 判断是否是excel2007格式
		if (fileSuffix.endsWith("xlsx"))
			isE2007 = true;
		if (isE2007) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		SXSSFWorkbook swb = (SXSSFWorkbook) wb;

		return swb;
	}

	/**
	 * 设置单元格上提示
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param promptTitle
	 *            标题
	 * @param promptContent
	 *            内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 *
	 * @date 2016年3月22日下午3:38:46
	 * @author siping-L.J.H
	 */
	public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,
			String promptContent, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 构造constraint对象
		DVConstraint constraint = DVConstraint
				.createCustomFormulaConstraint("BB1");
		// 四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_view = new HSSFDataValidation(
				regions, constraint);
		data_validation_view.createPromptBox(promptTitle, promptContent);
		sheet.addValidationData(data_validation_view);
		return sheet;
	}

	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param textlist
	 *            下拉框显示的内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 *
	 * @date 2016年3月22日下午3:39:13
	 * @author siping-L.J.H
	 */
	public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
			String[] textlist, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint
				.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_list = new HSSFDataValidation(
				regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}

	/**
	 * 设置Excel下拉菜单数据源(数据量大的情况下)
	 * 
	 * @param wb
	 *            存在HSSF和XSSF两个版本
	 * @param workSheet
	 *            需要设置下拉菜单的sheet
	 * @param hiddenSheet
	 *            设置下拉菜单数据源的sheet
	 * @param textList
	 *            数据源
	 * @param firstRow
	 *            下拉菜单的起始行
	 * @param endRow
	 *            下拉菜单的终止行
	 * @param firstCol
	 *            下拉菜单的起始列
	 * @param endCol
	 *            下拉菜单的终止列
	 * @param hiddenDatasFirstCell
	 *            隐藏sheet中隐藏数据的起始单元格 !$A1:$A
	 * @param hiddenDatasCol
	 *            隐藏sheet中隐藏数据所在列
	 * @param referencsName
	 *            数据引用单元格名称
	 * @return
	 *
	 * @date 2016年3月23日上午10:43:12
	 * @author siping-L.J.H
	 */
	public static Workbook setCellDropDownList(Workbook wb,
			HSSFSheet workSheet, HSSFSheet hiddenSheet, String[] textList,
			int firstRow, int endRow, int firstCol, int endCol,
			String hiddenDatasFirstCell, int hiddenDatasCol,
			String referencsName) {
		String hiddenSheetName = hiddenSheet.getSheetName();
		for (int i = 0, length = textList.length; i < length; i++) {
			String name = textList[i];
			HSSFRow row = null;
			if (null != hiddenSheet.getRow(i)) {
				row = hiddenSheet.getRow(i);
			} else {
				row = hiddenSheet.createRow(i);
			}
			HSSFCell cell = row.createCell(hiddenDatasCol);
			cell.setCellValue(name);
		}
		Name namedCell = wb.createName();
		namedCell.setNameName(referencsName);
		namedCell.setRefersToFormula(hiddenSheetName + hiddenDatasFirstCell
				+ +textList.length);
		DVConstraint constraint = DVConstraint
				.createFormulaListConstraint(referencsName);
		CellRangeAddressList addressList = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		HSSFDataValidation validation = new HSSFDataValidation(addressList,
				constraint);
		workSheet.addValidationData(validation);
		return wb;
	}

	/**
	 * 设置Excel下拉菜单数据源(数据量大的情况下),设置text/value值
	 * 
	 * @param wb
	 *            工作的workbook
	 * @param workSheet
	 *            需要设置下拉菜单的sheet
	 * @param hiddenSheet
	 *            设置text/value的sheet
	 * @param beans
	 *            text/value的list
	 * @param firstRow
	 *            下拉菜单的起始行
	 * @param endRow
	 *            下拉菜单的终止行
	 * @param firstCol
	 *            下拉菜单的起始列
	 * @param endCol
	 *            下拉菜单的终止列
	 * @param hiddenDatasFirstCell
	 *            隐藏sheet中隐藏数据的起始单元格 !$A1:$A
	 * @param hiddenTextDatasCol
	 *            隐藏sheet中隐藏数据Text所在列
	 * @param hiddenValueDatasCol
	 *            隐藏sheet中隐藏数据Value所在列
	 * @param referencsName
	 *            数据引用单元格名称
	 * @return
	 *
	 * @date 2016年3月28日下午3:00:09
	 * @author siping-L.J.H
	 */
	public static Workbook setCellDropDownList(Workbook wb, Sheet workSheet,
			Sheet hiddenSheet, List<ResultBean> beans, int firstRow,
			int endRow, int firstCol, int endCol, String hiddenDatasFirstCell,
			int hiddenTextDatasCol, int hiddenValueDatasCol,
			String referencsName) {
		String hiddenSheetName = hiddenSheet.getSheetName();
		for (int i = 0, length = beans.size(); i < length; i++) {
			Row row = null;
			if (null != hiddenSheet.getRow(i)) {
				row = hiddenSheet.getRow(i);
			} else {
				row = hiddenSheet.createRow(i);
			}
			Cell textCell = row.createCell(hiddenTextDatasCol);
			textCell.setCellValue(beans.get(i).getValue());
			Cell valueCell = row.createCell(hiddenValueDatasCol);
			valueCell.setCellValue(beans.get(i).getKey());
		}
		Name namedCell = wb.createName();
		namedCell.setNameName(referencsName);
		namedCell.setRefersToFormula(hiddenSheetName + hiddenDatasFirstCell
				+ +beans.size());
		DVConstraint constraint = DVConstraint
				.createFormulaListConstraint(referencsName);
		CellRangeAddressList addressList = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		HSSFDataValidation validation = new HSSFDataValidation(addressList,
				constraint);
		workSheet.addValidationData(validation);
		return wb;
	}

	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();// excel文件对象
		HSSFSheet sheetlist = wb.createSheet("sheetlist");// 工作表对象

		FileOutputStream out = new FileOutputStream(
				"d:\\MaterialImportTemplate.xls");
		String[] textlist = { "列表1", "列表2", "列表3", "列表4", "列表5" };
		sheetlist = setHSSFValidation(sheetlist, textlist, 0, 500, 0, 0);// 第一列的前501行都设置为选择列表形式.
		sheetlist = setHSSFPrompt(sheetlist, "promt Title", "prompt Content",
				0, 500, 1, 1);// 第二列的前501行都设置提示.

		HSSFSheet sheetHidden = wb.createSheet("hidden");
		setCellDropDownList(wb, sheetlist, sheetHidden, typeStrings, 1, 10000,
				3, 3, "!$A1:$A", 0, "typeHidden");
		wb.write(out);
		out.close();
	}

	private final static String[] typeStrings = { " 乐器相关", "  休闲鞋", "  奢侈品",
			"  婚庆", "  座垫脚垫", "  服饰寝居", "  玩具乐器", "  生活电器", "  进口食品", " 0-6个月",
			" 1-3岁", " 14岁以上", " 3-6岁", " 3G上网", " 6-12个月", " 6-14岁",
			" ARMANI", " BURBERRY", " CD夹", " COACH", " CPU", " DHA", " DIY玩具",
			" DVD播放机", " FENDI", " GUCCI", " iPhone 配件", " LED灯", " MP3/MP4",
			" MP3/MP4配件", " ONTBLANC", " PRADA", " RAY-BAN", " RIMOWA",
			" SSD固态硬盘", " T区护理", " T恤", " UPS电源", " U盘", " 一体机", " 一次性用品",
			" 一次性餐具", " 三脚架/云台", " 三轮车", " 上衣", " 专业音频", " 专车专用座垫", " 专车专用座套",
			" 专车专用脚垫", " 丝巾", " 丝袜/连裤袜", " 个护健康", " 个护化妆", " 中老年装", " 主板",
			" 乒乓球", " 乒羽鞋", " 书包", " 乳液面霜", " 二手车", " 五金家装", " 五金工具", " 五金电器",
			" 亚健康调理", " 交换机", " 产后塑身", " 亲子装", " 人体润滑", " 仪器仪表", " 仿真模型",
			" 休闲裤", " 休闲运动包", " 休闲零食", " 休闲鞋", " 传真机", " 传统布鞋", " 体温计",
			" 体育娱乐", " 体育娱乐其他", " 便携/无线音响", " 便携GPS导航", " 便携桌椅床", " 保健器械",
			" 保健用品", " 保健茶饮", " 保暖内衣", " 保温杯", " 保温瓶", " 保温箱", " 保险柜", " 保鲜盒",
			" 保鲜膜/袋", " 倒车雷达", " 假发", " 健康礼品", " 健康秤/厨房秤", " 健身器械", " 健身架",
			" 健身玩具", " 储酒器", " 儿童POLO衫", " 儿童T恤", " 儿童内衣/裤", " 儿童凉鞋", " 儿童功能鞋",
			" 儿童单鞋", " 儿童外套/风衣", " 儿童大衣/棉衣", " 儿童套装", " 儿童安全座椅", " 儿童帽衫/卫衣",
			" 儿童手表", " 儿童毛衣/针织衫", " 儿童泳装/裤", " 儿童牛仔裤", " 儿童睡衣/家居服", " 儿童短裤",
			" 儿童羽绒服", " 儿童背心/吊带", " 儿童衬衫/雪纺", " 儿童袜", " 儿童西装/礼服", " 儿童配饰",
			" 儿童长裤", " 充气泵", " 充电器/数据线", " 免疫调节", " 其他", " 其他咖啡具", " 其他水具",
			" 其他配件", " 其它健康电器", " 其它厨房电器", " 其它生活电器", " 养生器械", " 内存",
			" 内衣情趣内衣", " 内衣泳衣", " 内衣／家居服", " 内饰清洁", " 内饰精品", " 军刀刀具", " 军迷用品",
			" 冰箱", " 冲饮谷物", " 冷风扇", " 冻品", " 净化器 ", " 净化除味", " 净水设备", " 凉垫",
			" 凉鞋", " 凉鞋／沙滩鞋", " 减压玩具", " 减震器", " 出行装备", " 刀具配件", " 刀剪菜板",
			" 创意减压", " 创意玩具", " 创意礼品", " 创意配件", " 初乳", " 刹车片", " 刹车盘",
			" 刻录机/光驱", " 刻录碟片/附件", " 剃/脱毛器", " 剃须刀", " 剃须护理", " 剪刀", " 办公家具",
			" 办公打印", " 办公文仪", " 办公文具", " 功能用品", " 功能箱包", " 功能鞋", " 加工类肉食",
			" 加湿器", " 动漫玩具", " 包/背婴带", " 化妆礼品", " 医护美容", " 千足银", " 半成品",
			" 半身裙", " 单反相机", " 单电/微单相机", " 单肩包", " 单鞋", " 南北干货", " 卡通周边",
			" 卡通娃娃", " 卫生巾", " 卫生护垫", " 卫衣", " 卸妆", " 压力锅", " 厨卫五金", " 厨房净水设备",
			" 厨房用品", " 厨房电器", " 厨房配件", " 厨用剪刀", " 厨用杂件", " 参茸礼品", " 双肩包",
			" 取暖电器", " 口琴/口风琴/竖笛", " 口腔咽部", " 口腔护理", " 台式机", " 台灯", " 各式乐器配件",
			" 吉他/贝斯", " 吊坠/项链", " 吊灯", " 后备箱垫", " 后视镜", " 吸奶器", " 吸尘器", " 吸顶灯",
			" 呼叫/会议设备", " 咖啡/奶茶", " 咖啡具", " 咖啡壶", " 咖啡套装", " 咖啡机", " 咖啡杯",
			" 咖啡杯碟", " 咖啡盘/托", " 咖啡配件", " 唇膏唇彩", " 唐装", " 商务休闲鞋", " 商务公文包",
			" 啤酒", " 喂养用品", " 喇叭", " 四季垫", " 围巾", " 国产品牌", " 国外名酒", " 地毯地垫",
			" 垂钓用品", " 基础营养", " 塑身衣", " 墙画墙贴", " 墨盒", " 墨粉", " 声卡/扩展器", " 复合机",
			" 外套", " 外置盒", " 外设产品", " 多功能刀", " 多功能垫", " 多用途清洁", " 多用途锅",
			" 大家电", " 大码装", " 大衣", " 太阳镜", " 太阳镜、眼镜框", " 头饰", " 夹克", " 套刀",
			" 套装", " 套装水具", " 套锅", " 奢侈品", " 奢侈品服饰", " 奢侈品服饰配饰", " 女T恤",
			" 女卫衣", " 女士POLO衫", " 女士T恤 ", " 女士上装", " 女士下装", " 女士仿皮外套",
			" 女士休闲裤", " 女士休闲鞋", " 女士保暖套装", " 女士保暖衣", " 女士保暖裤", " 女士内衣",
			" 女士内衣套装", " 女士内衣配件", " 女士内裤", " 女士凉鞋", " 女士功能鞋", " 女士单鞋", " 女士卫衣",
			" 女士唐装/旗袍", " 女士坡跟鞋", " 女士塑身美体内衣", " 女士增高鞋", " 女士大衣", " 女士夹克",
			" 女士家居鞋", " 女士布鞋/绣花鞋", " 女士帆布鞋", " 女士打底衫", " 女士打底裤", " 女士拖鞋",
			" 女士松糕鞋", " 女士棉衣", " 女士毛衣/针织衫", " 女士泳衣", " 女士牛仔裤", " 女士真皮外套",
			" 女士睡衣/家居服", " 女士秋衣", " 女士秋衣裤套装", " 女士秋裤", " 女士羽绒服", " 女士背心/吊带",
			" 女士衬衣", " 女士衬衫", " 女士西装/正装", " 女士西裤/正装裤", " 女士运动上衣", " 女士运动裤",
			" 女士运动鞋", " 女士连衣裙", " 女士钱包/卡包", " 女士雨衣", " 女士雨鞋/雨靴", " 女士雪纺衫",
			" 女士鞋靴配件", " 女士风衣", " 女士香水", " 女士马甲", " 女士高跟鞋", " 女士鱼嘴鞋", " 女式内裤",
			" 女性护理", " 女性护理其他", " 女牛仔裤", " 女童半身裙", " 女童连衣裙", " 女袜", " 女装套装",
			" 女针织衫", " 女靴", " 女鞋", " 奶嘴", " 奶瓶", " 奶瓶套装", " 奶瓶清洗", " 奶粉",
			" 奶锅", " 妈咪包", " 妈妈专区", " 妈妈护理", " 妈妈美容", " 妈妈鞋", " 娃娃玩具",
			" 婚嫁首饰 ", " 婚宴", " 婚庆服务", " 婚庆用品", " 婚庆礼品/用品", " 婚庆饰品", " 婚纱摄影",
			" 婚纱礼服", " 婴儿内衣", " 婴儿外出服", " 婴儿尿裤", " 婴儿床", " 婴儿��车", " 婴儿用餐具",
			" 婴儿礼盒", " 婴儿鞋帽袜", " 婴幼儿奶粉", " 婴幼儿水具", " 婴幼营养", " 孕妇内衣", " 孕妇装",
			" 孕妇食品", " 孕期营养", " 存储卡", " 学步车", " 学生文具", " 安全座椅", " 安全座椅增高垫",
			" 安全自驾", " 安全避孕", " 安全防护", " 安全预警仪", " 安防监控", " 宝宝护肤", " 宝宝金银",
			" 宝宝零食", " 宝石珍珠", " 宝石珍珠戒指", " 宝石珍珠手镯/手链", " 宝石珍珠耳饰", " 宝石珍珠项链/吊坠",
			" 宠物主粮", " 宠物生活", " 宠物零食", " 家具五金", " 家居", " 家居家装", " 家居床品",
			" 家居日用", " 家庭影院", " 家庭护理", " 家用净水", " 家用清洁", " 家用电器", " 家电配件",
			" 家纺", " 家装软饰", " 对讲机", " 尾喉/排气管", " 尿裤湿巾", " 居室清洁", " 嵌入式导航",
			" 工艺摆件", " 工艺礼品", " 工艺礼品乐器", " 工艺金", " 工艺银", " 工装", " 布艺软饰",
			" 布鞋／绣花鞋", " 帆布鞋", " 帐篷", " 帽子", " 平底鞋", " 平板电脑", " 平板电脑配件",
			" 平板电视", " 床单被罩", " 床品件套", " 床垫/床褥", " 应急救援", " 应急灯/手电", " 底盘装甲",
			" 座便器", " 康复辅助", " 开瓶器", " 录音笔", " 彩妆组合", " 微波炉", " 心脑养护", " 急救卫生",
			" 情景玩具", " 情爱玩具", " 情趣内衣", " 戏水玩具", " 成人奶粉", " 成人尿裤", " 成人用品",
			" 成人用品组合套装", " 成分保健", " 戒指", " 户外仪表", " 户外垫子", " 户外工具", " 户外服装 ",
			" 户外照明", " 户外玩具", " 户外背包", " 户外装备", " 户外配饰", " 户外鞋服", " 户外鞋袜",
			" 手写板", " 手动工具", " 手套", " 手工/十字绣", " 手工彩泥", " 手拿包", " 手提包", " 手机",
			" 手机保护套", " 手机储存卡", " 手机电池", " 手机耳机", " 手机贴膜", " 手机通讯", " 手机配件",
			" 手机饰品", " 手足护理", " 手链/脚链", " 手镯/手链/脚链", " 手风琴", " 打印机", " 打底裤",
			" 扫描仪", " 扭扭车", " 投影机", " 投影配件", " 护理用品", " 护肤套装", " 披肩", " 抱枕/腰靠",
			" 抱枕坐垫", " 抹胸", " 拉拉裤", " 拉杆箱", " 拍立得", " 拖拉玩具", " 拖鞋", " 拼图",
			" 拼插模型", " 挂件", " 挂烫机/熨斗", " 指甲刀", " 按摩器", " 按摩椅", " 排球", " 提篮式",
			" 插座", " 摄像头", " 摄像机", " 摄影摄像", " 摆件", " 摇铃/床铃", " 摩托车装备",
			" 擦车巾/海绵", " 支付设备/POS机", " 收录/音机", " 收纳保鲜", " 收纳用品", " 收藏品",
			" 收藏爱好", " 改善睡眠", " 改装配件", " 散热器", " 数码办公", " 数码相机", " 数码相框",
			" 数码配件", " 整理收纳", " 整车", " 文件管理", " 文胸", " 文胸/抹胸", " 料理/榨汁机",
			" 斜挎包", " 新车", " 方便食品", " 方向盘套", " 旅游用品", " 旅行包 ", " 旅行配件",
			" 无糖食品", " 日本品牌", " 早教启智", " 时尚品牌", " 时尚影音", " 时尚男包", " 时尚饰品",
			" 显卡", " 显示器", " 智能娃娃", " 智能设备", " 暖奶/消毒", " 更多品牌", " 更多礼品",
			" 更多调理", " 有机食品", " 服务器", " 服饰寝居其他", " 服饰鞋靴", " 望远镜", " 本册/便签",
			" 机器人/电动", " 机油", " 机油滤", " 机箱", " 机身附件", " 极限轮滑", " 枕芯枕套",
			" 果泥/果汁", " 果蔬解毒机", " 染发造型", " 框镜", " 桌布/罩件", " 棉服", " 棉服／羽绒服",
			" 棉签", " 棋牌麻将", " 棒球帽", " 模型玩具", " 正装裤", " 正装鞋", " 武术搏击", " 母婴用品",
			" 毛垫", " 毛巾家纺", " 毛巾被/毯", " 毛线", " 毛绒/布艺", " 毛绒布艺", " 民族管弦乐器",
			" 氛围照明", " 水", " 水具", " 水壶", " 水晶玛瑙", " 水晶玛瑙头饰/胸针", " 水晶玛瑙戒指",
			" 水晶玛瑙手镯/手链/脚链", " 水晶玛瑙摆件/挂件", " 水晶玛瑙耳饰", " 水杯", " 水果", " 水槽",
			" 水瓶", " 汤锅", " 汽修工具", " 汽车用品", " 汽车美容", " 沐浴", " 沙发垫套", " 油污清洁",
			" 泳衣", " 洁身器", " 洁面乳", " 洗发护发", " 洗手液", " 洗护套装", " 洗护用品", " 洗晒用品",
			" 洗洁精", " 洗浴用品", " 洗液", " 洗衣机", " 洗衣液/皂", " 洗车器", " 洗车水枪", " 洗车液",
			" 洗车配件", " 浴室用品", " 浴霸/排气扇", " 海鲜水产", " 消毒柜/洗碗机", " 淋浴花洒", " 添加剂",
			" 清洁咖啡壶", " 清洁工具", " 清洁日用", " 清洁机", " 清火/开胃", " 游戏本", " 游戏设备",
			" 游泳用具", " 湿巾", " 滋补调养", " 滑板车", " 滤镜", " 漆面修复", " 漆面美容", " 漱口水",
			" 潮流女包", " 激光笔", " 火机烟具", " 火花塞", " 灯具", " 炒锅", " 炫舞毯", " 点钞机",
			" 烘焙/烧烤", " 烟机/灶具", " 烤盘", " 烧烤用品", " 烫伤止痒", " 热水器", " 烹饪锅具",
			" 煎锅", " 煮蛋器", " 煲类", " 熏香精油", " 燃油滤", " 爬行垫/毯", " 爽肤水", " 牙刷/牙线",
			" 牙胶/安抚", " 牙膏/牙粉", " 牛奶", " 特色鞋", " 玩具服饰", " 玻璃清洁", " 玻璃美容",
			" 珠宝", " 珠宝手表", " 理发器", " 瑜伽垫", " 瑜伽套装", " 瑜伽服", " 瑜伽配件", " 瑞士品牌",
			" 瓜果刀/刨", " 生殖泌尿", " 生活日用", " 生活电器", " 生鲜食品", " 电动工具", " 电动牙刷",
			" 电动车", " 电压力锅", " 电吹风", " 电子书", " 电子教育", " 电子琴", " 电子电器", " 电子词典",
			" 电工电料", " 电影周边", " 电气开关", " 电水壶/热水瓶", " 电池/充电器", " 电源", " 电炖锅",
			" 电烤箱", " 电热毯", " 电磁炉", " 电脑工具", " 电脑数码包", " 电脑整机", " 电脑清洁",
			" 电脑配件", " 电脑音乐", " 电视盒", " 电话机", " 电风扇", " 电饭煲", " 电饼铛/烧烤盘",
			" 男T恤", " 男卫衣", " 男士POLO衫", " 男士T恤", " 男士上装", " 男士下装", " 男士中山装/唐装",
			" 男士中老年装", " 男士仿皮外套", " 男士休闲裤", " 男士休闲鞋", " 男士保暖套装", " 男士保暖衣",
			" 男士保暖裤", " 男士内衣", " 男士内衣套装", " 男士内裤", " 男士凉鞋", " 男士功能鞋", " 男士卫衣",
			" 男士唇膏", " 男士商务休闲鞋", " 男士增高鞋", " 男士大码装", " 男士大衣", " 男士夹克",
			" 男士家居鞋", " 男士工装上衣", " 男士工装鞋", " 男士帆布鞋", " 男士手包", " 男士打底衣/裤",
			" 男士护理", " 男士拖鞋", " 男士棉服", " 男士棉衣", " 男士正装鞋", " 男士毛衣/针织衫",
			" 男士泳衣/裤", " 男士牛仔裤", " 男士男装套装", " 男士真皮外套", " 男士眼部护理", " 男士睡衣/家居服",
			" 男士秋衣", " 男士秋衣裤套装", " 男士秋裤", " 男士羽绒服", " 男士背心", " 男士衬衣", " 男士衬衫",
			" 男士西服", " 男士西服/正装", " 男士西裤", " 男士身体护理", " 男士运动上衣", " 男士运动裤",
			" 男士运动鞋", " 男士钱包/卡包", " 男士雨衣", " 男士雨鞋/雨靴", " 男士鞋配件", " 男士鞋靴配件",
			" 男士风衣", " 男士香水", " 男士马甲", " 男式内裤", " 男牛仔裤", " 男袜", " 男针织衫", " 男靴",
			" 男鞋", " 登山包", " 登山攀岩", " 白板/封装", " 皮具护理", " 皮带", " 皮衣", " 皮衣皮草",
			" 益智玩具", " 益生菌/初乳", " 监控安防", " 相机包", " 相机清洁", " 相机贴膜", " 相框/相片墙",
			" 眉笔", " 眼影/眼线", " 眼部保健", " 眼部护理", " 睡衣", " 睡袋", " 睡袍／浴袍", " 睫毛膏",
			" 短外套", " 砧板", " 硒鼓", " 硬盘", " 碎纸机", " 碗/碟/盘", " 磁力棒", " 磨砂/浴盐",
			" 礼卡礼券", " 礼品", " 礼品文具", " 礼品箱包", " 礼服／演出服", " 禽蛋", " 积木", " 积木拼插",
			" 移动电源", " 移动硬盘", " 空气净化", " 空气滤", " 空调", " 空调清洗剂", " 空调滤",
			" 窗帘窗纱", " 立体拼插", " 童装", " 童装套装 ", " 童车童床", " 笔类", " 笔记本",
			" 笔记本配件", " 筒靴", " 筷勺/刀叉", " 箱包", " 箱包皮具", " 篮球", " 篮球鞋", " 米粉/菜粉",
			" 米面杂粮", " 粉底/遮瑕", " 粮油调味", " 精华露", " 糖果巧克力", " 系统养护", " 纤体瑜伽",
			" 纤体瘦身", " 纯金K金饰品", " 纯金K金饰品戒指", " 纯金K金饰品耳饰", " 纸品湿巾", " 纸类",
			" 线缆", " 组合套装", " 绘画工具", " 缝纫用品", " 网卡", " 网游周边", " 网球", " 网络产品",
			" 网络存储", " 网络盒子", " 置物箱", " 美体养颜", " 美体塑身", " 美发器", " 美妆工具",
			" 美容器", " 美容食品", " 美甲", " 美腿袜", " 羽毛球", " 羽绒服／棉服", " 翡翠玉石",
			" 翡翠玉石戒指", " 翡翠玉石手镯/手串", " 翡翠玉石挂件/摆件/把件", " 翡翠玉石耳饰", " 翡翠玉石项链/吊坠",
			" 考勤机", " 耗材", " 耳机/耳麦", " 耳饰", " 肉松/饼干", " 肝肾养护", " 背心", " 胎压监测",
			" 胸针", " 脱毛膏", " 脸部护理", " 腕表", " 腮红", " 腰带", " 腰带／礼盒", " 腰链／腰封",
			" 自行车", " 自驾照明", " 自驾野营", " 舞蹈鞋服", " 色带", " 节庆饰品", " 节能灯", " 芭比娃娃",
			" 苹果配件", " 茶具", " 茶具套装", " 茶具配件", " 茶叶", " 茶叶罐", " 茶壶", " 茶宠摆件",
			" 茶杯", " 茶炉", " 茶盘茶托", " 草帽", " 菜刀", " 营养健康", " 营养品", " 营养辅食",
			" 落地灯", " 葡萄酒", " 蒸锅", " 蓄电池", " 蓝牙耳机", " 蔬菜", " 蚊帐/凉席", " 血压计",
			" 血糖仪", " 行车记录仪", " 衣物清洁", " 补漆笔", " 袖扣", " 被子", " 装机配件", " 装饰灯",
			" 装饰贴", " 裙子", " 裤子", " 裸钻", " 裸靴", " 西服", " 西服套装", " 西洋打击乐器",
			" 西洋管弦乐", " 西裤", " 计步器/脂肪检测仪", " 计算器", " 训练鞋", " 读卡器", " 调味品",
			" 调料器皿", " 调节三高 ", " 调酒器具", " 豆浆机", " 豆豆鞋", " 财务用品", " 贴膜", " 超极本",
			" 足浴盆", " 足球", " 足球鞋", " 跌打损伤", " 跑步鞋", " 跟踪防盗器", " 路由器", " 踏板",
			" 身体乳", " 身体护理", " 车掸", " 车灯", " 车用炭包", " 车用香水", " 车衣", " 车载冰箱",
			" 车载净化器", " 车载吸尘器", " 车载影音", " 车载生活电器", " 车载电源", " 车载蓝牙", " 车载配件",
			" 车锁地锁", " 轨道/助力", " 轮胎", " 轮胎轮毂清洗", " 辅助用品", " 辅食", " 运动",
			" 运动T恤", " 运动健康", " 运动包", " 运动器材", " 运动器械", " 运动护具", " 运动裤",
			" 运动配件", " 运动鞋", " 连衣裙", " 连裤袜", " 迷你音响", " 迷你香水", " 适用年龄",
			" 通用脚垫", " 遥控/电动", " 遥控船", " 遥控车", " 遥控飞机", " 遮阳帽", " 遮阳挡雪挡",
			" 配件", " 配饰", " 配饰其他配件", " 配饰腰带", " 酒具", " 酒具套装", " 酒具配件", " 酒店用品",
			" 酒杯", " 酒柜/冰吧/冷柜 ", " 酸奶机", " 醒酒器", " 野餐炊具", " 金属养护", " 金银投资",
			" 针织衫", " 钙铁锌/维生素", " 钟表手表", " 钢琴", " 钱包", " 钻石饰品", " 钻石饰品戒指",
			" 钻石饰品手镯/手链", " 钻石饰品耳饰", " 钻石饰品项链/吊坠", " 银饰", " 银饰吊坠/项链",
			" 银饰戒指/耳饰", " 银饰手镯/手链/脚链", " 键盘", " 镜头", " 镜头附件", " 门铃", " 闪光灯/手柄",
			" 闹钟挂钟", " 防冻冷却液", " 防晒隔离", " 防紫外线手套", " 防脱洗护", " 防裂抗冻", " 防辐射服",
			" 附属油", " 除湿/干衣机", " 雨伞雨具", " 雨刷", " 雨鞋／雨靴", " 雪地靴", " 雪纺衫",
			" 靠垫/抱枕", " 面包机", " 面条/粥", " 面膜面贴", " 面部护理", " 靴子", " 鞋配件", " 鞋靴",
			" 音箱", " 项链", " 领带", " 颈枕/头枕", " 颈部护理", " 风湿骨痛", " 风衣", " 食品饮料",
			" 食用油", " 餐具", " 餐具套装", " 餐椅摇椅", " 餐饮厨房清洁", " 饭盒/提锅", " 饮料",
			" 饮料冲调", " 饮水机", " 饰品", " 饰品配件", " 饼干蛋糕", " 香体走珠", " 香水SPA",
			" 香水SPA男士香水", " 香水彩妆", " 香皂", " 香薰精油", " 马甲", " 马甲/背心", " 驱虫用品",
			" 驱蚊防蚊", " 驾车鞋", " 验孕测孕", " 骑行运动", " 骨骼健康", " 高值收藏", " 高尔夫球",
			" 高档化妆品", " 高档珠宝手表", " 高清播放器", " 高级面部护理", " 高跟鞋 ", " 魅力彩妆", " 鱼嘴鞋",
			" 鲜肉", " 鲜花速递", " 麦克风", " 鼠标", " 鼠标垫", " 鼻炎健康", " 龙头" };
}
