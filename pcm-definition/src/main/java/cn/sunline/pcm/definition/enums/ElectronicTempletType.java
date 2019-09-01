package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 电子资料模板类型
* @author lisy
 *
 */
@EnumInfo({
	"N|公安照片",
	"P|申请人照片",
	"F|身份证正面",
	"R|身份证反面",
	"W|代扣银行卡",
	"A|工作证明或学生证明",
	"S|社保卡",
	"B|户口本",
	"C|工资卡及其流水",
	"E|信用卡与其对应上期电子账单",
	"L|居住证明",
	"H|房产登记证或房产使用权证明",
	"G|客户与RA合照",
	"T|购货小票",
	"D|人脸识别照片",
	"Z|其他"
})
public enum ElectronicTempletType {
	/**
	 * 公安照片
	 */
	N("公安照片"),
	
	/**
	 * 申请人照片
	 */
	P("申请人照片"),
	
	/**
	 * 身份证正面
	 */
	F("身份证正面"),
	
	/**
	 * 身份证反面
	 */
	R("身份证反面"),
	
	/**
	 * 代扣银行卡
	 */
	W("代扣银行卡"),
	
	/**
	 * 工作证明或学生证明
	 */
	A("工作证明或学生证明"),
	
	/**
	 * 社保卡
	 */
	S("社保卡"),
	
	/**
	 * 户口本
	 */
	B("户口本"),
	
	/**
	 * 工资卡及其流水
	 */
	C("工资卡及其流水"),
	/**
	 * 信用卡与其对应上期电子账单（去掉）
	 */
	E("信用卡与其对应上期电子账单"),
	
	/**
	 * 居住证明
	 */
	L("居住证明"),
	
	/**
	 * 房产登记证或房产使用权证明
	 */
	H("房产登记证或房产使用权证明"),
	
	/**
	 * 客户与RA合照
	 */
	G("客户与RA合照"),
	
	/**
	 * 购货小票
	 */
	T("购货小票"),
	
	/**
	 * 人脸识别照片
	 */
	D("人脸识别照片"),
	
	/**
	 * 其他
	 */
	Z("其他");
	
	String cnName;
	private ElectronicTempletType(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCnName() {
		return this.cnName;
	}
}
