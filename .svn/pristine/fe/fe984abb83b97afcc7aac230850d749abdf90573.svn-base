package com.shop.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @FileName : StringUtil.java
 * @프로그램 설명 : 문자열 데이터 처리 관련 유틸리티
 */
public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
    /**
     * 빈 문자열 <code>""</code>.
     */
    public static final String EMPTY = "";
    
    /**
     * <p>Padding을 할 수 있는 최대 수치</p>
     */
    // private static final int PAD_LIMIT = 8192;
    /**
     * <p>An array of <code>String</code>s used for padding.</p>
     * <p>Used for efficient space padding. The length of each String expands as needed.</p>
     */
    /*
	private static final String[] PADDING = new String[Character.MAX_VALUE];

	static {
		// space padding is most common, start with 64 chars
		PADDING[32] = "                                                                ";
	}	
     */	
	
    /**
     * 문자열이 지정한 길이를 초과했을때 지정한길이에다가 해당 문자열을 붙여주는 메서드.
     * @param source 원본 문자열 배열
     * @param output 더할문자열
     * @param slength 지정길이
     * @return 지정길이로 잘라서 더할분자열 합친 문자열
     */
    public static String cutString(String source, String output, int slength) {
        String returnVal = null;
        if (source != null) {
            if (source.length() > slength) {
                returnVal = source.substring(0, slength) + output;
            } else
                returnVal = source;
        }
        return returnVal;
    }

    /**
     * 문자열이 지정한 길이를 초과했을때 해당 문자열을 삭제하는 메서드
     * @param source 원본 문자열 배열
     * @param slength 지정길이
     * @return 지정길이로 잘라서 더할분자열 합친 문자열
     */
    public static String cutString(String source, int slength) {
        String result = null;
        if (source != null) {
            if (source.length() > slength) {
                result = source.substring(0, slength);
            } else
                result = source;
        }
        return result;
    }    
    
    /**
     * <p>
     * String이 비었거나("") 혹은 null 인지 검증한다.
     * </p>
     * 
     * <pre>
     *  StringUtil.isEmpty(null)      = true
     *  StringUtil.isEmpty("")        = true
     *  StringUtil.isEmpty(" ")       = false
     *  StringUtil.isEmpty("bob")     = false
     *  StringUtil.isEmpty("  bob  ") = false
     * </pre>
     * 
     * @param str - 체크 대상 스트링오브젝트이며 null을 허용함
     * @return <code>true</code> - 입력받은 String 이 빈 문자열 또는 null인 경우 
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * <p>기준 문자열에 포함된 모든 대상 문자(char)를 제거한다.</p>
     *
     * <pre>
     * StringUtil.remove(null, *)       = null
     * StringUtil.remove("", *)         = ""
     * StringUtil.remove("queued", 'u') = "qeed"
     * StringUtil.remove("queued", 'z') = "queued"
     * </pre>
     *
     * @param str  입력받는 기준 문자열
     * @param remove  입력받는 문자열에서 제거할 대상 문자열
     * @return 제거대상 문자열이 제거된 입력문자열. 입력문자열이 null인 경우 출력문자열은 null
     */
    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }
   
    /**
    * <pre>
    * 1. MethodName : setCommaChar
    * 2. ClassName  : StringUtil.java
    * 3. Comment    : 숫자에 콤마를 찍는다. 
    * </pre>
    *
    * @param num
    * @return
    */
    public static String setComma (int num)
    {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(getInt(num));
    }
    
    /**
    * <pre>
    * 1. MethodName : setComma
    * 2. ClassName  : StringUtil.java
    * 3. Comment    : 숫자에 콤마를 찍는다.  
    * </pre>
    *
    * @param num
    * @return
    */
    public static String setComma (String num)
    {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(getString(num, "0"));
    }
    
    /**
     * <p>문자열 내부의 콤마 character(,)를 모두 제거한다.</p>
     *
     * <pre>
     * StringUtil.removeCommaChar(null)       = null
     * StringUtil.removeCommaChar("")         = ""
     * StringUtil.removeCommaChar("asdfg,qweqe") = "asdfgqweqe"
     * </pre>
     *
     * @param str 입력받는 기준 문자열
     * @return " , "가 제거된 입력문자열
     *  입력문자열이 null인 경우 출력문자열은 null
     */
    public static String removeCommaChar(String str) {
        return remove(str, ',');
    }
    
    /**
     * <p>문자열 내부의 마이너스 character(-)를 모두 제거한다.</p>
     *
     * <pre>
     * StringUtil.removeMinusChar(null)       = null
     * StringUtil.removeMinusChar("")         = ""
     * StringUtil.removeMinusChar("a-sdfg-qweqe") = "asdfgqweqe"
     * </pre>
     *
     * @param str  입력받는 기준 문자열
     * @return " - "가 제거된 입력문자열
     *  입력문자열이 null인 경우 출력문자열은 null
     */
    public static String removeMinusChar(String str) {
        return remove(str, '-');
    }
        
    
    /**
     * 원본 문자열의 포함된 특정 문자열을 새로운 문자열로 변환하는 메서드
     * @param source 원본 문자열
     * @param subject 원본 문자열에 포함된 특정 문자열
     * @param object 변환할 문자열
     * @return sb.toString() 새로운 문자열로 변환된 문자열
     */
    public static String replace(String source, String subject, String object) {
        StringBuffer rtnStr = new StringBuffer();
        String preStr = "";
        String nextStr = source;
        String srcStr  = source;
        
        while (srcStr.indexOf(subject) >= 0) {
            preStr = srcStr.substring(0, srcStr.indexOf(subject));
            nextStr = srcStr.substring(srcStr.indexOf(subject) + subject.length(), srcStr.length());
            srcStr = nextStr;
            rtnStr.append(preStr).append(object);
        }
        rtnStr.append(nextStr);
        return rtnStr.toString();
    }

    /**
     * 원본 문자열의 포함된 특정 문자열 첫번째 한개만 새로운 문자열로 변환하는 메서드
     * @param source 원본 문자열
     * @param subject 원본 문자열에 포함된 특정 문자열
     * @param object 변환할 문자열
     * @return sb.toString() 새로운 문자열로 변환된 문자열 / source 특정문자열이 없는 경우 원본 문자열
     */
    public static String replaceOnce(String source, String subject, String object) {
        StringBuffer rtnStr = new StringBuffer();
        String preStr = "";
        String nextStr = source;
        if (source.indexOf(subject) >= 0) {
            preStr = source.substring(0, source.indexOf(subject));
            nextStr = source.substring(source.indexOf(subject) + subject.length(), source.length());
            rtnStr.append(preStr).append(object).append(nextStr);
            return rtnStr.toString();
        } else {
            return source;
        }
    }

    /**
     * <code>subject</code>에 포함된 각각의 문자를 object로 변환한다.
     * 
     * @param source 원본 문자열
     * @param subject 원본 문자열에 포함된 특정 문자열
     * @param object 변환할 문자열
     * @return sb.toString() 새로운 문자열로 변환된 문자열
     */
    public static String replaceChar(String source, String subject, String object) {
        StringBuffer rtnStr = new StringBuffer();
        String preStr = "";
        String nextStr = source;
        String srcStr  = source;
        
        char chA;

        for (int i = 0; i < subject.length(); i++) {
            chA = subject.charAt(i);

            if (srcStr.indexOf(chA) >= 0) {
                preStr = srcStr.substring(0, srcStr.indexOf(chA));
                nextStr = srcStr.substring(srcStr.indexOf(chA) + 1, srcStr.length());
                srcStr = rtnStr.append(preStr).append(object).append(nextStr).toString();
            }
        }
        
        return srcStr;
    }  
    
    /**
     * <p><code>str</code> 중 <code>searchStr</code>의 시작(index) 위치를 반환.</p>
     *
     * <p>입력값 중 <code>null</code>이 있을 경우 <code>-1</code>을 반환.</p>
     *
     * <pre>
     * StringUtil.indexOf(null, *)          = -1
     * StringUtil.indexOf(*, null)          = -1
     * StringUtil.indexOf("", "")           = 0
     * StringUtil.indexOf("aabaabaa", "a")  = 0
     * StringUtil.indexOf("aabaabaa", "b")  = 2
     * StringUtil.indexOf("aabaabaa", "ab") = 1
     * StringUtil.indexOf("aabaabaa", "")   = 0
     * </pre>
     *
     * @param str  검색 문자열
     * @param searchStr  검색 대상문자열
     * @return 검색 문자열 중 검색 대상문자열이 있는 시작 위치 검색대상 문자열이 없거나 null인 경우 -1
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }    
    
    
    /**
     * <p>오라클의 decode 함수와 동일한 기능을 가진 메서드이다.
     * <code>sourStr</code>과 <code>compareStr</code>의 값이 같으면
     * <code>returStr</code>을 반환하며, 다르면  <code>defaultStr</code>을 반환한다.
     * </p>
     * 
     * <pre>
     * StringUtil.decode(null, null, "foo", "bar")= "foo"
     * StringUtil.decode("", null, "foo", "bar") = "bar"
     * StringUtil.decode(null, "", "foo", "bar") = "bar"
     * StringUtil.decode("하이", "하이", null, "bar") = null
     * StringUtil.decode("하이", "하이  ", "foo", null) = null
     * StringUtil.decode("하이", "하이", "foo", "bar") = "foo"
     * StringUtil.decode("하이", "하이  ", "foo", "bar") = "bar"
     * </pre>
     * 
     * @param sourceStr 비교할 문자열
     * @param compareStr 비교 대상 문자열
     * @param returnStr sourceStr와 compareStr의 값이 같을 때 반환할 문자열
     * @param defaultStr sourceStr와 compareStr의 값이 다를 때 반환할 문자열
     * @return sourceStr과 compareStr의 값이 동일(equal)할 때 returnStr을 반환하며,
     *         <br/>다르면 defaultStr을 반환한다.
     */
    public static String decode(String sourceStr, String compareStr, String returnStr, String defaultStr) {
        if (sourceStr == null && compareStr == null) {
            return returnStr;
        }
        
        if (sourceStr == null && compareStr != null) {
            return defaultStr;
        }

        if (sourceStr.trim().equals(compareStr)) {
            return returnStr;
        }

        return defaultStr;
    }

    /**
     * <p>오라클의 decode 함수와 동일한 기능을 가진 메서드이다.
     * <code>sourStr</code>과 <code>compareStr</code>의 값이 같으면
     * <code>returStr</code>을 반환하며, 다르면  <code>sourceStr</code>을 반환한다.
     * </p>
     * 
     * <pre>
     * StringUtil.decode(null, null, "foo") = "foo"
     * StringUtil.decode("", null, "foo") = ""
     * StringUtil.decode(null, "", "foo") = null
     * StringUtil.decode("하이", "하이", "foo") = "foo"
     * StringUtil.decode("하이", "하이 ", "foo") = "하이"
     * StringUtil.decode("하이", "바이", "foo") = "하이"
     * </pre>
     * 
     * @param sourceStr 비교할 문자열
     * @param compareStr 비교 대상 문자열
     * @param returnStr sourceStr와 compareStr의 값이 같을 때 반환할 문자열
     * @return sourceStr과 compareStr의 값이 동일(equal)할 때 returnStr을 반환하며,
     *         <br/>다르면 sourceStr을 반환한다.
     */
    public static String decode(String sourceStr, String compareStr, String returnStr) {
        return decode(sourceStr, compareStr, returnStr, sourceStr);
    }    

    /**
     * 1. MethodName	: nullCheck
     * 2. ClassName		: StringUtil
     * 3. Commnet		:
     * @return boolean
     * @param obj
     * @return
     */
    public static boolean nullCheck(Object obj) {
        boolean nullStatus = false;
        if(obj == null) {
             nullStatus = true;
        }
        else {
            nullStatus = false;
        }

        return nullStatus;
    }
    
    /**
     * 객체가 null인지 확인하고 null인 경우 "" 로 바꾸는 메서드
     * @param object 원본 객체
     * @return resultVal 문자열
     */
    public static String isNullToString(Object object) {
        String string = "";
        
        if (object != null) {
            string = object.toString().trim();
        }
        
        return string;
    }
    
    /**
     *<pre>
     * 인자로 받은 String이 null일 경우 &quot;&quot;로 리턴한다.
     * &#064;param src null값일 가능성이 있는 String 값.
     * &#064;return 만약 String이 null 값일 경우 &quot;&quot;로 바꾼 String 값.
     *</pre>
     */
    public static String nullConvert(Object src) {
		//if (src != null && src.getClass().getName().equals("java.math.BigDecimal")) {
		if (src != null && src instanceof java.math.BigDecimal) {
		    return ((BigDecimal)src).toString();
		}
	
		if (src == null || src.equals("null")) {
		    return "";
		} else {
		    return ((String)src).trim();
		}
    }
    
    /**
     *<pre>
     * 인자로 받은 String이 null일 경우 &quot;&quot;로 리턴한다.
     * &#064;param src null값일 가능성이 있는 String 값.
     * &#064;return 만약 String이 null 값일 경우 &quot;&quot;로 바꾼 String 값.
     *</pre>
     */
    public static String nullConvert(String src) {

		if (src == null || src.equals("null") || "".equals(src) || " ".equals(src)) {
		    return "";
		} else {
		    return src.trim();
		}
    }	
	
    /**
     *<pre>
     * 인자로 받은 String이 null일 경우 &quot;0&quot;로 리턴한다.
     * &#064;param src null값일 가능성이 있는 String 값.
     * &#064;return 만약 String이 null 값일 경우 &quot;0&quot;로 바꾼 String 값.
     *</pre>
     */
    public static int zeroConvert(Object src) {

		if (src == null || src.equals("null")) {
		    return 0;
		} else {
		    return Integer.parseInt(((String)src).trim());
		}
    }

    /**
     *<pre>
     * 인자로 받은 String이 null일 경우 &quot;&quot;로 리턴한다.
     * &#064;param src null값일 가능성이 있는 String 값.
     * &#064;return 만약 String이 null 값일 경우 &quot;&quot;로 바꾼 String 값.
     *</pre>
     */
    public static int zeroConvert(String src) {

		if (src == null || src.equals("null") || "".equals(src) || " ".equals(src)) {
		    return 0;
		} else {
		    return Integer.parseInt(src.trim());
		}
    }
	
    /**
     * <p>문자열에서 {@link Character#isWhitespace(char)}에 정의된 
     * 모든 공백문자를 제거한다.</p>
     *
     * <pre>
     * StringUtil.removeWhitespace(null)         = null
     * StringUtil.removeWhitespace("")           = ""
     * StringUtil.removeWhitespace("abc")        = "abc"
     * StringUtil.removeWhitespace("   ab  c  ") = "abc"
     * </pre>
     *
     * @param str  공백문자가 제거도어야 할 문자열
     * @return the 공백문자가 제거된 문자열, null이 입력되면 <code>null</code>이 리턴
     */
    public static String removeWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int sz = str.length();
        char[] chs = new char[sz];
        int count = 0;
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
        if (count == sz) {
            return str;
        }
        
        return new String(chs, 0, count);
    }
    	
    /**
     * Html 코드가 들어간 문서를 표시할때 태그에 손상없이 보이기 위한 메서드
     * 
     * @param strString
     * @return HTML 태그를 치환한 문자열
     */
    public static String checkHtmlView(String strString) {
		String strNew = "";
	
		try {
		    StringBuffer strTxt = new StringBuffer("");
	
		    char chrBuff;
		    int len = strString.length();
	
		    for (int i = 0; i < len; i++) {
			chrBuff = (char)strString.charAt(i);
	
				switch (chrBuff) {
				case '<':
				    strTxt.append("&lt;");
				    break;
				case '>':
				    strTxt.append("&gt;");
				    break;
				case '"':
				    strTxt.append("&quot;");
				    break;
				case 10:
				    strTxt.append("<br>");
				    break;
				case ' ':
				    strTxt.append("&nbsp;");
				    break;
				//case '&' :
				    //strTxt.append("&amp;");
				    //break;
				default:
				    strTxt.append(chrBuff);
				}
		    }
	
		    strNew = strTxt.toString();
	
		} catch (Exception ex) {
		    return null;
		}
	
		return strNew;
    }
	
	
    /**
     * 문자열을 지정한 분리자에 의해 배열로 리턴하는 메서드.
     * @param source 원본 문자열
     * @param separator 분리자
     * @return result 분리자로 나뉘어진 문자열 배열
     */
    public static String[] split(String source, String separator) throws NullPointerException {
        String[] returnVal = null;
        int cnt = 1;

        int index = source.indexOf(separator);
        int index0 = 0;
        while (index >= 0) {
            cnt++;
            index = source.indexOf(separator, index + 1);
        }
        returnVal = new String[cnt];
        cnt = 0;
        index = source.indexOf(separator);
        while (index >= 0) {
            returnVal[cnt] = source.substring(index0, index);
            index0 = index + 1;
            index = source.indexOf(separator, index + 1);
            cnt++;
        }
        returnVal[cnt] = source.substring(index0);
        
        return returnVal;
    }

    /**
     * 문자열을 지정한 분리자에 의해 지정된 길이의 배열로 리턴하는 메서드.
     * @param source 원본 문자열
     * @param separator 분리자
     * @param arraylength 배열 길이
     * @return 분리자로 나뉘어진 문자열 배열
     */
    public static String[] split(String source, String separator, int arraylength) throws NullPointerException {
        String[] returnVal = new String[arraylength];
        int cnt = 0;
        int index0 = 0;
        int index = source.indexOf(separator);
        while (index >= 0 && cnt < (arraylength - 1)) {
            returnVal[cnt] = source.substring(index0, index);
            index0 = index + 1;
            index = source.indexOf(separator, index + 1);
            cnt++;
        }
        returnVal[cnt] = source.substring(index0);
        if (cnt < (arraylength - 1)) {
            for (int i = cnt + 1; i < arraylength; i++) {
                returnVal[i] = "";
            }
        }
        
        return returnVal;
    }
    
    public static String[] getArray(Map<String, Object> commandMap, String obj){
    	String[] returnVal = new String[0];
    	
    	try{
    		
    		if( commandMap.get(obj).getClass() == null || !commandMap.get(obj).getClass().isArray() ){
    			returnVal = new String[1];
    			returnVal[0] = (String) commandMap.get(obj);
    		}else{
    			returnVal = (String[]) commandMap.get(obj);
    		}
    		
    	}catch(Exception e){
    	}
    	return returnVal;
    }

    /**
     * <p>{@link String#toLowerCase()}를 이용하여 소문자로 변환한다.</p>
     *
     * <pre>
     * StringUtil.lowerCase(null)  = null
     * StringUtil.lowerCase("")    = ""
     * StringUtil.lowerCase("aBc") = "abc"
     * </pre>
     *
     * @param str 소문자로 변환되어야 할 문자열
     * @return 소문자로 변환된 문자열, null이 입력되면 <code>null</code> 리턴
     */
    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        
        return str.toLowerCase();
    }
    
    /**
     * <p>{@link String#toUpperCase()}를 이용하여 대문자로 변환한다.</p>
     *
     * <pre>
     * StringUtil.upperCase(null)  = null
     * StringUtil.upperCase("")    = ""
     * StringUtil.upperCase("aBc") = "ABC"
     * </pre>
     *
     * @param str 대문자로 변환되어야 할 문자열
     * @return 대문자로 변환된 문자열, null이 입력되면 <code>null</code> 리턴
     */
    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        
        return str.toUpperCase();
    }
    
    /**
     * <p>입력된 String의 앞쪽에서 두번째 인자로 전달된 문자(stripChars)를 모두 제거한다.</p>
     *
     * <pre>
     * StringUtil.stripStart(null, *)          = null
     * StringUtil.stripStart("", *)            = ""
     * StringUtil.stripStart("abc", "")        = "abc"
     * StringUtil.stripStart("abc", null)      = "abc"
     * StringUtil.stripStart("  abc", null)    = "abc"
     * StringUtil.stripStart("abc  ", null)    = "abc  "
     * StringUtil.stripStart(" abc ", null)    = "abc "
     * StringUtil.stripStart("yxabc  ", "xyz") = "abc  "
     * </pre>
     *
     * @param str 지정된 문자가 제거되어야 할 문자열
     * @param stripChars 제거대상 문자열
     * @return 지정된 문자가 제거된 문자열, null이 입력되면 <code>null</code> 리턴
     */
    public static String stripStart(String str, String stripChars) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        int start = 0;
        if (stripChars == null) {
            while ((start != strLen) && Character.isWhitespace(str.charAt(start))) {
                start++;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1)) {
                start++;
            }
        }
        
        return str.substring(start);
    }


    /**
     * <p>입력된 String의 뒤쪽에서 두번째 인자로 전달된 문자(stripChars)를 모두 제거한다.</p>
     *
     * <pre>
     * StringUtil.stripEnd(null, *)          = null
     * StringUtil.stripEnd("", *)            = ""
     * StringUtil.stripEnd("abc", "")        = "abc"
     * StringUtil.stripEnd("abc", null)      = "abc"
     * StringUtil.stripEnd("  abc", null)    = "  abc"
     * StringUtil.stripEnd("abc  ", null)    = "abc"
     * StringUtil.stripEnd(" abc ", null)    = " abc"
     * StringUtil.stripEnd("  abcyx", "xyz") = "  abc"
     * </pre>
     *
     * @param str 지정된 문자가 제거되어야 할 문자열
     * @param stripChars 제거대상 문자열
     * @return 지정된 문자가 제거된 문자열, null이 입력되면 <code>null</code> 리턴
     */
    public static String stripEnd(String str, String stripChars) {
        int end;
        if (str == null || (end = str.length()) == 0) {
            return str;
        }

        if (stripChars == null) {
            while ((end != 0) && Character.isWhitespace(str.charAt(end - 1))) {
                end--;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                end--;
            }
        }
        
        return str.substring(0, end);
    }

    /**
     * <p>입력된 String의 앞, 뒤에서 두번째 인자로 전달된 문자(stripChars)를 모두 제거한다.</p>
     * 
     * <pre>
     * StringUtil.strip(null, *)          = null
     * StringUtil.strip("", *)            = ""
     * StringUtil.strip("abc", null)      = "abc"
     * StringUtil.strip("  abc", null)    = "abc"
     * StringUtil.strip("abc  ", null)    = "abc"
     * StringUtil.strip(" abc ", null)    = "abc"
     * StringUtil.strip("  abcyx", "xyz") = "  abc"
     * </pre>
     *
     * @param str 지정된 문자가 제거되어야 할 문자열
     * @param stripChars 제거대상 문자열
     * @return 지정된 문자가 제거된 문자열, null이 입력되면 <code>null</code> 리턴
     */
    public static String strip(String str, String stripChars) {
	if (isEmpty(str)) {
	    return str;
	}

	String srcStr = str;
	srcStr = stripStart(srcStr, stripChars);
	
	return stripEnd(srcStr, stripChars);
    }

    /**
     * 문자열을 다양한 문자셋(EUC-KR[KSC5601],UTF-8..)을 사용하여 인코딩하는 기능 역으로 디코딩하여 원래의 문자열을
     * 복원하는 기능을 제공함 String temp = new String(문자열.getBytes("바꾸기전 인코딩"),"바꿀 인코딩");
     * String temp = new String(문자열.getBytes("8859_1"),"KSC5601"); => UTF-8 에서
     * EUC-KR
     * 
     * @param srcString
     *            - 문자열
     * @param srcCharsetNm
     *            - 원래 CharsetNm
     * @param charsetNm
     *            - CharsetNm
     * @return 인(디)코딩 문자열
     * @exception MyException
     * @see
     */
    public static String getEncdDcd(String srcString, String srcCharsetNm, String cnvrCharsetNm) {

	String rtnStr = null;

	if (srcString == null)
	    return null;

	try {
	    rtnStr = new String(srcString.getBytes(srcCharsetNm), cnvrCharsetNm);
	} catch (UnsupportedEncodingException e) {
	    rtnStr = null;
	}

	return rtnStr;
    }

