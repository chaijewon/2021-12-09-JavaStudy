package com.sist.lib;
/*
 *   磊官 
 *   1) 巩过 
 *      =========> 1~8厘 (函荐 , 硅凯 , 努贰胶 , 楷魂磊 , 力绢巩,皋家靛)
 *   2) 侩档 
 *      =========> 努贰胶,皋家靛 , 函荐 (牢胶畔胶 , static)
 *                 ===== 攫力 牢磐其捞胶 , 皋家靛 (府畔屈,概俺函荐)
 *                 ===== 抗寇贸府 (try~catch , throws)
 *   3) 炼赋 
 *      荤侩磊 沥狼 努贰胶 + 扼捞宏矾府 
 *   4) 鉴辑 (舅绊府硫) 
 *      => 家胶甫 鞠扁 => 鉴辑 
 *      => 磊官俊辑 啊厘 浆款 橇肺弊伐 
 *         =====================
 *          匙飘况农 / 单捞磐海捞胶 =====> 葛电 俺惯磊啊 悼老 内爹 (钎霖拳)
 *      => 备备窜 / 其捞瘤 (奖促)
 *         2瞒 for   1瞒 for 
 *   ==> 馆汗 / 困摹 犬牢 / CV ==> 盒籍 
 *   450page 
 *   java.lang    java.util   java.io    java.net  java.sql  java.text
 *   javax.xml    org.w3c.dom  org.w3c.sax 
 *   javax.http(JSP)
 *   
 *   1. java.lang ==> import甫 积帆且 荐 乐促 
 *      =========
 *      1) Object : 葛电 努贰胶(荤侩磊沥狼,扼捞宏矾府)狼 惑加阑 郴府绰 努贰胶 
 *         class A (extends Object) 积帆捞 等促 
 *         = toString(按眉甫 巩磊凯拳)
 *         = finalize() : 家戈磊 皋家靛 (按眉啊 皋葛府俊辑 秦力 磊悼 龋免登绰 皋家靛)
 *         = clone() : 汗力 ==> 胶橇傅 (prototype)
 *      2) String / StringBuffer / StringBuilder
 *         扼捞宏矾府 : 盔屈 , 侩档 
 *           盔屈 
 *           public int length()
 *         = String (巩磊凯 力绢窍绰 皋家靛)
 *           = length() : 巩磊 肮荐 => ...
 *             盔屈) public int length()
 *           = equals() : 巩磊凯阑 厚背 (==(X)) => 肺弊牢 , id吝汗眉农
 *             (措家巩磊 备盒) 
 *             盔屈) public boolean equals(String s)
 *           = equalsIgnoreCase() : 巩磊凯 厚背 (措家巩磊 备盒 绝捞)
 *             八祸扁 
 *             盔屈) public boolean equalsIgnoreCase(String s)
 *           = substring() : 盔窍绰 何盒父 巩磊凯甫 磊福绰 开且 
 *             盔屈)
 *                  public String substring(int start)
 *                  public String substring(int start,int end)
 *           = trim() : 谅快 傍归阑 力芭且锭 荤侩 
 *             => 荤侩磊啊 角荐肺 space甫 荤侩 => 哭率俊 傍归捞 乐绢辑 
 *                茫扁啊 绢菲促 
 *             => public String trim() => 傍归巩磊 力芭饶 促矫 府畔
 *           = indexOf ==> 巩磊甫 茫扁 (菊俊辑)
 *             => public int indexOf(String s)
 *                public int indexOf(char c)
 *           = lastIndexOf ==> 巩磊甫 茫扁 (第俊辑)
 *             => public int lastIndexOf(String s)
 *                public int lastIndexOf(char c)
 *           = split() ==> 巩磊凯阑 盒府 
 *             => public String[] split(String regex) 
 *           = replace() ==> 巩磊茄俺 函版 
 *             => public String replace(char c1,char c2)
 *                public String replace(String c1,String c2)
 *           = replaceAll() ==> 巩磊 傈眉 函版(沥痹侥)
 *             => public String replaceAll(String s1,String s2)
 *                茄臂 [啊-芌]
 *                康巩 [A-Za-z]
 *                箭磊 [0-9]
 *           = charAt() => 巩磊凯吝俊 巩磊茄俺 磊福绰 版快
 *             => public char charAt(int index) 
 *           ======================================
 *           = startsWith : 矫累巩磊凯
 *             => public boolean startsWith(String s)
 *           = endsWith : 场唱绰 巩磊凯 
 *             => public boolean endsWith(String s)
 *           磊悼肯己扁 (辑力胶飘) ==> 八祸扁 , Cookie备盒 
 *           ======================================
 *           = toUpperCase : 措巩磊 函券
 *             => public String toUpperCase()
 *           = toLowerCase : 家巩磊 函券 
 *           => public String toLowerCase()
 *           = valueOf() :葛电 单捞磐屈阑 巩磊凯肺 函券 
 *           => valueOf(3) ==> "3"
 *              valueOf(true) ==> "true"
 *              public static String valueOf(int a)
 *              public static String valueOf(boolean a)
 *              public static String valueOf(char a)
 *              public static String valueOf(float a)
 *              ..
 *              ..
 *              ..
 *      3) Math 
 *          => ceil : 棵覆 
 *          => random : 抄荐 
 *      4) Wrapper : 葛电 单捞磐屈阑 努贰胶 
 *         =========
 *          byte ==> Byte 
 *          short ==> Short 
 *          int  ==> Integer
 *          double ==> Double 
 *          float  ==> Float 
 *          boolean ==> Boolean
 *      5) System 
 *         =========
 *           System.in
 *           System.out
 *           System.gc() => 钢萍固叼绢 , 拳惑 ...
 */
