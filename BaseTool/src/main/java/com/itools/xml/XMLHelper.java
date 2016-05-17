package com.itools.xml;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/5/13.
 */
public class XMLHelper {
    private static final String  XML_NODE = "<{NODENAME}><![CDATA[{NODEVALUE}]]></{NODENAME}>";

    /**
     * 将Map对象转换成xml字符串，如果存在多级节点，子节点应该为Map对象
     * @param map
     * @param keyUpper
     * @return
     */
    public static String map2XmlStr(Map<String,Object> map,boolean keyUpper){
        StringBuilder sb = new StringBuilder(keyUpper ? "<XML>" : "<xml>");
        sb.append(parseNode(map,keyUpper));
        sb.append(keyUpper ? "</XML>" : "</xml>");
        return sb.toString();
    }

    /**
     * 将Map转换成xml节点字串
     * @param map
     * @param keyUpper
     * @return
     */
    private static String parseNode(Map<String,Object> map,boolean keyUpper){
        StringBuilder sb = new StringBuilder();
        String key;
        Object value;
        for(Iterator<String> it = map.keySet().iterator();it.hasNext();){
            key = it.next();
            value = map.get(key);
            if(value == null)
                continue;
            if(keyUpper) key = key.toUpperCase();
            if(value instanceof Map)
                sb.append(XML_NODE.replace("{NODENAME}",key).replace("{NODEVALUE}",parseNode((Map<String,Object>)value,keyUpper)));
            else
                sb.append(XML_NODE.replace("{NODENAME}",key).replace("{NODEVALUE}",String.valueOf(value)));
        }
        return sb.toString();
    }
    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String,String> xmlStr2Map(String strxml){
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if (null == strxml || "".equals(strxml)) {
            return null;
        }

        Map m = new HashMap();

        InputStream in = null;
        try {
            in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(in);
            Element root = doc.getRootElement();
            List list = root.getChildren();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String k = e.getName();
                String v = "";
                List children = e.getChildren();
                if (children.isEmpty()) {
                    v = e.getTextNormalize();
                } else {
                    v = getChildrenText(children);
                }

                m.put(k, v);
            }

            //关闭流
            in.close();
        }catch(Exception e){
            return null;
        }finally{
            if(in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return m;
    }

    /**
     * 获取子结点的xml
     *
     * @param children
     * @return String
     */
    private static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }

}