/**
     * 특수문자를 웹 브라우저에서 정상적으로 보이기 위해 특수문자를 처리('<' -> & lT)하는 기능이다
     * @param 	srcString 		- '<' 
     * @return 	변환문자열('<' -> "&lt"
     * @exception MyException 
     * @see  
     */
    public static String getSpclStrCnvr(String srcString) {

	String rtnStr = null;

	try {
	    StringBuffer strTxt = new StringBuffer("");

	    char chrBuff;
	    int len = srcString.length();

	    for (int i = 0; i < len; i++) {
		chrBuff = (char)srcString.charAt(i);

		switch (chrBuff) {
		case '<':
		    strTxt.append("&lt;");
		    break;
		case '>':
		    strTxt.append("&gt;");
		    break;
		case '&':
		    strTxt.append("&amp;");
		    break;
		default:
		    strTxt.append(chrBuff);
		}
	    }

	    rtnStr = strTxt.toString();

	} catch (Exception e) {
		logger.debug(e.getMessage());//e.printStackTrace();
	}

	return rtnStr;
    }

    /**
     * 응용어플리케이션에서 고유값을 사용하기 위해 시스템에서17자리의TIMESTAMP값을 구하는 기능
     * 
     * @param
     * @return Timestamp 값
     * @exception MyException
     * @see
     */
    public static String getTimeStamp() {

	String rtnStr = null;

	// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
	String pattern = "yyyyMMddhhmmssSSS";

	try {
	    SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
	    Timestamp ts = new Timestamp(System.currentTimeMillis());

	    rtnStr = sdfCurrent.format(ts.getTime());
	} catch (Exception e) {
		logger.debug(e.getMessage());//e.printStackTrace();
	}

	return rtnStr;
    }
    
    /**
     * html의 특수문자를 표현하기 위해
     * 
     * @param srcString
     * @return String
     * @exception Exception
     * @see
     */    
    public static String getHtmlStrCnvr(String srcString) {
    	
    	String tmpString = srcString;
    	
		try 
		{
			tmpString = tmpString.replaceAll("&lt;", "<");
			tmpString = tmpString.replaceAll("&gt;", ">");
			tmpString = tmpString.replaceAll("&amp;", "&");
			tmpString = tmpString.replaceAll("&nbsp;", " ");
			tmpString = tmpString.replaceAll("&apos;", "\'");
			tmpString = tmpString.replaceAll("&quot;", "\"");
		}
		catch (Exception ex)
		{
			logger.debug(ex.getMessage());//ex.printStackTrace();
		}

		return  tmpString;
	
	}    

    /**
     * commandMap의 값을 QueryString 형식으로 생성 반환한다.
     * @param commandMap
     * @return String
     */
    public static String getQueryString(Map<String, String> commandMap)
    {
        return getQueryString(commandMap, null);
    }

    /**
     * commandMap의 값을 QueryString 형식으로 생성 반환한다.
     * @param commandMap
     * @param removeParams 제거하고자하는 파라메터명 (ex param1,params2,param3...)
     * @return String
     */
    public static String getQueryString(Map<String, String> commandMap, String removeParams)
    {
        // 기본 제거 값 //
        removeParams = "," + removeParams + ",authsGrade,lang_code,menuTCd,menuLCd,";

        StringBuilder result = new StringBuilder();
        for(String key : commandMap.keySet())
        {
            if (removeParams.indexOf("," + key + ",") == -1)
                result.append("&" + key + "=" + commandMap.get(key));
        }

        if (result.length() > 0)
            return result.toString().substring(1);
        else
            return "";
    }

    /**
     * 1. MethodName	: getInt
     * 2. ClassName		: StringUtil
     * 3. Commnet		: 숫자형으로 변환
     * @return int
     * @param str
     * @return
     */
    public static int getInt(Object obj){
        if(obj == null || obj.toString().equals("")) {
            return 0;
        } else {
            if (Integer.parseInt(obj.toString()) <= 0){
                return 0;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 1. MethodName	: getInt
     * 2. ClassName		: StringUtil
     * 3. Commnet		: 숫자형으로 변환, Null이거나 0이면 기본값 세팅
     * @return int
     * @param str
     * @return
     */
    public static int getInt(Object obj, int defNum){
        if(obj == null || obj.toString().equals("")) {
            return defNum;
        } else {
            if(obj.toString().indexOf(".") != -1){
                int temp = obj.toString().indexOf(".");
                String tempObj = getString(obj);
                obj = tempObj.substring(0, temp);
            }
            if (Integer.parseInt(obj.toString()) <= 0){
                return defNum;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }

    /**
     * 1. MethodName	: getString
     * 2. ClassName		: StringUtil
     * 3. Commnet		: 문자열으로 변환
     * @return String
     * @param obj
     * @param defStr
     * @return
     */
    public static String getString(Object obj){
        if(obj == null || obj.toString().equals("")) {
            return "";
        } else {
            if ("".equals(obj.toString())){
                return "";
            } else {
                return obj.toString();
            }
        }
    }
    
    /**
     * 1. MethodName	: getString
     * 2. ClassName		: StringUtil
     * 3. Commnet		: 문자열으로 변환, Null이거나 ""이면 기본값 세팅
     * @return String
     * @param obj
     * @param defStr
     * @return
     */
    public static String getString(Object obj, String defStr){
        if(obj == null || obj.toString().equals("")) {
            return defStr;
        } else {
            if ("".equals(obj.toString())){
                return defStr;
            } else {
                return obj.toString();
            }
        }
    }

    /**
     * 인젝션 처리 위한 문자열 번환
     * 
     * @param value
     * @return String
     * @exception 
     * @see
     */    
    public static String setInjectionReplace(String value){
    	// Avoid null characters
        value = value.replaceAll("", "");

        // Avoid anything between script tags
        Pattern scriptPattern = Pattern.compile("<script", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-script");

        // Remove any lonesome </script> tag
        scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-/script>");
        
        scriptPattern = Pattern.compile("<xmp", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-xmp");
        
        scriptPattern = Pattern.compile("<title", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-title");
        
        scriptPattern = Pattern.compile("<textarea", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-textarea");
        
        scriptPattern = Pattern.compile("</textarea", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-/textarea");
        /*
        scriptPattern = Pattern.compile("<iframe", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-iframe");
        
        scriptPattern = Pattern.compile("</iframe", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("<x-/iframe");
        */

        // Avoid eval(...) expressions
        scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll("");

        // Avoid expression(...) expressions
        scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll("");

        // Avoid javascript:... expressions
        scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("");

        // Avoid vbscript:... expressions
        scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll("");

        // Avoid onload= expressions
        scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll("");
        
        return value;
    }

    /**
     * 1. MethodName	: fillLeft
     * 2. ClassName		: StringUtil
     * 3. Commnet		: 입력된 문자열의 왼쪽에 index의 길이만큼 문자열을 붙여 반환한다.
     * @return String 추가된 문자열
     * @param str 문자열
     * @param index 문자열이 붙여진 후 최종 문자열의 길이
     * @param addStr 추가하여 붙일 문자
     * @return
     */
    public static String fillLeft(String str, int index, String addStr) {
        int gap = 0;
        if ((str!=null) && (addStr!=null) && (str.length()<=index)) {
            gap = index - str.length();

            for(int i=0 ; i<gap ; i++) {
                str = addStr + str;
            }
        }

        return str;
    }
    
    /**
     * <pre>
     * 1. MethodName : fillRight
     * 2. ClassName  : StringUtil.java
     * 3. Comment    : 입력된 문자열의 오른쪽에 index의 길이만큼 문자열을 붙여 반환한다. 
     * </pre>
     *
     * @param str
     * @param index
     * @param addStr
     * @return
     */
    public static String fillRight(String str, int index, String addStr) {
    	int gap = 0;
    	if ((str!=null) && (addStr!=null) && (str.length()<=index)) {
    		gap = index - str.length();
    		
    		for(int i=0 ; i<gap ; i++) {
    			str += addStr;
    		}
    	}
    	
    	return str;
    }
    
    /**
    * <pre>
    * 1. MethodName : getCutStringByte
    * 2. ClassName  : StringUtil.java
    * 3. Comment    : 문자열을 일정길이 만큼 자르고, 그 길이에 초과되는 문자열일 경우 특정문자를 덧붙여 반환한다. 
    * </pre>
    *
    * @param str
    * @param pstr
    * @param cutLength
    * @return
    */
    public static String getCutStringByte (String str, String pstr, String cutLength)
    {
        int rSize = 0;
        int len = 0;
        int iCurLength = Integer.parseInt(cutLength);
        if(str.getBytes().length > iCurLength)
        {
            for(;rSize < str.length();rSize++)
            {
                if(str.charAt(rSize) > 0x007f)
                {
                    len += 2;
                }
                else
                {
                    len++;
                }
                if(len > iCurLength)
                {
                    break;
                }
            }
            str = str.substring(0, rSize) + pstr;
        }
        return str;
    }
    
    /**
        * <pre>
        * 1. MethodName : searchReset
        * 2. ClassName  : StringUtil.java
        * 3. Comment    : 검색조건을 제외한 나머지 필드 제거 
        * </pre>
        *
        * @param map
     */
    public static void searchReset(Map<String, Object> map)
    {
    	Iterator<String> it = map.keySet().iterator();
        while ( it.hasNext() )
        {
        	String itv =it.next();
        	
        	if(itv.indexOf("search")==-1 && itv.indexOf("cPage")==-1 && itv.indexOf("pageSize")==-1)
        	{
        		it.remove();	
        	}
        }
    }
    
    public static String substring_byte(String strData, int iStartPos, int iByteLength) {
		byte[] bytTemp = null;
		int iRealStart = 0;
		int iRealEnd = 0;
		int iLength = 0;
		int iChar = 0;
		
		try {
			// UTF-8로 변환하는경우 한글 2Byte, 기타 1Byte로 떨어짐
			bytTemp = strData.getBytes("EUC-KR");
			iLength = bytTemp.length;


			for(int iIndex = 0; iIndex < iLength; iIndex++) {
				if(iStartPos <= iIndex) {
					break;
				}
				iChar = (int)bytTemp[iIndex];
				if((iChar > 127)|| (iChar < 0)) {
					// 한글의 경우(2byte 통과처리)
					// 한글은 2Byte이기 때문에 다음 글자는 볼것도 없이 스킵한다
					iRealStart++;
					iIndex++;
				} else {
					// 기타 글씨(1Byte 통과처리)
					iRealStart++;
				}
			}
			
			iRealEnd = iRealStart;
			int iEndLength = iRealStart + iByteLength;
			for(int iIndex = iRealStart; iIndex < iEndLength; iIndex++)
			{
				iChar = (int)bytTemp[iIndex];
				if((iChar > 127)|| (iChar < 0)) {
					// 한글의 경우(2byte 통과처리)
					// 한글은 2Byte이기 때문에 다음 글자는 볼것도 없이 스킵한다
					iRealEnd++;
					iIndex++;
				} else {
					// 기타 글씨(1Byte 통과처리)
					iRealEnd++;
				}
			}
		} catch(Exception e) {
				e.printStackTrace();
		}

		return strData.substring(iRealStart, iRealEnd);
    } 
    
    public static void getCheckboxs(Map<String, Object> commandMap, String obj){
    	if(commandMap.get(obj) != null && !"".equals(commandMap.get(obj)))
        {
        	String[] checkboxs = StringUtil.getString(commandMap.get(obj)).split(",");
            if(checkboxs.length > 1)
            {
                commandMap.put(obj, checkboxs);
            }
            else
            {
                commandMap.put(obj, StringUtil.getArray(commandMap, obj));    
            }
        }
    }
    
    /**
     * <pre>
     * 1. MethodName : getRandomNumber
     * 2. ClassName  : StringUtil.java
     * 3. Comment    : 주문번호 랜덤 숫자 생성
     * </pre>
     * @param len 랜덤숫자 갯수
     * @return
     */
    public static String getRandomNumber(int len)
    {
        String randomNumber = "";
        
        for (int i = 0; i < len; i++) 
        {
            randomNumber += StringUtil.getString((int)(Math.random() * 9) + 1 );
        }
        
        return randomNumber;     
    }
    
    
    
    
    
	
  
    
    //==================== JAVA 유효성 검사 로직 추가 / 2018.10.24 / inup.oh ====================
    
    /**
     * 날짜 형식 유효성 검사
     * @param date
     * @return
     */
    public static boolean isDate(String date)
    {
    	String dateValue = date.replaceAll("\\-", "").replaceAll("\\.",  "");
    
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    	
    	try {
    		Date dt = formatter.parse(dateValue);
    	} catch(Exception e) {
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * 날짜 형식 스트링 조회
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDateString(String year, String month, String day) {
    	String strRtn = null;
/*    	if (!StringUtils.isEmpty(year) && !StringUtils.isEmpty(year) && !StringUtils.isEmpty(year)) {
        	String strMonth = StringUtils.lPad(month, 2, '0');
        	String strDay = StringUtils.lPad(day, 2, '0');
        	strRtn = year + "-" + strMonth + "-" + strDay;
    	}*/
    	return strRtn;
    }
    /**
     * 날짜 형식 스트링 조회
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDateString(String date) {
    	String strRtn = null;
    	
/*    	if (!StringUtils.isEmpty(date)) {
    		String year = date.substring(0, 4);
    		String month = date.substring(4, 6);
    		String day = date.substring(6, 8);
        	strRtn = year + "-" + month + "-" + day;
    	}*/
    	return strRtn;
    }
    
    public static String getDateString() {
 
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String strRtn = dateFormat.format(date); //2016/11/16 12:08:43
    	return strRtn;
    }
       
    
    /**
     * 생년월일 유효성 검사
     * @param year
     * @param month
     * @param day
     * @return
     */
/*    public static boolean isBirthDay(String year, String month, String day) {
    	return isBirthDay(getDateString(year, month, day));
    }*/
    
    /**
     * 생년월일 유효성 검사
     * @param date
     * @param minYear
     * @param maxYear
     * @return
     */
/*    public static boolean isBirthDay(String date)
    {
    	
    	if (!isDate(date)) {
    		return false;
    	}
    	
     	int birthYear = Integer.parseInt(date.substring(0, 4));
     	int nowYear = Calendar.getInstance().get(Calendar.YEAR);
    	int minYear = Integer.parseInt(getCodeDetail("CONFIG", "user.join.minyear"));
    	int maxYear = Integer.parseInt(getCodeDetail("CONFIG", "user.join.maxyear"));
    	
    	// 현재 날짜가 minYear 보다 크거나 같고 maxYear 보다 작거나 같다면
    	boolean bRtn = (birthYear >= (nowYear - minYear) && birthYear <= (nowYear - maxYear)) ? true : false;
 
//    	System.out.println("(birthYear >= (nowYear - minYear) && birthYear <= (nowYear - maxYear))");
//    	System.out.println("(" + birthYear + " >= (" + nowYear + " - " + minYear + ") && " + birthYear + " <= (" + nowYear + " - " + maxYear + "))");
//    	System.out.println("::::::::::::" + Boolean.toString(bRtn));
    	
    	return bRtn;

    }*/
 

	/**
     * 코드 상세 조회
     * @param codeType
     * @param id
     * @return
     */
/*    public static String getCodeDetail(String codeType, String id) {

       	CodeInfo codeInfo = CodeUtils.getCodeInfo(codeType, id);
    	return codeInfo.getDetail();
   	
    }*/
    
    /**
     * 모바일 번호 스트링 조회
     * @param number1
     * @param number2
     * @param number3
     * @return
     */
    public static String getMobileNoString(String number1, String number2, String number3) {
    	return number1 + "-" + number2 + "-" + number3;
    }
    /**
     * 휴대폰 번호 유효성 검사
     * @param number
     * @return
     */
/*    public static boolean isMobileNo(String number) {
    	return checkPattern("mobile", number);
    }
    public static boolean isMobileNo(String number1, String number2, String number3) {
    	return isMobileNo(getMobileNoString(number1, number2, number3));
    }
    public static boolean isLoginId(String loginId) {
    	return checkPattern("loginId", loginId);
    }
    public static boolean isPassword(String password) {
    	return checkPattern("password", password);
    }
    public static boolean isEmail(String email) {
    	return checkPattern("email", email);
    }*/
	/**
	* 정규식 패턴 검증
	* @param pattern
	* @param str
	* @return
	*/
	/*public static boolean checkPattern(String pattern, String str){
		boolean okPattern = false;
		String regex = null;

		pattern = pattern.trim();

		//숫자 체크
		if(StringUtils.equals("num", pattern)){
			regex = "^[0-9]*$";
		}

		//영문 체크

		//이메일 체크
		if(StringUtils.equals("email", pattern)){
			regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		}
		//이메일 체크2
		if(StringUtils.equals("email2", pattern)){
			regex = "^[-a-z0-9~!$%^&amp;*_=+}{&#39;?]+(\\.[-a-z0-9~!$%^&amp;*_=+}{&#39;?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$";
		}
		
		

		//전화번호 체크
		if(StringUtils.equals("tel", pattern)){
			regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		}

		//휴대폰번호 체크
		if(StringUtils.equals("mobile", pattern)){
			regex = "^01(0|1|6|7|8|9)-(?:\\d{3}|\\d{4})-\\d{4}$";
		}
		
		//아이디체크
		if(StringUtils.equals("loginId", pattern)){
			regex = "^[A-Za-z0-9]{4,12}$";
		}
		//비밀번호체크
		if(StringUtils.equals("password", pattern)){
			regex = "^((?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{10,}|(?=.*[0-9])(?=.*[!@#$%^&amp;*])[a-zA-Z0-9!@#$%^&amp;*]{8,})$";
		}		

		
		
		okPattern = Pattern.matches(regex, str);
		return okPattern;
	}*/
}