/*
 *   Object : 葛电 努贰胶狼 弥惑困 努贰胶 (葛电 努贰胶绰 Object肺 何磐 惑加)
 *   => Object啊 啊瘤绊 乐绰 葛电 皋家靛甫 荤侩且 荐 乐促 
 *   => 磊官 努贰胶 
 *      class A extends Object
 *              =============== 磊悼 积己捞 啊瓷窍霸 力累 
 *      = toString()
 *      = finalize() 
 *      = clone() 
 *      = 按眉 荤侩 规过 
 *        = 曼炼
 *        = 汗力 
 */
class Sawon /* extends Object */
{
	private String name;
	public Sawon(String name)
	{
		// 积己磊 => 函荐狼 檬扁拳 
		System.out.println("Sawon 按眉 皋葛府俊 历厘");
		this.name=name;
	}
	//免仿 
	public void print()
	{
		// 按眉 扁瓷 劝侩
		System.out.println("捞抚:"+name);
	}
	//皋葛府俊 秦力 
	//按眉狼 皋葛府俊辑 荤扼龙锭 磊悼龋免登绰 皋家靛 (家戈磊)
	/*
	 *   A()  ==> new 
	 *   ~A() ==> 皋葛府 秦力 delete (GC) => 磊悼 皋葛府 秦力 
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Sawon 按眉 皋葛府 秦力...");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sawon捞 啊瘤绊 乐绰 捞抚篮 "+name+"涝聪促";
	}
	
	// Object俊辑 犁沥狼 (坷滚扼捞爹) => toString()
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 荤盔 扁瓷 荤侩 
		// 1. 皋葛府俊 历厘 
		Sawon s=new Sawon("全辨悼");
		// com.sist.lib.Sawon@5e91993f
		System.out.println(s.toString());// 林家蔼阑 免仿
		System.out.println(s);
		// 2. 劝侩 
		s.print();
		// 3. 皋葛府 秦力 => s=null (GC)
		s=null; // 荤侩窍瘤 臼绰促 
		// 4. 流立 秦力 
		System.gc(); // 啊厚瘤拿泛记 龋免 (皋葛府俊辑 荤侩窍瘤 臼芭唱 , null老锭 雀荐)
		// finalize()啊 龋免登搁 皋葛府俊辑 力芭
		
	}

}



