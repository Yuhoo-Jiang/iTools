import com.itools.xml.XMLHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/5/13.
 */
public class xmlHelperTest {
    @Test
    public void testString2Map(){
        String xml = "<xml><appid><![CDATA[wx2421b1c4370ec43b]]></appid><attach><![CDATA[支付测试]]></attach><bank_type><![CDATA[CFT]]></bank_type><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[10000100]]></mch_id><nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str><openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid><out_trade_no><![CDATA[1409811653]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign><sub_mch_id><![CDATA[10000100]]></sub_mch_id><time_end><![CDATA[20140903131540]]></time_end> <total_fee>1</total_fee>  <trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id></xml>";
        Map<String,String> map = XMLHelper.xmlStr2Map(xml);
        System.out.println(map.size());

    }
    @Test
    public void testMap2XmlStr(){
        String xml = "<xml><appid><![CDATA[wx2421b1c4370ec43b]]></appid><attach><![CDATA[支付测试]]></attach><bank_type><![CDATA[CFT]]></bank_type><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[10000100]]></mch_id><nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str><openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid><out_trade_no><![CDATA[1409811653]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign><sub_mch_id><![CDATA[10000100]]></sub_mch_id><time_end><![CDATA[20140903131540]]></time_end> <total_fee>1</total_fee>  <trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id></xml>";
        Map<String,String> map1 = XMLHelper.xmlStr2Map(xml);
        Map<String,Object> map = new HashMap<String, Object>();
        String key;
        Object value;
        for(Iterator<String> it = map1.keySet().iterator(); it.hasNext();){
            key = it.next();
            value = map1.get(key);
            map.put(key,value);
        }
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("dddd",1);
        map2.put("dddd2",2);
        map.put("aaa",map2);
        System.out.println(XMLHelper.map2XmlStr(map,true));
    }
}